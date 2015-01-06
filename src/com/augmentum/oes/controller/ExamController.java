package com.augmentum.oes.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.User;
import com.augmentum.oes.service.base.ExamService;
import com.augmentum.oes.util.Constant;

@Controller
@RequestMapping("/exam")
public class ExamController {

    @Resource(name="examService")
    private ExamService examService;

    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    @RequestMapping(value = {"/list/{pageNumber}"}, method = RequestMethod.GET)
    public ModelAndView list(@PathVariable(value="pageNumber") int pageNumber, @RequestParam(value="type") String type,@RequestParam(value="keyword") String keyword) {

        Pagination<Exam> pagination = new Pagination<Exam>();
        pagination.setCurrentPage(pageNumber);
        if (type.equals("NAME")) {
            pagination.addParam(Constant.KEY_SEARCH_NAME, keyword);
        }
        if (type.equals("DESCRIPTION")) {
            pagination.addParam(Constant.KEY_SEARCH_DESCRIPTION, keyword);
        }
        examService.viewExamList(pagination);
        int totalPage = pagination.getPageCount();
        ModelAndView mav = new ModelAndView(Constant.JSP_EXAMLIST);
        mav.addObject(Constant.KEY_SEARCH_CONTENT, keyword);
        mav.addObject(Constant.KEY_SEARCH_TYPE, type);
        mav.addObject(Constant.KEY_TABLE, pagination.getData());
        mav.addObject(Constant.KEY_TOTAL_PAGE, totalPage);
        mav.addObject(Constant.KEY_PAGE_NUMBER, pageNumber);
        return mav;
    }

    @RequestMapping(value = {"/update/{examId}"}, method = RequestMethod.GET)
    public ModelAndView update(@PathVariable(value="examId") int examId) {
        Exam exam = examService.getExam(examId);
        ModelAndView mav = new ModelAndView(Constant.JSP_EDITEXAM);
        mav.addObject(Constant.KEY_EXAM, exam);
        return mav;
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView(Constant.JSP_CREATEEXAM);
        Exam exam = new Exam();
        mav.addObject(Constant.KEY_EXAM, exam);
        return mav;
    }

    @RequestMapping(value = {"/saveCreate"}, method = RequestMethod.POST)
    public ModelAndView saveCreate(Exam exam, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            exam.setUserId(id);
            examService.save(exam);
            ModelAndView mav = new ModelAndView("redirect:/exam/list/" + 1);
            mav.addObject(Constant.KEY_SEARCH_CONTENT, "");
            mav.addObject(Constant.KEY_SEARCH_TYPE, "NAME");
            return mav;
        } catch (ParameterException e) {
            ModelAndView mav = new ModelAndView(Constant.JSP_CREATEEXAM);
            mav.addObject(Constant.KEY_EXCETION_MESSAGE, e.getErrorParameters());
            return mav;
        }
    }

    @RequestMapping(value = {"/saveUpdate"}, method = RequestMethod.POST)
    public ModelAndView saveUpdate(Exam exam, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            exam.setUserId(id);
            examService.save(exam);
            ModelAndView mav = new ModelAndView("redirect:/exam/list/" + 1);
            mav.addObject(Constant.KEY_SEARCH_CONTENT, "");
            mav.addObject(Constant.KEY_SEARCH_TYPE, "NAME");
            return mav;
        } catch (ParameterException e) {
            ModelAndView mav = new ModelAndView(Constant.JSP_EDITEXAM);
            mav.addObject(Constant.KEY_EXCETION_MESSAGE, e.getErrorParameters());
            return mav;
        }
    }

}
