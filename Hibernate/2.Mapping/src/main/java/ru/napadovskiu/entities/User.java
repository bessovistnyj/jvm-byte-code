package ru.napadovskiu.entities;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class User {


    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column (name = "user_id")
    private int userId;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "user_password")
    private String userPassword;

     public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
