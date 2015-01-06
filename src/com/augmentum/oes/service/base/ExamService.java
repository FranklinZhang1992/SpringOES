package com.augmentum.oes.service.base;

import com.augmentum.oes.exception.ParameterException;
import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.modle.Pagination;

public interface ExamService {

    public int viewExamList(Pagination<Exam> pagination);

    public void update(Exam exam);

    public Exam getExam(int id);

    public void create(Exam exam);

    public void save(Exam exam) throws ParameterException;
}
