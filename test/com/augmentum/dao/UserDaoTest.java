package com.augmentum.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.UserDao;
import com.augmentum.oes.modle.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "classpath:serviceContext.xml", "classpath:springMVC.xml" })
public class UserDaoTest {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void testGetById() {
        User user = new User();
        user = userDao.getById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void testQueryByUserName() {
        String userName = "Cont";
        List<User> list = userDao.queryByUserName(userName);
        Assert.assertEquals(1, list.size());
    }

}
