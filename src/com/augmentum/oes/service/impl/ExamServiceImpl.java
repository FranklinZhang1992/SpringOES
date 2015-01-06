package com.augmentum.oes.service.impl;

import java.util.List;

import com.augmentum.oes.common.base.BaseService;
import com.augmentum.oes.dao.ExamDao;
import com.augmentum.oes.dao.PaperQuestionDao;
import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.PaperQuestion;
import com.augmentum.oes.modle.Question;
import com.augmentum.oes.service.base.ExamService;


public class ExamServiceImpl extends BaseService implements ExamService {

    private ExamDao examDao;
    private QuestionDao questionDao;
    private PaperQuestionDao paperQuestionDao;

    public ExamDao getExamDao() {
        return examDao;
    }

    public void setExamDao(ExamDao examDao) {
        this.examDao = examDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public PaperQuestionDao getPaperQuestionDao() {
        return paperQuestionDao;
    }

    public void setPaperQuestionDao(PaperQuestionDao paperQuestionDao) {
        this.paperQuestionDao = paperQuestionDao;
    }

    //methods to controll dao
    public int viewExamList(Pagination<Exam> pagination) {
        return examDao.queryExam(pagination);
    }

    public void update(Exam exam) {
        examDao.update(exam);
    }

    public void create(Exam exam) {
        exam.setTotalScore(exam.getSingleQuestionScore() * exam.getQuestionQuantity());
        examDao.create(exam);
        int examId = exam.getId();
        List<Question> questionList = questionDao.queryRandomQuestions(exam.getQuestionQuantity());
        PaperQuestion paperQuestion = null;
        for (int i = 0; i < questionList.size(); i++) {
            paperQuestion = new PaperQuestion();
            paperQuestion.setExamId(examId);
            paperQuestion.setQuestionId(questionList.get(i).getId());
            paperQuestion.setName(questionList.get(i).getTitle());
            paperQuestion.setOptionA(questionList.get(i).getOptionA());
            paperQuestion.setOptionB(questionList.get(i).getOptionB());
            paperQuestion.setOptionC(questionList.get(i).getOptionC());
            paperQuestion.setOptionD(questionList.get(i).getOptionD());
            paperQuestion.setAnswer(questionList.get(i).getAnswer());
            paperQuestionDao.create(paperQuestion);
        }
    }

    public Exam getExam(int id) {
        return examDao.getById(id);
    }

    public void save(Exam exam) throws ParameterException {
        this.validateObject(exam);
        if(exam.getId() == 0) {
            create(exam);
        } else {
            update(exam);
        }
    }

}
