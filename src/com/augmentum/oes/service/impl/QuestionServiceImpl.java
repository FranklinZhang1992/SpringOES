package com.augmentum.oes.service.impl;

import com.augmentum.oes.common.base.BaseService;
import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;
import com.augmentum.oes.service.base.QuestionService;

public class QuestionServiceImpl extends BaseService implements QuestionService{

    private QuestionDao questionDao;

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    //methods to controll dao
    public int viewQuestionList(Pagination<Question> pagination) {
        return questionDao.queryQuestion(pagination);
    }

    public void deleteQuestion(int id) {
        questionDao.delete(id);
    }

    public int createQuestion(Question question) {
        return questionDao.create(question);
    }

    public void updateQuestion(Question question){
        questionDao.update(question);
    }

    public Question getQuestion(int id) {
        return questionDao.getById(id);
    }

    @Override
    public void saveQuestion(Question question) throws ParameterException {

        this.validateObject(question);
        if (question.getId() == 0) {
            createQuestion(question);
        } else {
            updateQuestion(question);
        }
    }

    @Override
    public void listQuestion(Pagination<Question> pagination) {
        questionDao.queryQuestions(pagination);
        for (int i = 0; i < pagination.getData().size(); i++) {
            String s = pagination.getData().get(i).getLastUpdatedTime();
            pagination.getData().get(i).setLastUpdatedTime(s.substring(0, s.length() - 2));
        }
    }

}
