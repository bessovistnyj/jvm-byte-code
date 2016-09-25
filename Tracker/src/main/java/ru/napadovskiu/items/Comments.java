package ru.napadovskiu.items;

/**
 * Created by program on 25.09.2016.
 */
public class Comments {

    private String comment;

    public Comments(String text) {
        this.comment = text;
    }

    public Comments() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return comment;
    }

}
