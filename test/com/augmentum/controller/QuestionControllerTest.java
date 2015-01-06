package com.augmentum.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.augmentum.oes.controller.QuestionController;
import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;
import com.augmentum.oes.modle.User;
import com.augmentum.oes.service.base.QuestionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class QuestionControllerTest {

    @Resource(name="questionController")
    private QuestionController questionController;

    @SuppressWarnings("unchecked")
    @Test
    public void testQuestionList() {
        int pageNumber = 1;
        String keyword = "";
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(pageNumber);
        pagination.addParam("keyword", "");
        pagination.setTotalCount(10);
        List<Question> list = new ArrayList<Question>();
        Question question = new Question();
        question.setId(1);
        question.setTitle("title");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        list.add(question);
        pagination.setData(list);

        QuestionService questionService= EasyMock.createMock(QuestionService.class);

        EasyMock.expect(questionService.viewQuestionList(EasyMock.isA(Pagination.class))).andReturn(1);
        EasyMock.replay(questionService);

        questionController.setQuestionService(questionService);

        ModelAndView mav = questionController.listModelAndView(pageNumber, keyword);
        String modelName = mav.getViewName();
        Assert.assertEquals("question_list", modelName);
        String keywordMav = (String) mav.getModel().get("keyword");
        int pageNumberMav = ((Integer) mav.getModel().get("pageNumber")).intValue();
        List<Question> listMav = (List<Question>) mav.getModel().get("table");
        Assert.assertEquals("", keywordMav);
        Assert.assertNotNull(listMav);
        Assert.assertEquals(1, pageNumberMav);
    }

    @Test
    public void testDelete() {
        int pageNumber = 1;
        int questionId = 1;
        String keyword = "";

        QuestionService questionService= EasyMock.createMock(QuestionService.class);

        questionService.deleteQuestion(1);
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(questionService);

        questionController.setQuestionService(questionService);
        ModelAndView mav = questionController.deleteModelAndView(pageNumber, questionId, keyword);
        String modelName = mav.getViewName();
        String keywordMav = (String) mav.getModel().get("keyword");

        Assert.assertEquals("redirect:/question/list/" + pageNumber, modelName);
        Assert.assertEquals(keyword, keywordMav);
    }

    @Test
    public void testUpdate() {
        int questionId = 1;

        Question question = new Question();
        question.setId(1);
        question.setTitle("title");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");

        QuestionService questionService= EasyMock.createMock(QuestionService.class);
        EasyMock.expect(questionService.getQuestion(1)).andReturn(question);
        EasyMock.replay(questionService);

        questionController.setQuestionService(questionService);
        ModelAndView mav = questionController.updateModelAndView(questionId);
        String modelName = mav.getViewName();

        Assert.assertEquals("save_question", modelName);
        Assert.assertEquals(question, mav.getModel().get("question"));
    }

    @Test
    public void testCreate() {
        ModelAndView mav = questionController.createModelAndView();
        String modelName = mav.getViewName();
        Assert.assertEquals("save_question", modelName);
    }

    @Test
    public void testSave() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = request.getSession();
        User user = new User();
        user.setUserName("Cont");
        session.setAttribute("user", user);
        Question question = new Question();
        question.setTitle("title");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");

        QuestionService questionService= EasyMock.createMock(QuestionService.class);
        questionService.saveQuestion(EasyMock.isA(Question.class));
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(questionService);

        questionController.setQuestionService(questionService);
        ModelAndView mav = questionController.saveModelAndView(question, session);
        String modelName = mav.getViewName();
        Assert.assertEquals("redirect:/question/list/" + 1, modelName);
    }

    @Test
    public void testSave2() throws ParameterException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = request.getSession();
        User user = new User();
        user.setUserName("Cont");
        session.setAttribute("user", user);
        Question question = new Question();
        question.setId(1);
        question.setTitle("title");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("");
        ParameterException parameterException = new ParameterException();
        parameterException.addErrorParameter("answerError", "answer is required");

        QuestionService questionService= EasyMock.createMock(QuestionService.class);
        questionService.saveQuestion(EasyMock.isA(Question.class));
        EasyMock.expectLastCall().andThrow(parameterException);
        EasyMock.replay(questionService);

        questionController.setQuestionService(questionService);
        ModelAndView mav = questionController.saveModelAndView(question, session);
        String modelName = mav.getViewName();
        String error = parameterException.getErrorParameters().get("answerError");
        System.out.println(modelName);
        Assert.assertEquals("save_question", modelName);
        Assert.assertEquals("answer is required", error);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testQuestionListB() {
        int pageNumber = 1;
        String keyword = "";
        String field = "id";
        String method = "ASC";
        int pageSize = 10;

        QuestionService questionService= EasyMock.createMock(QuestionService.class);
        questionService.listQuestion(EasyMock.isA(Pagination.class));
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(questionService);

        questionController.setQuestionService(questionService);
        Pagination<Question> pagination = questionController.list(pageNumber, keyword, field, method, pageSize);
        int pageNumber2 = pagination.getCurrentPage();
        Assert.assertEquals(1, pageNumber2);
    }

    @Test
    public void testDelete2() {
        int questionId = 1;
        QuestionService questionService= EasyMock.createMock(QuestionService.class);

        questionService.deleteQuestion(1);
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(questionService);
        questionController.setQuestionService(questionService);
        questionController.delete(questionId);
    }




}
