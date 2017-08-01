package ru.napadovskiyB;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class Settings {

    /**
     *
     */
    private final Properties properties = new Properties();

    public void load(InputStream is) {
        try {
            this.properties.load(is);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }


    /**
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        return this.properties.getProperty(key);

    }
}
