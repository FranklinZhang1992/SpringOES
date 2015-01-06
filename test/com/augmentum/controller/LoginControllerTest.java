package com.augmentum.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.controller.LoginController;
import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.User;
import com.augmentum.oes.service.base.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class LoginControllerTest {

    @Resource(name="loginController")
    private LoginController loginController;

    @Test
    public void testlogin() throws ParameterException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        String userName = "Cont";
        String password = "123456";
        User user = new User();
        user.setUserName("Cont");

        UserService userService= EasyMock.createMock(UserService.class);

        EasyMock.expect(userService.login("Cont", "123456")).andReturn(2);

        EasyMock.expect(userService.setSessionUser("Cont")).andReturn(user);
        EasyMock.replay(userService);
        loginController.setUserService(userService);
        HttpSession session = request.getSession();
        ModelAndView mav = loginController.loginModelAndView(userName, password, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("main", modelName);
        user = (User) session.getAttribute("user");
        Assert.assertEquals("Cont", user.getUserName());
    }

    @Test
    public void testLogin2() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String userName = "Sys";
        String password = "123456";
        User user = new User();
        user.setUserName("Sys");

        UserService userService= EasyMock.createMock(UserService.class);

        EasyMock.expect(userService.login("Sys", "123456")).andReturn(1);

        EasyMock.expect(userService.setSessionUser("Sys")).andReturn(user);
        EasyMock.replay(userService);
        loginController.setUserService(userService);
        HttpSession session = request.getSession();
        ModelAndView mav = loginController.loginModelAndView(userName, password, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("main_sys", modelName);
        user = (User) session.getAttribute("user");
        Assert.assertEquals("Sys", user.getUserName());
    }

    @Test
    public void testLogin3() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String userName = "Tea";
        String password = "123456";
        ParameterException parameterException = new ParameterException();
        parameterException.addErrorParameter("error", "you don't have the permission");

        UserService userService= EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.login("Tea", "123456")).andThrow(parameterException);
        EasyMock.replay(userService);
        loginController.setUserService(userService);
        HttpSession session = request.getSession();
        ModelAndView mav = loginController.loginModelAndView(userName, password, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("login", modelName);
        String errorMessage = parameterException.getErrorParameters().get("error");
        Assert.assertEquals("you don't have the permission", errorMessage);
    }

    @Test
    public void testLogin4() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String userName = "Stu";
        String password = "123456";
        ParameterException parameterException = new ParameterException();
        parameterException.addErrorParameter("error", "you don't have the permission");

        UserService userService= EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.login("Stu", "123456")).andThrow(parameterException);
        EasyMock.replay(userService);
        loginController.setUserService(userService);
        HttpSession session = request.getSession();
        ModelAndView mav = loginController.loginModelAndView(userName, password, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("login", modelName);
        String errorMessage = parameterException.getErrorParameters().get("error");
        Assert.assertEquals("you don't have the permission", errorMessage);
    }

    @Test
    public void testLogin5() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String userName = "Cont";
        String password = "654321";
        ParameterException parameterException = new ParameterException();
        parameterException.addErrorParameter("error", "a validation error");

        UserService userService= EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.login("Cont", "654321")).andThrow(parameterException);
        EasyMock.replay(userService);
        loginController.setUserService(userService);
        HttpSession session = request.getSession();
        ModelAndView mav = loginController.loginModelAndView(userName, password, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("login", modelName);
        String errorMessage = parameterException.getErrorParameters().get("error");
        Assert.assertEquals("a validation error", errorMessage);
    }

    @Test
    public void testLogin6() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String userName = "";
        String password = "";
        ParameterException parameterException = new ParameterException();
        parameterException.addErrorParameter("userNameError", "user name is required");
        parameterException.addErrorParameter("passwordError", "password is required");

        UserService userService= EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.login("", "")).andThrow(parameterException);
        EasyMock.replay(userService);
        loginController.setUserService(userService);
        HttpSession session = request.getSession();
        ModelAndView mav = loginController.loginModelAndView(userName, password, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("login", modelName);
        String errorUserName = parameterException.getErrorParameters().get("userNameError");
        String errorPassword = parameterException.getErrorParameters().get("passwordError");
        Assert.assertEquals("user name is required", errorUserName);
        Assert.assertEquals("password is required", errorPassword);
    }

}
