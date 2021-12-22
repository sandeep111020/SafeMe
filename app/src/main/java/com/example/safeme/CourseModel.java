package com.example.safeme;

public class CourseModel{


    String title;
    String objective;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public CourseModel() {
    }

    public CourseModel(String title,String objective) {
        this.title=title;
        this.objective=objective;
    }






}