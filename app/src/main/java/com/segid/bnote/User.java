package com.segid.bnote;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by User on 1/21/2016.
 */
public class User implements Serializable{
    private String username;
    private String userid;
    private Uri filepath;
    private ArrayList<String> courses;

    private static final long serialVersionUID = 465489764;

    /*public User(String username, String userid, Uri filepath, ArrayList<String> courses)
    {
        this.username = username;
        this.userid = userid;
        this.filepath = filepath;
        this.courses = courses;
    }*/

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

    public Uri getFilepath() {
        return filepath;
    }

    public void setFilepath(Uri filepath) {
        this.filepath = filepath;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
}
