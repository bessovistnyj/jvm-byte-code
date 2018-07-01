package ru.napadovskiu.entities;

public class User {

    private int id;

    private String name;

    private String  login;

    private Address address;

    private Role Role;

    private MusicType musicType;

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
        return this.address;
    }

    public ru.napadovskiu.entities.Role getRole() {
        return this.Role;
    }

    public ru.napadovskiu.entities.MusicType getMusicType() {
        return this.musicType;
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRole(Role role) {
        Role = role;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }
}