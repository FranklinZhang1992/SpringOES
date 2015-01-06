package com.augmentum.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.RoleDao;
import com.augmentum.oes.modle.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "classpath:serviceContext.xml", "classpath:springMVC.xml" })
public class RoleDaoTest {

    @Resource(name="roleDao")
    private RoleDao roleDao;

    @Test
    public void testGetById() {
        int id = 1;
        Role role = new Role();
        role = roleDao.getById(id);
        Assert.assertEquals("teacher", role.getCode());
    }

}
