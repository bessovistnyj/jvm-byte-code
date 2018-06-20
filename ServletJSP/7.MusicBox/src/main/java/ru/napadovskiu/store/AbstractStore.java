package ru.napadovskiu.store;

import java.util.List;

public interface AbstractStore<T> {

    T getById(int id);

    List<T> getAll();

    boolean create(T entity);

    boolean update(T entity);

    boolean delete(T entity);

}
