package com.augmentum.oes.dao;

public interface BaseDao<T, K> {
    public int create(T object);

    public void delete(K id);

    public void update(T object);

    public T getById(K id);
}
