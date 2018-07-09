package ru.napadovskiu.entities;

import java.util.List;

public class User {

    private int id;

    private String name;

    private String login;

    private String password;

    private Address address;

    private Role role;

    private List<MusicType> musicType;

    public User(String user_name, String user_login) {
        this.name = user_name;
        this.login = user_login;
    }

    public User(int user_id, String user_name, String user_login) {
        this.id = user_id;
        this.name = user_name;
        this.login = user_login;
    }

    public void setPassword(String user_password) {
        this.password = user_password;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }

    public void setLogin(String user_login) {
        this.login = user_login;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMusicType(List<MusicType> musicType) {

        this.musicType = musicType;
    }

    public Role getRole() {
        return this.role;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getPassword() {
        return this.password;
    }

    public List<MusicType > getMusicType() {
        return this.musicType;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLogin() {
        return this.login;
    }

}