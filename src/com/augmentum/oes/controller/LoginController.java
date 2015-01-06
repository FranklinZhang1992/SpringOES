package com.augmentum.oes.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.service.base.UserService;
import com.augmentum.oes.util.Constant;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

    @Resource(name="userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initModelAndView(HttpSession session) {
        ModelAndView mav = new ModelAndView(Constant.JSP_LOGIN);
        session.invalidate();
        return mav;
    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loginModelAndView(@RequestParam(value="userName") String userName, @RequestParam(value="password") String password, HttpSession session) {
        try {
            int to = userService.login(userName, password);
            session.setAttribute(Constant.KEY_USER, userService.setSessionUser(userName));
            if (to == Constant.SYS_ADMIN) {
                ModelAndView mav = new ModelAndView(Constant.JSP_MAINSYS);
                return mav;
            }
            if (to == Constant.CONTENT_ADMIN) {
                ModelAndView mav = new ModelAndView(Constant.JSP_MAIN);
                return mav;
            }
        } catch (ParameterException e) {
            ModelAndView mav = new ModelAndView(Constant.JSP_LOGIN);
            mav.addObject(Constant.KEY_EXCETION_MESSAGE, e.getErrorParameters());
            return mav;
        }
        return null;
    }

}
