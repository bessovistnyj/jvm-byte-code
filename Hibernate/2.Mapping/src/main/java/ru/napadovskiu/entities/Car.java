package ru.napadovskiu.entities;

import javax.persistence.*;


@Entity
@Table (name = "car")
public class Car {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private int carId;

    /**
     *
     */
    @Column(name = "car_name")
    private String carName;

    /**
     *
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "eng_id")
    private Engine engine;

    /**
     *
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "gear_id")
    private GearBox gearBox;

    /**
     *
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "image_id")
    private Images images;

    /**
     *
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "tr_id")
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

    /**
     *
     * @param engine
     */
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

    /**
     *
     * @return
     */
    public Images getImages() {
        return this.images;
    }

    /**
     *
     * @param images
     */
    public void setImages(Images images) {
        this.images = images;
    }
}
