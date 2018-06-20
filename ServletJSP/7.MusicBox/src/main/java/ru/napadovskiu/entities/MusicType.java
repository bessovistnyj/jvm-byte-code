package ru.napadovskiu.entities;

public class MusicType {

    /**
     *
     */
    private int music_id;

    /**
     *
     */
    private String  music_name;

    /**
     *
     * @param music_id
     * @param music_name
     */
    public MusicType(int music_id, String music_name) {
        this.music_id = music_id;
        this.music_name = music_name;
    }

    /**
     *
     * @param music_name
     */
    public MusicType(String music_name) {
        this.music_name = music_name;
    }

    /**
     *
     * @return
     */
    public int getMusic_id() {
        return music_id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
}
