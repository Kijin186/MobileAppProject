package com.example.finalprojectmobile.Domain;

public class CoursesDomain {
    private String title;
    private String picPath;
    private String videoId;

    public CoursesDomain(String title, String picPath, String videoId) {
        this.title = title;
        this.picPath = picPath;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getVideoId() {  // ✅ Correct getter method
        return videoId;
    }

    public void setVideoId(String videoId) {  // ✅ Optional: add setter if needed
        this.videoId = videoId;
    }
}
