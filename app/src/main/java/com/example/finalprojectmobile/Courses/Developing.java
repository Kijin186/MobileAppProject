package com.example.finalprojectmobile.Courses;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectmobile.Activity.MainActivity;
import com.example.finalprojectmobile.Adapter.CoursesAdapter;
import com.example.finalprojectmobile.Domain.CoursesDomain;
import com.example.finalprojectmobile.R;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;


import java.util.ArrayList;

public class Developing extends AppCompatActivity {

    private RecyclerView.Adapter adapterCoureList;
    private RecyclerView recyplerViewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.courses);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.courses), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRecyclerView();

        ConstraintLayout backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(Developing.this, MainActivity.class)));
    }
    private void initRecyclerView() {
        ArrayList<CoursesDomain> items = new ArrayList<>();
        items.add(new CoursesDomain("Learn from the basic", "c_ic", "-TkoO8Z07hI"));
        items.add(new CoursesDomain("Get started in Mobile development", "kotlin_ic","blKkRoZPxLc"));
        items.add(new CoursesDomain("Fundamental of Java Programming", "ic_3", "xTtL8E4LzTQ"));
        items.add(new CoursesDomain("Welcome to Python", "python_ic", "ix9cRaBkVe0"));
        items.add(new CoursesDomain("Advanced certification in Mobile","flutter_ic", "3kaGC_DrUnw"));

        recyplerViewCourse = findViewById(R.id.courses_view);
        recyplerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterCoureList = new CoursesAdapter(items);
        recyplerViewCourse.setAdapter(adapterCoureList);
    }
}
