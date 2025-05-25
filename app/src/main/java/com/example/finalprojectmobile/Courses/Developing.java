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
        items.add(new CoursesDomain("Learn from the basic", 29, "c_ic"));
        items.add(new CoursesDomain("Get started in Mobile development", 69, "kotlin_ic"));
        items.add(new CoursesDomain("Fundamental of Java Programming", 150, "ic_3"));
        items.add(new CoursesDomain("Welcome to Python", 79, "python_ic"));
        items.add(new CoursesDomain("Advanced certification in Mobile", 149, "flutter_ic"));

        recyplerViewCourse = findViewById(R.id.courses_view);
        recyplerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterCoureList = new CoursesAdapter(items);
        recyplerViewCourse.setAdapter(adapterCoureList);
    }
}
