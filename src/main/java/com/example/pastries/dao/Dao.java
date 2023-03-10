package com.example.pastries.dao;

import java.util.List;

public interface Dao<T> {
    T get(Long id);
    List<T> getAll();
    void create(T t);
    void update(T t);
    void delete(T t);
}
