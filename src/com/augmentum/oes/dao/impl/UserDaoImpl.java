package com.augmentum.oes.dao.impl;

import java.util.List;

import com.augmentum.oes.dao.UserDao;
import com.augmentum.oes.modle.User;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

    private static final String SQL_ID_BY_USER_NAME = ".queryByUserName";

    public List<User> queryByUserName(String userName) {
        List<User> list = null;
        list = this.getSqlSession().selectList(this.getActuallModleClassType().getName() + SQL_ID_BY_USER_NAME, userName);
        return list;
    }


}
