package com.example.finalprojectmobile.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.finalprojectmobile.Courses.AIAndML;
import com.example.finalprojectmobile.Courses.CourseListActivity;
import com.example.finalprojectmobile.Courses.Designing;
import com.example.finalprojectmobile.Courses.Developing;
import com.example.finalprojectmobile.Courses.More;
import com.example.finalprojectmobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Navigate Developing
        ConstraintLayout btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Developing.class)));
        //Navigate Designing
        ConstraintLayout btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Designing.class)));
        //Navigate AI and ML
        ConstraintLayout btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AIAndML.class)));
        //Navigate More
        ConstraintLayout btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, More.class)));
        //Navigate popular courses
        TextView saBtn = findViewById(R.id.sabtn);
        saBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CourseListActivity.class)));
    }
}