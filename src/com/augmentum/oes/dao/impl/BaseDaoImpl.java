package com.augmentum.oes.dao.impl;

import java.lang.reflect.ParameterizedType;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public abstract class BaseDaoImpl<T, K> extends SqlSessionDaoSupport {

    private static final String SQL_ID_CREATE = ".create";
    private static final String SQL_ID_UPDATE = ".update";
    private static final String SQL_ID_DELETE = ".delete";
    private static final String SQL_ID_BY_ID = ".getById";

    @SuppressWarnings("unchecked")
    public Class<T> getActuallModleClassType() {
        Class<T> classType = null;
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        classType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return classType;
    }

    public int create(T object) {
        return this.getSqlSession().insert(this.getActuallModleClassType().getName() + SQL_ID_CREATE, object);
    }

    public void delete(K id) {
        this.getSqlSession().delete(this.getActuallModleClassType().getName() + SQL_ID_DELETE, id);
    }

    public void update(T object) {
        this.getSqlSession().update(this.getActuallModleClassType().getName() + SQL_ID_UPDATE, object);
    }

    @SuppressWarnings("unchecked")
    public T getById(K id) {
        T result = null;
        result = (T) this.getSqlSession().selectOne(this.getActuallModleClassType().getName() + SQL_ID_BY_ID, id);
        return result;
    }
}
