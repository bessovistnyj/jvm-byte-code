package ru.napadovskiu.items;

import java.util.Date;

/**
 //*Class Item
 *@author napadovskiy
 *@since 13.09.2016
 *@version 1
*/

public class Item {
    /**
     *Id item.
     */
    private String id;

    /**
     * Name item.
     */
    private String name;

    /**
     *Item date.
     */
    private long createDate;

    /**
     * Item description.
     */
    private String description;

    /**
     *
     */
    final private Comments[] comments = new Comments[10];

    /**
     *
     */
    private int commentPosition = 0;

    /**
     *
     */
    public Item() {

    }

    /**
     *
     * @param name
     * @param desc
     */
    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
	}

    /**
     *
     * @param id
     */
	public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param createDate
     */
    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param comment
     */
    public void setComment(Comments comment) {
        this.comments[this.commentPosition] = comment;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     * @return
     */
    public long getCreateDate() {
        return this.createDate;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param comment
     * @return
     */
    public Comments addComment(Comments comment) {
        comments[this.commentPosition++] = comment;
        return comment;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        String result = "";
        for (int i = 0; i < comments.length; i++) {
            if (comments[i] != null) {
                result = comments[i].getComment();
            }
        }
        return result;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        Date date = new Date(this.createDate);
		return "id: " + this.id + ";   name: " + this.name + ";   description: " + this.description + ";   comments: " + this.getComment() + "; date: "+ date;
    }
}