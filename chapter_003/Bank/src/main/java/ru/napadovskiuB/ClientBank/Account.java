package ru.napadovskiuB.ClientBank;

/**
 * @author Napadovskiy Bohdan.
 */
public class Account {

    /**
     *
     */
    private double value;

    /**
     *
     */
    private int requisites;

    /**
     *
     * @param user
     * @param requisites
     */
    public Account(User user, int requisites) {

    }

    /**
     *
     * @return
     */
    public int getRequisites() {
        return this.requisites;
    }


    /**
     *
     * @return
     */
    public double getValue() {
        return this.value;
    }

    /**
     *
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     *
     */
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" + "value=" + value + ", requisites=" + requisites + '}';
    }
}

