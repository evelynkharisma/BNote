package com.segid.bnote.Object;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by User on 1/21/2016.
 */
public class User implements Serializable{
    private String username;
    private String userid;
    private String password;
    private Uri filepath;
    private ArrayList<Course> courses;

    private static final long serialVersionUID = 465489764;

    /*public User(String username, String userid, Uri filepath, ArrayList<String> courses)
    {
        this.username = username;
        this.userid = userid;
        this.filepath = filepath;
        this.courses = courses;
    }*/

    public User() {
        courses = new ArrayList<>();
    }

    public User(String id, String name, String pass) {
        setUserid(id);
        setUsername(name);
        setPassword(pass);
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
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

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
