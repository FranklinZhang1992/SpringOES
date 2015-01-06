package com.augmentum.oes.service.base;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.User;

public interface UserService {

    public int login(String userName, String password) throws ParameterException;

    public User setSessionUser(String userName);

    public int isAllow(int id);

}
