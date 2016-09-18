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
    private int position = 0;
    private static  final Random RN = new Random();

 	 /**
		*The method add new item to items array
		*@param item
	*/ 	
	public void addNewItem(Item item){
		item.setId(generateId());
		this.takeItems[position++] = item;
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
				this.position--;
            }
            if(findItem){
                if(i != this.takeItems.length-1){
                    this.takeItems[i] = this.takeItems[i+1];
                }
                else{
                    this.takeItems[i] = null;
                }
            }
        }
	}

	 /**
		*The method find item by id
		*@param id
		*@return an array of items found 
	*/ 	
    public Item[] findItem(String id){
        Item[] tmpArray = new Item[this.position];
        int counter =0;
        for(Item tmpItem: this.takeItems){
            if(tmpItem!=null && tmpItem.getId().equals(id)){
                tmpArray[counter] = tmpItem;
                counter++;
            }
        }
        Item[] result = new Item[counter];

        for(int i =0; i<counter; i++){
            result[i] = tmpArray[i];
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
        Item[] tmpArray = new Item[this.position];
        int counter =0;
        for(Item tmpItem: this.takeItems){
            if(tmpItem!=null && (tmpItem.getName().equals(name) && tmpItem.getDescription().equals(description))){
                tmpArray[counter] = tmpItem;
                counter++;
            }
        }
        Item[] result = new Item[counter];

        for(int i =0; i<counter; i++){
            result[i] = tmpArray[i];
        }
        return result;
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
    public Item[] showAllItem(){
        Item[] result = new Item[this.position];
        for (int counter =0; counter < this.position; counter++){
            result[counter] = this.takeItems[counter];
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
