package ru.napadovskiu.entities;

import javax.persistence.*;

@Entity
@Table(name = "gearbox")
public class GearBox {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "gear_id")
    private int gearBoxId;

    /**
     *
     */
    @Column (name = "gear_name")
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
