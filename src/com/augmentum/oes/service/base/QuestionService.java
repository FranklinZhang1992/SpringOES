package com.augmentum.oes.service.base;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;

public interface QuestionService {

    public int viewQuestionList(Pagination<Question> pagination);

    public void deleteQuestion(int id);

    public int createQuestion(Question question);

    public void updateQuestion(Question question);

    public Question getQuestion(int id);

    public void saveQuestion(Question question) throws ParameterException;

    public void listQuestion(Pagination<Question> pagination);

}
