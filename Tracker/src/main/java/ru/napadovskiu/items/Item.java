package ru.napadovskiu.items;

/**
 //*Class Item
 *@author napadovskiy
 *@since 13.09.2016
 *@version 1
*/

public class Item {
    private String id;
    private String name;
    private String description;

    public Item(){

    }

    public Item(String name, String desc){
        this.name = name;
        this.description = desc;
    }

  	public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public String getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
    }

}