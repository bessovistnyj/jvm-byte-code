package ru.napadovskiu.items;

import java.util.Date;

/**
 //*Class Item
 *@author napadovskiy
 *@since 13.09.2016
 *@version 1
*/

public class Item {
    private String id;
    private String name;
    private long createDate;
	private String description;
    private Comments[] comments = new Comments[10];
    private int commentPosition = 0;

    public Item(){

    }

    public Item(String name, String desc){
        this.name = name;
        this.description = desc;
	}

  	public void setId(String id){
        this.id = id;
    }

  	public void setCreateDate(long createDate){
        this.createDate = createDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setComment(Comments comment) {
        this.comments[this.commentPosition] = comment;
    }

    public String getId(){
        return this.id;
    }

    public long getCreateDate(){
        return this.createDate;
    }

    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
    }

    public Comments addComment(Comments comment) {
        comments[this.commentPosition++] = comment;
        return comment;
    }

    public String getComment() {
        String result = "";
        for (int i = 0; i < comments.length; i++){
            if (comments[i]!=null){
                result = comments[i].getComment();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        Date date = new Date(this.createDate);
		return "id: " + this.id + ";   name: " + this.name + ";   description: " + this.description + ";   comments: " + this.getComment() + "; date: "+date;
    }
}