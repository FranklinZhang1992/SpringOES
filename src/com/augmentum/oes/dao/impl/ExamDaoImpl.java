package com.augmentum.oes.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augmentum.oes.dao.ExamDao;
import com.augmentum.oes.modle.Exam;
import com.augmentum.oes.modle.Pagination;

public class ExamDaoImpl extends BaseDaoImpl<Exam, Integer> implements ExamDao {

    private static final String SQL_GET_TOTAL = ".getTotal";
    private static final String SQL_QUERY = ".queryExam";

    public int queryExam(Pagination<Exam> pagination) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (pagination.getParams().get("name") != null) {
            map.put("name", "%" + pagination.getParams().get("name") + "%");
            map.put("description", "");
        } else if (pagination.getParams().get("description") != null) {
            map.put("description", "%" + pagination.getParams().get("description") + "%");
            map.put("name", "");
        } else {
            map.put("name", "");
            map.put("description", "");
        }
        Integer count = this.getSqlSession().selectOne(this.getActuallModleClassType().getName() + SQL_GET_TOTAL, map);
        pagination.setTotalCount(count);

        if (count > 0) {
            map.put("offSet", pagination.getOffset());
            map.put("pageSize", pagination.getPageSize());
            List<Exam> list = this.getSqlSession().selectList(this.getActuallModleClassType().getName() + SQL_QUERY, map);
            pagination.setData(list);
        }
        return count;
    }
}
