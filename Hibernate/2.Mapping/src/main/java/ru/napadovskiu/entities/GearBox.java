package ru.napadovskiu.entities;

public class GearBox {

    /**
     *
     */
    private int gearBoxId;

    /**
     *
     */
    private String gearBoxName;

    /**
     *
     */
    public GearBox() {
    }

    /**
     *
     * @param gearBoxId
     */
    public GearBox(int gearBoxId) {
        this.gearBoxId = gearBoxId;
    }

    /**
     *
     * @param gearBoxId
     */
    public void setGearBoxId(int gearBoxId) {
        this.gearBoxId = gearBoxId;
    }

    /**
     *
     * @param gearBoxName
     */
    public void setGearBoxName(String gearBoxName) {
        this.gearBoxName = gearBoxName;
    }


    /**
     *
     * @return
     */
    public int getGearBoxId() {
        return gearBoxId;
    }

    /**
     *
     * @return
     */
    public String getGearBoxName() {
        return gearBoxName;
    }
}
