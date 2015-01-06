package com.augmentum.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.PermissionDao;
import com.augmentum.oes.modle.Permission;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "classpath:serviceContext.xml", "classpath:springMVC.xml" })
public class PermissionDaoTest {

    @Resource(name="permissionDao")
    private PermissionDao permissionDao;

    @Test
    public void testPermission() {
        int id = 1;
        Permission permission = new Permission();
        permission = permissionDao.getById(id);
        Assert.assertEquals("create_user", permission.getCode());
    }

}
