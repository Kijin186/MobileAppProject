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

public class CourseListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterCoureList;
    private RecyclerView recyplerViewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.popular_courses), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRecyclerView();

        ConstraintLayout backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(CourseListActivity.this, MainActivity.class)));
    }
    private void initRecyclerView() {
        ArrayList<CoursesDomain> items = new ArrayList<>();
        items.add(new CoursesDomain("Advanced certification Program in AI", "ic_1", "dJhlMn2otxA"));
        items.add(new CoursesDomain("Google Cloud Platform Architecture","ic_2", "IUU6OR8yHCc"));
        items.add(new CoursesDomain("Fundamental of Java Programming", "ic_3", "xTtL8E4LzTQ"));
        items.add(new CoursesDomain("Introduction to UI design history", "ic_4", "hs-yH-WnjBQ"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering", "ic_5", "bAyrObl7TYE"));

        recyplerViewCourse = findViewById(R.id.popular_courses_view);
        recyplerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterCoureList = new CoursesAdapter(items);
        recyplerViewCourse.setAdapter(adapterCoureList);
    }
}