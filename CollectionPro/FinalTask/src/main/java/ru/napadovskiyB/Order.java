package ru.napadovskiyB;

/**
 * Package of CollectionPro finalTask.
 * Class for order have info about order.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 01.08.2017
 */
public class Order {

    /**
     * price of order.
     */
    private double price;

    /**
     * order volume.
     */
    private int volume;

    /**
     * order id.
     */
    private int idOrder;

    /**
     * operation order True - buy, False -sell.
     */
    private boolean typeOperation;


    /**
     * Method return price order.
     * @return price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method return volume order.
     * @return volume.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Method return id order.
     * @return
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * Method return type of operation.
     * True is buy, False - sell.
     * @return
     */
    public boolean isTypeOperation() {
        return typeOperation;
    }

    /**
     * Method set price order.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method set volume order.
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Method set id order.
     * @param idOrder
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * Method set type of order.
     * @param typeOperation
     */
    public void setTypeOperation(boolean typeOperation) {
        this.typeOperation = typeOperation;
    }
}
