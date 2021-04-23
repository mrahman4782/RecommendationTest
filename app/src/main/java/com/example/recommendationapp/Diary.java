package com.example.recommendationapp;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Diary")
public class Diary extends ParseObject {

    public static final String KEY_CONTENT = "content";
    public static final String KEY_USER = "author";

    public String getContent(){
        return getString(KEY_CONTENT);
    }

    public void setContent(String content){
        put(KEY_CONTENT,content);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER,user);

    }


}
