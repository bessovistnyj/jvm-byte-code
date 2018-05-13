package ru.napadovskiu.users;


import java.sql.Timestamp;
import java.util.Objects;

public class User {

    /**
     *Name user.
     */
    private String name;

    /**
     *Login user.
     */
    private String login;

    /**
     *Email user.
     */
    private String email;

     /**
     *Date of crate user.
     */
    private Timestamp createDate;

    /**
     *
     */
    private String password;


    /**
     *
     */
    private int id;


    /**
     *
     */
    private UserRole role;


    /**
     * Constructor for class.
     * @param name name user.
     * @param login login user.
     * @param email email user.
     * @param createDate date of crate user.
     */
    public User(String name, String login, String email, Timestamp createDate, String password) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
    }


    /**
     *
     * @param id
     * @param name
     * @param login
     * @param email
     * @param createDate
     * @param password
     */
    public User(int id, String name, String login, String email, Timestamp createDate, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
    }

    /**
     *
     * @param id
     * @param name
     * @param login
     * @param email
     * @param createDate
     * @param password
     * @param role
     */
    public User(int id, String name, String login, String email, Timestamp createDate, String password, UserRole role) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return this.login;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }


    /**
     *
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    /**
     *
     * @return
     */
    public UserRole getRole() {
        return role;
    }

     /**
     *
     * @param role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

}
