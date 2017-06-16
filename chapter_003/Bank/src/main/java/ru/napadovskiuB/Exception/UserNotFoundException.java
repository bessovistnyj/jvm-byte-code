package ru.napadovskiuB.Exception;

/**
 * Package of chapter_003 task1.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 15.06.2017
 */
public class UserNotFoundException extends Exception {

    /**
     *
     * @param msg
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
