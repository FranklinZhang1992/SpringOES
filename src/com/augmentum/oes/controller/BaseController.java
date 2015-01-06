package com.augmentum.oes.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.util.Constant;

@Controller
public abstract class BaseController {

    private static final Log log = LogFactory.getLog(BaseController.class);
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request, HttpServletResponse response){

        String errorMessage = "There are errors in controller!";
        log.error(errorMessage);
        ModelAndView mav = new ModelAndView(Constant.JSP_EXCEPTION);
        mav.addObject(Constant.KEY_EXCETION_MESSAGE, errorMessage);
        return mav;
    }

}
