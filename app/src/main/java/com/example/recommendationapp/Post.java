package com.example.recommendationapp;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject{

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "author";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_CATEGORY = "Category";
    public static final String KEY_ID = "objectId";

    public static final String KEY_LIKE = "Likes";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description){
        put(KEY_DESCRIPTION,description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE,parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        put(KEY_USER,user);
    }

    public String getCategory(){
        return getString(KEY_CATEGORY);
    }

    public void setCategory(String category){
        put(KEY_CATEGORY,category);
    }

    public Number getLike(){
        return getNumber(KEY_LIKE);
    }

    public void setLike(Number like){
        put(KEY_LIKE,like);
    }


    public String getId(){
        return getString(KEY_ID);
    }



    //no need to set time
    public String getFormattedTimestamp(){
        return TimeFormatter.getTimeDifference(KEY_CREATED_KEY);
    }




}
