package com.augmentum.oes.dao;

import java.util.List;

import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;


public interface QuestionDao extends BaseDao<Question, Integer> {

    public int queryQuestion(Pagination<Question> pagination);

    public List<Question> queryRandomQuestions(int amount);

    public void queryQuestions(Pagination<Question> pagination);


}
