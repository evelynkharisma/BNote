package com.segid.bnote;

import java.util.ArrayList;

/**
 * Created by User on 1/21/2016.
 */
public class User {
    private String username;
    private String userid;
    private ArrayList<String> courses;

    public User(String username, String userid, ArrayList<String> courses)
    {
        this.username = username;
        this.userid = userid;
        this.courses = courses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
}
