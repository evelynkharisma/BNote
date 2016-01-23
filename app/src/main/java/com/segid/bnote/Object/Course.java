package com.segid.bnote.Object;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by janistan on 1/23/2016.
 */

public class Course implements Serializable {
    private int semester;
    private String courseName;
    private String courseID;
    private Uri filepath;
    private ArrayList<Note> notes;

    public Course(int smt, String name) {
        notes = new ArrayList<Note>();

        setSemester(smt);
        setCourseName(name);

    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public int getSemester() {
        return this.semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public Uri getFilePath() {
        return filepath;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setSemester(int smt) {
        this.semester = smt;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public void setCourseID(String id) {
        this.courseID = id;
    }

    public void setFilePath(Uri path) {
        this.filepath = path;
    }

    public void setNotes(ArrayList<Note> listNotes) {
        this.notes = listNotes;
    }

}
