package ru.napadovskiyB;


import java.util.*;

/**
 *
 */
public class OrderBook {

    private HashMap<Integer, Order> unsortedMap = new HashMap<Integer, Order>();

    private TreeMap<Double, HashMap<Integer,Order>> buyTree = new TreeMap<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o1.compareTo(o2);
        }
    });


    private TreeMap<Double, HashMap<Integer,Order>> sellTree = new TreeMap<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return -o1.compareTo(o2);
        }
    });

    public void addOrder(Order order) {
        this.unsortedMap.put(order.getIdOrder(),order);

        if (order.isTypeOperation()) {
            addToBuySortMap(order);
        } else {
            addToSellMap(order);
        }
    }

    private void addToBuySortMap(Order order) {

        if (this.buyTree.containsKey(order.getPrice())) {
            this.buyTree.get(order.getPrice()).put(order.getIdOrder(), order);
        } else {
            HashMap<Integer, Order> tmpMap = new HashMap<>();
            tmpMap.put(order.getIdOrder(),order);
            this.buyTree.put(order.getPrice(),tmpMap);
        }
    }

    private void addToSellMap(Order order) {

        if (this.sellTree.containsKey(order.getPrice())) {
            this.sellTree.get(order.getPrice()).put(order.getIdOrder(), order);
        } else {
            HashMap<Integer, Order> tmpMap = new HashMap<>();
            tmpMap.put(order.getIdOrder(),order);
            this.sellTree.put(order.getPrice(),tmpMap);
        }
    }



}
