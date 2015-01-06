package com.augmentum.dao;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.ExamDao;
import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.modle.Pagination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class ExamDaoTest {

    @Resource(name="examDao")
    private ExamDao examDao;

    @Test
    public void testQuery() {
        Pagination<Exam> pagination = new Pagination<Exam>();
        pagination.setCurrentPage(1);
        //pagination.addParam("name", "");
        //pagination.addParam("description", "");
        int count = examDao.queryExam(pagination);
        List<Exam> list = pagination.getData();
        Assert.assertNotNull(list);
        Assert.assertNotSame(0, count);
    }

    @Test
    public void testCreate() {
        Exam exam = new Exam();
        exam.setName("test");
        exam.setDescription("testexam");
        exam.setSingleQuestionScore(10);
        exam.setQuestionQuantity(10);
        exam.setTotalScore(10 * 10);
        exam.setDuration(100);
        exam.setPassStandard(0.6);
        exam.setUserId(3);

        int id = examDao.create(exam);
        System.out.println("id= " + id);
        Assert.assertNotSame(0, id);
    }

    @Test
    public void testUpdate() {
        Exam exam = new Exam();
        exam.setId(2);
        exam.setName("testUpdate1");
        exam.setDescription("testexam");
        examDao.update(exam);
    }

    @Test
    public void testGetById() {
        int id = 2;
        Exam exam = examDao.getById(id);
        Assert.assertNotNull(exam);
    }

    @Test
    public void testDelete() {
        int id = 1;
        examDao.delete(id);
        Exam exam = examDao.getById(id);
        Assert.assertNull(exam);
    }

}
