package ru.napadovskiuB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Napadovskiy Bohdan.
 */
public class ConvertList {

    /**
     * Method convert array to List.
     * @param array Array for conversion to list.
     * @return listResult.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> listResult = new ArrayList<>();

        for (int[] anArray : array) {

            for (int elem : anArray) {

                listResult.add(elem);

            }

        }
        return listResult;
    }

    /**
     * Method convert List to Array.
     * @param list List for conversion too array
     * @param rows number of lines.
     * @return Array.
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int column = list.size() / rows;

        int columns;

        if (list.size() % rows == 0) {
            columns = column;
        }  else {
            columns = column + 1;
        }
        int[][] resultArray = new int[rows][columns];

        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                if (iterator.hasNext()) {
                    resultArray[i][j] = iterator.next();
                } else {
                    resultArray[i][j] = 0;
                }
            }
        }

        return resultArray;
    }

    /**
     * Method convert List of arrays to list.
     * @param list with arrays.
     * @return result list.
     */

    public List<Integer> convert(List<int[]> list) {

        List<Integer> result = new ArrayList<Integer>();

        for (int[] arrayList :list) {

            int arraySize = arrayList.length;

            for (int elem = 0; elem < arraySize; elem++) {
                result.add(arrayList[elem]);
            }
        }

       return result;
    }


}
