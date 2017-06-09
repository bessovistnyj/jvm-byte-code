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
    /**
     *
     */
    private Item[] takeItems = new Item[100];

    /**
     *
     */
    private static  final Random RN = new Random();

 	 /**
		*The method add new item to items array
		*@param item
	*/ 	
	public Item addNewItem(Item item){
		Item result = null;
        boolean newItem = false;
        int i =0;
        for (; i< this.takeItems.length; i++){
            if(this.takeItems[i] ==null) {
                item.setId(generateId());
                item.setCreateDate(System.currentTimeMillis());
                this.takeItems[i]= item;
                result = item;
                newItem = true;
                break;
            }
        }
	    if (i == this.takeItems.length -1 && newItem ==false ){
            result =null;
        }
        return result;
	}

	 /**
		*The method delete item from items array
		*@param item
	*/ 	
    public boolean deleteItem(Item item){

        boolean isDeleteItem = false;
        for(int i=0; i<this.takeItems.length;i++){
            if(this.takeItems[i]!=null && this.takeItems[i].getId().equals(item.getId())){
                isDeleteItem = true;
                this.takeItems[i] = null;
            }
        }
	    return isDeleteItem;
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


    /**
     *
     * @param str
     * @param findStr
     * @return
     */
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
		*@return an array of items found
	*/ 	

    public Item[] findItemByName(String name){
        Item[] resultArray = new Item[this.takeItems.length];
        int counter = 0;

        for(Item tmpItem: this.takeItems){
            if (tmpItem!=null && findSubString(tmpItem.getName(),name)){
                resultArray[counter] = tmpItem;
            }
            counter++;

        }
        return resultArray;
    }

    /**
     *The method find item by name and description
     *@param description
     *@return an array of items found
     */
    public Item[] findItemByDescription(String description){
        Item[] resultArray = new Item[this.takeItems.length];
        int counter = 0;

        for(Item tmpItem: this.takeItems){
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
        return this.takeItems;

    }

    /**
		*The method generate id for new item
		*@return id 
	*/ 	
    private String generateId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt() );

    }

}
