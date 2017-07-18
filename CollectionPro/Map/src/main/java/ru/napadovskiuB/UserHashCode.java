package ru.napadovskiuB;

import java.util.Calendar;

/**
 * Class user.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 17.07.2017
 */
public class UserHashCode  extends User {

    /**
     * Constructor for class user.
     * @param name     name user.
     * @param birthday date of birthday.
     */
    public UserHashCode(String name, Calendar birthday) {
        super(name, birthday);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + getName().hashCode();
        result = prime * result + getBirthday().hashCode();
        result = prime * result + getChildren();
        return result;
    }
}
