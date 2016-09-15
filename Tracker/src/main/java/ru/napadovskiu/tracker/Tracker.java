package ru.napadovskiu.tracker;

import ru.napadovskiu.items.*;
import java.util.Random;

/**
 * Created by program on 13.09.2016.
 */
public class Tracker {
    private Item[] TakeItems = new Item[100];
    private int position = 0;
    private static  final Random RN = new Random();

    public void addNewItem(Item item){
        
		if(item.getId() == null){
            item.setId(generateId());
        }
        else{
            item.setId(item.getId());
        }
        this.TakeItems[position++] = item;
		
	}

    public void deleteItem(Item item){
        Item[] result = new Item[100];

        int counter =0;
        for(Item tmpItem: this.TakeItems){
            if(tmpItem!=null && !tmpItem.getId().equals(item.getId())){
                result[counter] = tmpItem;
                counter++;
            }
        }
        this.TakeItems = result;
        this.position--;
    }


    public Item[] findItem(String id){
        Item[] tmpArray = new Item[this.position];
        int counter =0;
        for(Item tmpItem: this.TakeItems){
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

    public Item[] findItem(String name,String description){
        Item[] tmpArray = new Item[this.position];
        int counter =0;
        for(Item tmpItem: this.TakeItems){
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

    public void editItem(Item editItem){
        for (Item tmpItem: this.TakeItems){
            if (tmpItem !=null && tmpItem.getId().equals(editItem.getId())){
                tmpItem.setName(editItem.getName());
                tmpItem.setDescription(editItem.getDescription());
            }
        }
    }


    public Item[] showAllItem(){
        Item[] result = new Item[this.position];
        for (int counter =0; counter < this.position; counter++){
            result[counter] = this.TakeItems[counter];
        }
        return result;
    }

    private String generateId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt() );

    }

}
