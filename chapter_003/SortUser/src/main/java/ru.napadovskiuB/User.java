package ru.napadovskiuB;

/**
 * Created by Napadovskiy Bohdan on 08.06.2017.
 */
public class User implements Comparable<User> {

    /**
     * User age.
     */
    private int age;

    /**
     * User id.
     */
    private int id;

    /**
     * User name.
     */
    private String name;


    /**
     * Constructor for User class.
     * @param id user id.
     * @param name user name.
     */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor for User class.
     * @param id user id.
     * @param age user age.
     * @param name user name.
     */
    public  User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;

    }

    /**
     * Method return user name.
     * @return user name.
     */
    public String getName() {
        return this.name;
    }

    /**
     *Method return user id.
     * @return user age.
     */
    public int getAge() {
        return this.age;
    }

    /**
     *Method return user id.
     * @return user id.
     */
    public int getId() {
        return  this.id;
    }


    @Override
    public int compareTo(User o) {
        return this.age - o.age;

    }
}
