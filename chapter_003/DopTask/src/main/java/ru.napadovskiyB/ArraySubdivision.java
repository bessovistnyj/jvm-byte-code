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

    public ArrayList<Subdivision> getArrayList() {
        return this.arrayList;
    }

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
        boolean result = false;
        for (Subdivision checkCode: this.arrayList) {
            if (checkCode.getCode().equals(code)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private String[] returnArrayCode(String code) {
        String[] result =  code.split("\\\\");
        return result;

    }

    public void addElement(String code) {
        String[] check =  returnArrayCode(code);
        String newCode = "";
        for (String tmpCode:check) {
            newCode = newCode  + tmpCode;
            if (!checkRootElement(newCode)) {
                Subdivision subdivision = new Subdivision(newCode);
                this.arrayList.add(subdivision);
            }
            newCode = newCode+"\\";
        }
    }


}
