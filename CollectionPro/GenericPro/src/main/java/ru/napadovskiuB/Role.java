package ru.napadovskiuB;

/**
 * Created by Программист on 04.07.2017.
 */
public class Role extends Base {

    private String id;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId( String id ) {
        this.id = id;

    }
}
