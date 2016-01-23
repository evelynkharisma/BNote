package com.segid.bnote.Object;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by janistan on 1/23/2016.
 */
public class Note {
    private String decsription;
    private String noteName;
    private String noteID;
    private String imagePath;
    private Uri filepath;
    private Date date;
    private ArrayList<CommentNote> comments;

    public Note() {}

    public Note(String desc, Date dateNote) {
        setDecsription(desc);
        setDate(dateNote);
    }

    public String getDecsription() {
        return this.decsription;
    }
    public String getNoteName() {
        return this.noteName;
    }

    public String getNoteID() {
        return this.noteID;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Uri getFilePath() {
        return this.filepath;
    }

    public Date getDate() {
        return this.date;
    }

    public ArrayList<CommentNote> getComments() {
        return this.comments;
    }

    public void setDecsription(String desc) {
        this.decsription = desc;
    }

    public void setNoteName(String name) {
        this.noteName = name;
    }

    public void setNoteID(String id) {
        this.noteID = id;
    }

    public void setImagePath(String imgPath) {
        this.imagePath = imgPath;
    }

    public void setFilepath(Uri path) {
        this.filepath = path;
    }

    public void setDate(Date commentDate) {
        this.date = commentDate;
    }

    public void setComment(ArrayList<CommentNote> listComment) {
        this.comments = listComment;
    }

}
