package com.example.myapptest.model;

public class Exhibit {

    private String image;
    private int stars;
    private String name;
    private String description;
    private String[] comments;

    public Exhibit(String image, int stars, String name, String description, String[] comments) {
        this.image = image;
        this.stars = stars;
        this.name = name;
        this.description = description;
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
