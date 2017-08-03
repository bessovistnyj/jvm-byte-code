package ru.napadovskiyB;

import java.util.Comparator;

/**
 *
 */
public class Subdivision  {

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


    private int checkCode(String code1, String code2) {
        int result = 0;
        result = code1.compareTo(code2);
        if (result != 0) {
            if ((code1.indexOf("\\") !=0) || (code2.indexOf("\\") !=0)) {
                String newCode1 = code1.substring(code1.indexOf("\\")-1);
                String newCode2 = code1.substring(code2.indexOf("\\")-1);
                result = checkCode(newCode1,newCode2);
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public Comparator sortByIncrease() {
        return new Comparator<Subdivision> () {
            @Override
            public int compare(Subdivision o1, Subdivision o2) {
                int result = 0;
                String code1 = o1.getCode();
                String code2 = o2.getCode();
                checkCode(code1,code2);
//                if (result !=0 ) {
//                    re
//                }
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
