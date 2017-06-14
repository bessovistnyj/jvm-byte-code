package ru.napadovskiuB;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Napadovskiy Bohdan on 08.06.2017.
 */
public class SortUser {

    /**
     * Method return sorted TreeSet.
     * @param list with users for sorting.
     * @return treeset.
     */
    public Set<User> sort(List<User> list) {
        TreeSet result = new TreeSet();

        for (User listElem : list) {
            result.add(listElem);
        }

        return  result;
    }

}
