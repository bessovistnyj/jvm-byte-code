package ru.napadovskiuB.store;

/**
 *Abstract class.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 03.07.2017
 */
public abstract class Base {

   private int id;

    /**
     * Method get base id.
     * @return
     */
    public abstract String getId();


    /**
     * Method set id in base.
     * @param id base id.
     */
    public abstract void setId(String id);


}
