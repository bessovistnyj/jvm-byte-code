package ru.napadovskiuB.ClientBank;

/**
 * @author Napadovskiy Bohdan.
 */

public class User {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String passport;

    /**
     *
     * @param name
     * @param passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }


    /**
     *
     * @return
     */
    public String getPassport() {
        return this.passport;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!name.equals(user.name)) {
            return false;
        }
        return passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", passport='" + passport + '\'' + '}';
    }
}
