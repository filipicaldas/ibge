package aed2.dao;

import aed2.structure.List;

public interface DAO<T> {
    T get(long id);

    List<T> get();

    void update(T item);

    void save(T item);

    void remove(long id);
}