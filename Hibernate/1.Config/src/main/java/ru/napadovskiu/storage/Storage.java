package ru.napadovskiu.storage;

import ru.napadovskiu.models.Items;

import java.util.Collection;

public interface Storage {

    public boolean update(final Items items);

    public boolean delete(final Items items);

    public Items get(final int id);

    public Collection<Items> getAll();

    public Items findByDesc(final String desc);

    public int add(Items items);

    public void close();
}
