package com.augmentum.dao;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class QuestionDaoTest {

    @Resource(name="questionDao")
    private QuestionDao questionDao;

    @Test
    public void testCreateQuestion() {
        Question question = new Question();
        question.setTitle("testQuestion");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);
        int id;
        questionDao.create(question);
        id = question.getId();
        System.out.println(id);
        Assert.assertNotSame(0, id);
        int idInDB;
        question = questionDao.getById(id);
        idInDB = question.getId();

        Assert.assertEquals(id, idInDB);
    }

    @Test
    public void testDeleteQuestion() {
        int id = 33;
        questionDao.delete(id);
        Question question = questionDao.getById(id);
        Assert.assertNull(question);
    }

    @Test
    public void testGetById() {
        int id = 78;
        Question question = questionDao.getById(id);
        Assert.assertNotNull(question);
    }

    @Test
    public void testUpdate() {
        Question question = new Question();
        int id = 78;
        question.setId(id);
        question.setTitle("testUpdate");
        question.setOptionA("optionA");
        question.setOptionB("optionB");
        question.setOptionC("optionC");
        question.setOptionD("optionD");
        question.setAnswer("A");
        question.setUserId(3);

        questionDao.update(question);
        String titleString = questionDao.getById(id).getTitle();
        Assert.assertEquals("testUpdate", titleString);
    }

    @Test
    public void testQuery() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "");
        int count = questionDao.queryQuestion(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        Assert.assertNotSame(0, count);
    }

    @Test
    public void testQueryRandom() {
        int amount = 10;
        List<Question> list = questionDao.queryRandomQuestions(amount);
        Assert.assertNotNull(list);
    }

    @Test
    public void testQueryQuestions() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "");
        pagination.addParam("field", "id");
        pagination.addParam("method", "ASC");
        questionDao.queryQuestions(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("id= " + list.get(i).getId());
        }
    }

    @Test
    public void testQueryQuestions2() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "");
        pagination.addParam("field", "id");
        pagination.addParam("method", "DESC");
        questionDao.queryQuestions(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("id= " + list.get(i).getId());
        }
    }

    @Test
    public void testQueryQuestions3() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "");
        pagination.addParam("field", "last_updated_time");
        pagination.addParam("method", "ASC");
        questionDao.queryQuestions(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("id= " + list.get(i).getId());
            System.out.println("   last_updated_time= " + list.get(i).getLastUpdatedTime());
        }
    }

    @Test
    public void testQueryQuestions4() {
        Pagination<Question> pagination = new Pagination<Question>();
        pagination.setCurrentPage(1);
        pagination.addParam("keyword", "");
        pagination.addParam("field", "last_updated_time");
        pagination.addParam("method", "DESC");
        questionDao.queryQuestions(pagination);
        List<Question> list = pagination.getData();
        Assert.assertNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("id= " + list.get(i).getId());
            System.out.println("   last_updated_time= " + list.get(i).getLastUpdatedTime());
        }
    }

}
