package com.augmentum.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.PaperQuestionDao;
import com.augmentum.oes.modle.PaperQuestion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class PaperQuestionDaoTest {

    @Resource(name="paperQuestionDao")
    private PaperQuestionDao paperQuestionDao;

    @Test
    public void testCreate() {
        PaperQuestion paperQuestion = new PaperQuestion();
        paperQuestion.setExamId(1);
        paperQuestion.setName("testPaper");
        paperQuestion.setOptionA("optionA");
        paperQuestion.setOptionB("optionB");
        paperQuestion.setOptionC("optionC");
        paperQuestion.setOptionD("optionD");
        paperQuestion.setAnswer("A");
        paperQuestion.setQuestionId(3);
        paperQuestionDao.create(paperQuestion);
    }

}
