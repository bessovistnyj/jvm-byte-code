package ru.napadovskiu.entities;

public class Car {

    /**
     *
     */
    private int carId;

    /**
     *
     */
    private String carName;

    /**
     *
     */
    private Engine engine;

    /**
     *
     */
    private GearBox gearBox;

    /**
     *
     */
    private Transmission transmission;

    /**
     *
     */
    public Car() {

    }

    /**
     *
     * @param carId
     */
    public Car(int carId) {
        this.carId = carId;
    }

    /**
     *
     * @return
     */
    public int getCarId() {
        return carId;
    }

    /**
     *
     * @return
     */
    public String getCarName() {
        return carName;
    }

    /**
     *
     * @return
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     *
     * @return
     */
    public GearBox getGearBox() {
        return gearBox;
    }

    /**
     *
     * @return
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     *
     * @param carId
     */
    public void setCarId(int carId) {
        this.carId = carId;
    }

    /**
     *
     * @param carName
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     *
     * @param gearBox
     */
    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    /**
     *
     * @param transmission
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
