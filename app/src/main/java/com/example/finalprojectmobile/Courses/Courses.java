package com.example.finalprojectmobile.Courses;

public class Courses {
    private String title;
    private String videoId;

    public Courses() {
        // Empty constructor needed for Firestore
    }

    public Courses(String title, String videoId) {
        this.title = title;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoId() {
        return videoId;
    }
}
