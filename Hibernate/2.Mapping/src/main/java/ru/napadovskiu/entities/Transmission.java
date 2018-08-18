package ru.napadovskiu.entities;

public class Transmission {


    /**
     *
     */
    private int transId;

    /**
     *
     */
    private String transName;

    /**
     *
     */
    public Transmission() {
    }

    /**
     *
     * @param transId
     */
    public Transmission(int transId) {
        this.transId = transId;
    }

    /**
     *
     * @return
     */
    public int getTransId() {
        return transId;
    }

    /**
     *
     * @return
     */
    public String getTransName() {
        return transName;
    }

    /**
     *
     * @param transId
     */
    public void setTransId(int transId) {
        this.transId = transId;
    }

    /**
     *
     * @param transName
     */
    public void setTransName(String transName) {
        this.transName = transName;
    }
}
