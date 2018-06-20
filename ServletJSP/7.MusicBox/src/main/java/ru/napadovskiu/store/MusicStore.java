package ru.napadovskiu.store;

import ru.napadovskiu.entities.MusicType;
import ru.napadovskiu.settings.Settings;

import java.util.List;

public class MusicStore implements AbstractStore<MusicType> {

    /**
     * settings for load.
     */
    private final Settings createQuery = new Settings();


    /**
     *
     */
    private final Settings selectQuery = new Settings();


    /**
     *
     */
    private final Settings insertQuery = new Settings();

    /**
     *
     */
    private final Settings deleteQuery = new Settings();





    public MusicStore() {

        ClassLoader loader = Settings.class.getClassLoader();
        this.createQuery.load(loader.getResourceAsStream("create.properties"));
        this.selectQuery.load(loader.getResourceAsStream("select.properties"));
        this.insertQuery.load(loader.getResourceAsStream("insert.properties"));
        this.deleteQuery.load(loader.getResourceAsStream("delete.properties"));

    }



    @Override
    public MusicType getById(int id) {
        return null;
    }

    @Override
    public List<MusicType> getAll() {
        return null;
    }

    @Override
    public void create(MusicType entity) {

    }

    @Override
    public void update(MusicType entity) {

    }

    @Override
    public void delete(MusicType entity) {

    }
}
