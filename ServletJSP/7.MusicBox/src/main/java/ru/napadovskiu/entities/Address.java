package ru.napadovskiu.entities;

public class Address {
    private int address_id;

    private String address_name;

    public Address(int address_id, String address_name) {
        this.address_id = address_id;
        this.address_name = address_name;
    }

    public Address(String address_name) {
        this.address_name = address_name;
    }

    public int getAddress_id() {
        return this.address_id;
    }

    public String getAddress_name() {
        return this.address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }


}
