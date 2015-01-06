package com.augmentum.oes.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;
import com.augmentum.oes.modle.User;
import com.augmentum.oes.service.base.QuestionService;
import com.augmentum.oes.util.Constant;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {

    @Resource(name="questionService")
    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = ("/"), method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView(Constant.JSP_LIST);
        return mav;
    }

    @RequestMapping(value = {"/list/{pageNumber}"}, method = RequestMethod.GET)
    public ModelAndView listModelAndView(@PathVariable(value="pageNumber") int pageNumber, @RequestParam(value="keyword") String keyword) {

        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(pageNumber);
        pagination.addParam(Constant.KEY_SEARCH_CONTENT, keyword);
        questionService.viewQuestionList(pagination);
        int totalPage = pagination.getPageCount();
        ModelAndView mav = new ModelAndView(Constant.JSP_QUESTIONLIST);
        mav.addObject(Constant.KEY_SEARCH_CONTENT, keyword);
        mav.addObject(Constant.KEY_TABLE, pagination.getData());
        mav.addObject(Constant.KEY_TOTAL_PAGE, totalPage);
        mav.addObject(Constant.KEY_PAGE_NUMBER, pageNumber);
        return mav;
    }

    @RequestMapping(value = {"/delete/{pageNumber}/{questionId}"}, method = RequestMethod.GET)
    public ModelAndView deleteModelAndView(@PathVariable(value="pageNumber") int pageNumber, @PathVariable(value="questionId") int questionId, @RequestParam(value="keyword") String keyword) {
        questionService.deleteQuestion(questionId);
        ModelAndView mav = new ModelAndView("redirect:/question/list/" + pageNumber);
        mav.addObject(Constant.KEY_SEARCH_CONTENT, keyword);
        return mav;
    }

    @RequestMapping(value = {"/update/{questionId}"}, method = RequestMethod.GET)
    public ModelAndView updateModelAndView(@PathVariable(value="questionId") int questionId) {
        Question question = questionService.getQuestion(questionId);
        ModelAndView mav = new ModelAndView(Constant.JSP_SAVEQUESTION);
        mav.addObject(Constant.KEY_QUESTION, question);
        return mav;
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public ModelAndView createModelAndView() {
        ModelAndView mav = new ModelAndView(Constant.JSP_SAVEQUESTION);
        Question question = new Question();
        mav.addObject(Constant.KEY_QUESTION, question);
        return mav;
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ModelAndView saveModelAndView(Question question, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            question.setUserId(id);
            questionService.saveQuestion(question);
            ModelAndView mav = new ModelAndView("redirect:/question/list/" + 1);
            mav.addObject(Constant.KEY_SEARCH_CONTENT, "");
            return mav;
        } catch (ParameterException e) {
            ModelAndView mav = new ModelAndView(Constant.JSP_SAVEQUESTION);
            mav.addObject(Constant.KEY_EXCETION_MESSAGE, e.getErrorParameters());
            return mav;
        }
    }

    @RequestMapping(value = {"/listb"}, method = RequestMethod.GET)
    public @ResponseBody Pagination<Question> list(
            @RequestParam(value="pagenumber") int pageNumber,
            @RequestParam(value="keyword") String keyword,
            @RequestParam(value="field") String field,
            @RequestParam(value="method") String method,
            @RequestParam(value="pagesize") int pageSize) {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.addParam("keyword", keyword);
        pagination.addParam("method", method);
        pagination.addParam("field", field);
        pagination.setCurrentPage(pageNumber);
        pagination.setPageSize(pageSize);
        questionService.listQuestion(pagination);
        return pagination;
    }

    @RequestMapping(value = ("/deleteb"), method = RequestMethod.GET)
    public void delete(@RequestParam(value="questionid") int questionId) {
        questionService.deleteQuestion(questionId);
    }
}
