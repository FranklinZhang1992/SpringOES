package com.augmentum.oes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.augmentum.oes.dao.RoleDao;
import com.augmentum.oes.dao.UserDao;
import com.augmentum.oes.dao.UserRoleDao;
import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.User;
import com.augmentum.oes.service.base.UserService;
import com.augmentum.oes.util.Constant;
import com.augmentum.oes.util.Validate;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private RoleDao roleDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserRoleDao getUserRoleDao() {
        return userRoleDao;
    }

    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public int login(String userName, String password) throws ParameterException {

        ParameterException parameterException = new ParameterException();
        if (Validate.isEmpty(userName)) {
            parameterException.addErrorParameter("userNameError", "user name is required");
        }
        if (Validate.isEmpty(password)) {
            parameterException.addErrorParameter("passwordError", "password is required");
        }
        if (parameterException.hasErrorParameter()) {
            throw parameterException;
        }


        List<User> list = new ArrayList<User>();
        list = userDao.queryByUserName(userName);
        if (list.size() > 0) {
            if (list.get(0).getPassword().equals(password)) {
                if (isAllow(list.get(0).getId()) == Constant.SYS_ADMIN) {
                    return Constant.SYS_ADMIN;
                }
                if (isAllow(list.get(0).getId()) == Constant.CONTENT_ADMIN) {
                    return Constant.CONTENT_ADMIN;
                }
                parameterException.addErrorParameter("error", "you don't have the permission");
                throw parameterException;
            }
            parameterException.addErrorParameter("error", "a validation error");
        } else {
            parameterException.addErrorParameter("error", "a validation error");
        }

        if (parameterException.hasErrorParameter()) {
            throw parameterException;
        }
        return 0;
    }

    public User setSessionUser(String userName) {
        List<User> list = userDao.queryByUserName(userName);
        User user = new User();
        user.setId(list.get(0).getId());
        user.setUserName(userName);

        return user;
    }

    public int isAllow(int id) {

        int roleId = userRoleDao.getRoleById(id);
        String roleString = roleDao.getRoleById(roleId);

        if (roleString.equals("system_admin")) {
            return Constant.SYS_ADMIN;
        }

        if(roleString.equals("content_admin")) {
            return Constant.CONTENT_ADMIN;
        }

        return 0;
    }

}
