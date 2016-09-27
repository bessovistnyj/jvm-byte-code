package ru.napadovskiu.tracker;

import ru.napadovskiu.items.*;
import java.util.Random;

/**
 * Created by napadovskiy on 13.09.2016.
	*@author napadovskiy
	*@since 13.09.2016
	*@version 1
 */
 
public class Tracker {
    private Item[] takeItems = new Item[100];
    private static  final Random RN = new Random();

 	 /**
		*The method add new item to items array
		*@param item
	*/ 	
	public void addNewItem(Item item){
		for (int i =0; i< this.takeItems.length; i++){
            if(this.takeItems[i] ==null) {
                item.setId(generateId());
                item.setCreateDate(System.currentTimeMillis());
                this.takeItems[i]= item;
                break;
            }
        }
	}

	 /**
		*The method delete item from items array
		*@param item
	*/ 	
    public void deleteItem(Item item){
        boolean findItem = false;
        for(int i=0; i<this.takeItems.length;i++){
            if(this.takeItems[i]!=null && this.takeItems[i].getId().equals(item.getId())){
                findItem = true;
                this.takeItems[i] = null;
            }
        }
	}

	 /**
		*The method find item by id
		*@param id
		*@return an array of items found 
	*/ 	
    public Item findItemById(String id){
        Item result = null;
        for(Item tmpItem: this.takeItems){
            if(tmpItem!=null && tmpItem.getId().equals(id)){
                result = tmpItem;
                break;
            }
        }
        return result;
    }


	private boolean findSubString(String str, String findStr){
        boolean result = false;
        if(str.indexOf(findStr) != -1){
            result  = true;
        }
        return result;
    }


    /**
		*The method find item by name and description
		*@param name
		*@param description
		*@return an array of items found 
	*/ 	
    public Item[] findItem(String name,String description){
        Item[] resultArray = new Item[this.takeItems.length];
        int counter = 0;

        for(Item tmpItem: this.takeItems){
            if (tmpItem!=null && findSubString(tmpItem.getName(),name)){
                resultArray[counter] = tmpItem;
            }
            if (tmpItem!=null && findSubString(tmpItem.getDescription(),description)){
                if (tmpItem!=null || !resultArray[counter].equals(tmpItem)){
                    resultArray[counter] = tmpItem;
                }
            }
            counter++;

        }
        return resultArray;
    }

	 /**
		*The method edit item 
		*@param editItem
	*/ 	
    public void editItem(Item editItem){
        for (Item tmpItem: this.takeItems){
            if (tmpItem !=null && tmpItem.getId().equals(editItem.getId())){
                tmpItem.setName(editItem.getName());
                tmpItem.setDescription(editItem.getDescription());
            }
        }
    }

	 /**
		*The method show all item 
		*@return an array all items 
	*/ 	
    public Item[] getAllItem(){
        int tmpCounter =0;
        for(Item tmpItem: this.takeItems){
            if(tmpItem!=null){
                tmpCounter++;
            }
        }
        Item[] result = new Item[tmpCounter];

        int counter = 0;
        for(int i =0; i< this.takeItems.length; i++){
            if(this.takeItems[i]!=null) {
                result[counter] = takeItems[i];
                counter++;
            }
        }
        return result;
    }

    /**
		*The method generate id for new item
		*@return id 
	*/ 	
    private String generateId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt() );

    }

}
