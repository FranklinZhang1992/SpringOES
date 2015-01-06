package com.augmentum.oes.dao;

import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.modle.Pagination;

public interface ExamDao extends BaseDao<Exam, Integer> {

    public int queryExam(Pagination<Exam> pagination);

}
