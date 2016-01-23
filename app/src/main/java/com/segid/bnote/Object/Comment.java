package com.segid.bnote.Object;

import android.net.Uri;

import java.util.Date;

/**
 * Created by janistan on 1/23/2016.
 */
public class Comment {

    private String commentID;
    private String comment;
    private Uri filepath;
    private Date date;

    public Comment(String id, String comment, Date date) {
        setCommentID(id);
        setComment(comment);
        setDate(date);
    }

    public String getCommentID() {
        return this.commentID;
    }

    public String getComment() {
        return this.comment;
    }

    public Uri getFilepath() {
        return this.filepath;
    }

    public Date getDate() {
        return this.date;
    }

    public void setCommentID(String id) {
        this.commentID = id;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setFilepath(Uri path){
        this.filepath = path;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}