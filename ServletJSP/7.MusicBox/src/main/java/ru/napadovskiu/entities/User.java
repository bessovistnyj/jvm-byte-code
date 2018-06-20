package ru.napadovskiu.entities;

public class User {

    private int id;

    private String name;

    private String  login;

    private Address Address;

    private Role Role;

    private MusicType MusicType;

    public User(String user_name, String user_login) {
        this.name = user_name;
        this.login = user_login;
    }

    public User(int user_id, String user_name, String user_login) {
        this.id = user_id;
        this.name = user_name;
        this.login = user_login;
    }

    public int getUser_id() {
        return this.id;
    }

    public String getUser_name() {
        return this.name;
    }

    public String getUser_login() {
        return this.login;
    }

    public ru.napadovskiu.entities.Address getAddress() {
        return this.Address;
    }

    public ru.napadovskiu.entities.Role getRole() {
        return this.Role;
    }

    public ru.napadovskiu.entities.MusicType getMusicType() {
        return this.MusicType;
    }

    public void setUser_name(String user_name) {
        this.name = user_name;
    }

    public void setUser_login(String user_login) {
        this.login = user_login;
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

    public void setAddress(ru.napadovskiu.entities.Address address) {
        Address = address;
    }

    public void setRole(ru.napadovskiu.entities.Role role) {
        Role = role;
    }

    public void setMusicType(ru.napadovskiu.entities.MusicType musicType) {
        MusicType = musicType;
    }
}