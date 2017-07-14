package ru.napadovskiuB;

import java.util.Calendar;

/**
 * Class user.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 17.07.2017
 */
public class UserHashCode  extends User{

    /**
     * Constructor for class user.
     * @param name     name user.
     * @param birthday date of birthday.
     */
    public UserHashCode( String name, Calendar birthday ) {
        super(name, birthday);
    }

    @Override
    public int hashCode() {
        final int var = 32;
        int result = getName().hashCode();
        result = (var - 1) * result + getBirthday().hashCode();
        return result;

    }
}
