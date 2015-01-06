package com.augmentum.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.service.base.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class UserServiceTest {

    @Resource(name="userService")
    private UserService userService;

    @Test
    public void testLogin() {
        String userName = "Cont";
        String password = "123456";
        int to = 0;
        try {
            to = userService.login(userName, password);
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(2, to);
    }

}
