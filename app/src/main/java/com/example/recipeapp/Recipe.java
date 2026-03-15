package com.example.recipeapp;

public class Recipe {

    String title;
    String time;
    int imageResource;
    boolean favorite;

    public Recipe(String title, String time, int imageResource){
        this.title = title;
        this.time = time;
        this.imageResource = imageResource;
        this.favorite = false;
    }

    public String getTitle(){
        return title;
    }

    public String getTime(){
        return time;
    }

    public int getImageResource(){
        return imageResource;
    }

    public boolean isFavorite(){
        return favorite;
    }

    public void setFavorite(boolean favorite){
        this.favorite = favorite;
    }
}