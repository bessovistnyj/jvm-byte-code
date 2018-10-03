package ru.napadovskiu.entities;

import java.sql.Timestamp;


public class Item {

    private int itemId;

    private String description;

    private Car car;

    private boolean closed;

    private User user;

    private Timestamp date;

    public Item() {
    }

    public Item(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public Item(int itemId, String description, Car car, boolean closed, User user, Timestamp date) {
        this.itemId = itemId;
        this.description = description;
        this.car = car;
        this.closed = closed;
        this.user = user;
        this.date = date;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
