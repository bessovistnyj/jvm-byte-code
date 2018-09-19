package ru.napadovskiu.entities;

import javax.persistence.*;

@Entity
@Table(name = "engine")
public class Engine {


    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "eng_id")
    private int engineId;

    /**
     *
     */
    @Column (name = "eng_name")
    private String engineName;

    /**
     *
     * @param engineId
     */
    public Engine(int engineId) {
        this.engineId = engineId;
    }

    /**
     *
     */
    public Engine() {
    }

    /**
     *
     * @return
     */
    public int getEngineId() {
        return engineId;
    }

    /**
     *
     * @return
     */
    public String getEngineName() {
        return engineName;
    }

    /**
     *
     * @param engineId
     */
    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    /**
     *
     * @param engineName
     */
    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
}
