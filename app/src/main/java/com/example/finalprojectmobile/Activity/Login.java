package com.example.finalprojectmobile.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalprojectmobile.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private TextView signupRedirectText;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        TextView nologin = findViewById(R.id.no_login);
        nologin.setOnClickListener(v -> startActivity(new Intent(Login.this, MainActivity.class)));

        auth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signupRedirectText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Login.this, MainActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        loginPassword.setError("Password cannot empty");
                    }
                } else if(email.isEmpty()) {
                    loginEmail.setError("Email cannot empty");
                } else {
                    loginEmail.setError("Invalid Email");
                }
            }
            });
            signupRedirectText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Login.this, SignUp.class));
                }
        });
    }
}
