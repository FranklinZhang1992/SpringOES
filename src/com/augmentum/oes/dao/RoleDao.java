package com.augmentum.oes.dao;

import com.augmentum.oes.modle.Role;

public interface RoleDao extends BaseDao<Role, Integer> {

    //get role by id
    public String getRoleById(int id);

}
