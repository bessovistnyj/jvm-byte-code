package ru.napadovskiyB;


import java.util.ArrayList;

/**
 *
 */
public class ArraySubdivision {

    /**
     *
     */
    private ArrayList<Subdivision> arrayList;


    /**
     *
     */
    public ArraySubdivision() {
        this.arrayList = new ArrayList<Subdivision>();

    }

    /**
     *
     * @return
     */
    private boolean checkRootElement(String code) {
        return this.arrayList.contains(code);
    }

    private String[] returnArrayCode(String code) {
        String[] result =  code.split("\\\\");
        return result;

    }

    public void addElement(String code) {
        String[] check =  returnArrayCode(code);
        for (String tmpCode:check) {
            //if (tmpCode.length() == 2 ) {
                if (!checkRootElement(tmpCode)) {
                    Subdivision subdivision = new Subdivision(tmpCode);
                    this.arrayList.add(subdivision);
                }
//            } else {
//
//            }
        }

//        if (!checkRootElement()) {
//            Subdivision newElement = new Subdivision(code);
//        }

    }


}
