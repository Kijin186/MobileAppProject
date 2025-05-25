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

public class More extends AppCompatActivity {
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
        backBtn.setOnClickListener(v -> startActivity(new Intent(More.this, MainActivity.class)));
    }
    private void initRecyclerView() {
        ArrayList<CoursesDomain> items = new ArrayList<>();
        items.add(new CoursesDomain("Engaging in to the game industry with Unity", 169, "unity_ic"));
        items.add(new CoursesDomain("Google Cloud Platform Architecture",69,"ic_2"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering",49,"ic_5"));

        recyplerViewCourse = findViewById(R.id.courses_view);
        recyplerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterCoureList = new CoursesAdapter(items);
        recyplerViewCourse.setAdapter(adapterCoureList);
    }
}
