package com.augmentum.oes.dao;

import java.util.List;

import com.augmentum.oes.modle.Permission;

public interface PermissionDao extends BaseDao<Permission, Integer> {

    //get permission by id
    public List<Permission> queryPermissionById(int id);

}
