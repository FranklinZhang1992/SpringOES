package com.augmentum.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.service.base.ExamService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:serviceContext.xml", "classpath:springMVC.xml"})
public class ExamServiceTest {

    @Resource(name="examService")
    private ExamService examService;

    @Test
    public void testCreateExam() throws ParameterException {
        Exam exam = new Exam();
        exam.setName("test22");
        exam.setDescription("test11");
        exam.setSingleQuestionScore(10);
        exam.setQuestionQuantity(2);
        exam.setDuration(100);
        exam.setPassStandard(0.6);
        exam.setUserId(3);
        examService.save(exam);

    }

    @Test
    public void testUpdateExam() throws ParameterException {
        Exam exam = new Exam();
        exam.setId(2);
        exam.setName("testUpdate1222");
        exam.setDescription("testexam");
        examService.save(exam);
    }
}
