package com.augmentum.oes.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.modle.Pagination;
import com.augmentum.oes.modle.Question;

public class QuestionDaoImpl extends BaseDaoImpl<Question, Integer> implements QuestionDao {

    private static final String SQL_GET_TOTAL = ".getTotal";
    private static final String SQL_QUERY = ".queryQuestion";
    private static final String SQL_QUERY_RANDOM = ".queryRandom";
    private static final String SQL_QUERY_QUESTION =".queryquestions";

    public int queryQuestion(Pagination<Question> pagination) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (pagination.getParams().get("keyword") != null) {
            map.put("keyword", "%" + pagination.getParams().get("keyword") + "%");
        } else {
            map.put("keyword", "");
        }

        Integer count = this.getSqlSession().selectOne(this.getActuallModleClassType().getName() + SQL_GET_TOTAL, map);
        pagination.setTotalCount(count);

        if (count > 0) {
            map.put("offSet", pagination.getOffset());
            map.put("pageSize", pagination.getPageSize());
            List<Question> list = this.getSqlSession().selectList(this.getActuallModleClassType().getName() + SQL_QUERY, map);
            pagination.setData(list);
        }
        return count;
    }

    public List<Question> queryRandomQuestions(int amount) {
        return this.getSqlSession().selectList(this.getActuallModleClassType().getName() + SQL_QUERY_RANDOM, amount);
    }

    @Override
    public void queryQuestions(Pagination<Question> pagination) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (pagination.getParams().get("keyword") != null) {
            map.put("keyword", "%" + pagination.getParams().get("keyword") + "%");
        } else {
            map.put("keyword", "");
        }
        Integer count = this.getSqlSession().selectOne(this.getActuallModleClassType().getName() + SQL_GET_TOTAL, map);
        pagination.setTotalCount(count);

        if (count > 0) {
            if (pagination.getParams().get("field") != null) {
                map.put("field", pagination.getParams().get("field"));
            } else {
                map.put("field", "");
            }

            map.put("method", pagination.getParams().get("method"));
            map.put("offSet", pagination.getOffset());
            map.put("pageSize", pagination.getPageSize());
            List<Question> list = this.getSqlSession().selectList(this.getActuallModleClassType().getName() + SQL_QUERY_QUESTION, map);
            pagination.setData(list);
        }
    }

}
