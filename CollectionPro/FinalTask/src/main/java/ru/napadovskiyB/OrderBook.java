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

    /**
     *
     * @param order
     */
    public void addOrder(Order order) {
        this.unsortedMap.put(order.getIdOrder(),order);

        if (order.isTypeOperation()) {
            addToBuySortMap(order);
        } else {
            addToSellMap(order);
        }
    }

    /**
     *
     * @param order
     */
    private void addToBuySortMap(Order order) {

        if (this.buyTree.containsKey(order.getPrice())) {
            this.buyTree.get(order.getPrice()).put(order.getIdOrder(), order);
        } else {
            HashMap<Integer, Order> tmpMap = new HashMap<>();
            tmpMap.put(order.getIdOrder(),order);
            this.buyTree.put(order.getPrice(),tmpMap);
        }
    }

    /**
     *
     * @param order
     */
    private void addToSellMap(Order order) {

        if (this.sellTree.containsKey(order.getPrice())) {
            this.sellTree.get(order.getPrice()).put(order.getIdOrder(), order);
        } else {
            HashMap<Integer, Order> tmpMap = new HashMap<>();
            tmpMap.put(order.getIdOrder(),order);
            this.sellTree.put(order.getPrice(),tmpMap);
        }
    }

    /**
     *
     * @param id
     */
    public void deleteOrder(Integer id) {
        Order deleteOrder = unsortedMap.get(id);
        if (this.unsortedMap.containsKey(id)) {
            this.unsortedMap.remove(id);
            if (this.buyTree.containsKey(deleteOrder.getPrice())) {
                this.buyTree.get(deleteOrder.getPrice()).remove(deleteOrder.getIdOrder());
                if (this.buyTree.get(deleteOrder.getPrice()).size() == 0) {
                    this.buyTree.remove(deleteOrder.getPrice());
                }
            }
            if (this.sellTree.containsKey(deleteOrder.getPrice())) {
                this.sellTree.get(deleteOrder.getPrice()).remove(deleteOrder.getIdOrder());
                if (this.sellTree.get(deleteOrder.getPrice()).size() == 0) {
                    this.sellTree.remove(deleteOrder.getPrice());
                }

            }
        }
    }


    private int takeSummAllEllemnt (HashMap<Integer,Order> mapForCheck) {
        int result = 0;
        for (Order tmpOrder:mapForCheck.values()) {
            result = result + tmpOrder.getVolume();
        }
        return result;
    }

    private void calculateVolume(HashMap<Integer,Order> editMap,int value) {
        Iterator<Order> iterMap = editMap.values().iterator();
        while (iterMap.hasNext()) {
            Order nextOrder = iterMap.next();
            if (value <= nextOrder.getVolume()) {
                nextOrder.setVolume(nextOrder.getVolume()-value);
                break;
            } else {
                iterMap.remove();
            }
        }

    }


    public void checkElement() {
        Iterator<Double> buyKeys = this.buyTree.keySet().iterator();
        Iterator<Double> sellKeys = this.sellTree.keySet().iterator();
        if (buyKeys.hasNext() && sellKeys.hasNext()) {
            Double buyPrice = buyKeys.next();
            Double sellPrice = sellKeys.next();
            while(buyKeys.hasNext() && sellKeys.hasNext()) {
                HashMap buyElements = this.buyTree.get(buyPrice);
                HashMap sellElements = this.sellTree.get(sellPrice);
                int sumAllBuyElement = takeSummAllEllemnt(buyElements);
                int sumAllSellElement = takeSummAllEllemnt(sellElements);
                if ((sellPrice >= buyPrice) && (sumAllBuyElement > sumAllSellElement)) {
                    calculateVolume(buyElements,sumAllSellElement) ;
                    sellKeys.remove();
                    sellPrice = sellKeys.next();
                } else if ((sellPrice >= buyPrice) && (sumAllBuyElement < sumAllSellElement)) {
                    calculateVolume(sellElements,sumAllBuyElement) ;
                    buyKeys.remove();
                    buyPrice = buyKeys.next();
                } else if ((sellPrice >= buyPrice) && (sumAllBuyElement == sumAllSellElement)) {
                    sellKeys.remove();
                    sellPrice = sellKeys.next();
                    buyKeys.remove();
                    buyPrice = buyKeys.next();
                } else {
                    break;
                }

            }
        }
    }

}
