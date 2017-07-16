package ru.napadovskiuB;

import java.util.Calendar;

/**
 * Class user.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 17.07.2017
 */
public class UserEquals extends User {

    /**
     * Constructor for class user.
     *
     * @param name     name user.
     * @param birthday date of birthday.
     */
    public UserEquals(String name, Calendar birthday) {
        super(name, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (!getName().equals(user.getName())) {
            return false;
        }
        return getBirthday().equals(user.getBirthday());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
