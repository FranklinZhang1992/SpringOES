package com.augmentum.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;
import com.augmentum.oes.service.base.QuestionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class QuestionServiceTest {

    @Resource(name="questionService")
    private QuestionService questionService;

    @Test
    public void testViewQuestionList() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "");
        int count = questionService.viewQuestionList(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        Assert.assertNotSame(0, count);
    }

    @Test
    public void testViewQuestionListByKey() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "t");
        int count = questionService.viewQuestionList(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        System.out.println(count);
        Assert.assertNotSame(0, count);
    }

    @Test
    public void testCreateQuestion() throws ParameterException {
        Question question = new Question();
        question.setTitle("test");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);
        questionService.saveQuestion(question);
    }

    @Test
    public void testDeleteQuestion() {
        Question question = new Question();
        question.setTitle("test");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);
        questionService.createQuestion(question);
        int id = question.getId();
        questionService.deleteQuestion(id);
    }

    @Test
    public void testGetQuestion() {
        Question question = new Question();
        question.setTitle("test");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);
        questionService.createQuestion(question);
        int id = question.getId();
        Question question2 = questionService.getQuestion(id);
        Assert.assertNotNull(question2);
    }

    @Test
    public void testUpdateQuestion() throws ParameterException {
        Question question = new Question();
        question.setTitle("test");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);
        questionService.createQuestion(question);
        int id = question.getId();
        question.setId(id);
        question.setTitle("testUpdate");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);
        questionService.saveQuestion(question);
    }

    @Test(expected=ParameterException.class)
    public void testSaveQuestion() throws ParameterException {
        Question question = new Question();
        questionService.saveQuestion(question);
    }
}
