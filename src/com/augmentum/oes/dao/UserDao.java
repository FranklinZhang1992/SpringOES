package com.augmentum.oes.dao;

import java.util.List;

import com.augmentum.oes.modle.User;

public interface UserDao extends BaseDao<User, Integer> {

    //search user by username
    public List<User> queryByUserName(String userName);

}
