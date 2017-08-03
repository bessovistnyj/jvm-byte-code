package ru.napadovskiyB;

import java.util.Comparator;

/**
 *
 */
public class Subdivision {

    private String code;

    /**
     *
     * @param code
     */
    public Subdivision(String code) {
        this.code = code;
    }


    /**
     *
     * @return
     */
    public String getCode() {
        return this.code;
    }

    /**
     *
     * @return
     */
    public Comparator sortByIncrease() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int result = 0;
                return result;
            }
        };
    }

    /**
     *
     * @return
     */
    public Comparator sortByDecrease() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int result = 0;
                return result;
            }
        };
    }


}
