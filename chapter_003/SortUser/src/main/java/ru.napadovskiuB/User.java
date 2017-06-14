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
     * User name.
     */
    private String name;

    /**
     * Constructor for User class.
     * @param age user id.
     * @param name user name.
     */
    public User(int age, String name) {
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
     *Method return user age.
     * @return user age.
     */
    public int getAge() {
        return this.age;
    }


    @Override
    public int compareTo(User o) {
        return this.age - o.age;

    }
}
