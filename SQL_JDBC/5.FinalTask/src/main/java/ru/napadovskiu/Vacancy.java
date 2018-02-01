package ru.napadovskiu;

import java.util.Date;

/**
 *
 */
public class Vacancy {


    private Date vac_Date;

    private String vac_Link;

    private String vac_author;

    private String vac_Description;

    private String vac_Title;

    /**
     * Constructor for class.
     * @param vac_Date
     * @param vac_Link
     * @param vac_author
     * @param vac_Description
     * @param vac_Title
     */
    public Vacancy(Date vac_Date, String vac_Link, String vac_author, String vac_Description, String vac_Title) {
        this.vac_Date = vac_Date;
        this.vac_Link = vac_Link;
        this.vac_author = vac_author;
        this.vac_Description = vac_Description;
        this.vac_Title = vac_Title;
    }

    /**
     *
     * @return
     */
    public Date getVac_Date() {
        return vac_Date;
    }

    /**
     *
     * @return
     */
    public String getVac_Link() {
        return vac_Link;
    }

    /**
     *
     * @return
     */
    public String getVac_author() {
        return vac_author;
    }

    /**
     *
     * @return
     */
    public String getVac_Description() {
        return vac_Description;
    }

    /**
     *
     * @return
     */
    public String getVac_Title() {
        return vac_Title;
    }
}
