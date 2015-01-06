package com.augmentum.oes.modle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augmentum.oes.util.Constant;

public class Pagination<T> {

    private int totalCount = 0;
    private int currentPage = 1;
    private int pageSize = Constant.PAGE_AMOUNT;
    private String relativeUrl;
    private Map<String, Object> params = new HashMap<String, Object>();
    private List<T> data = new ArrayList<T>();

    public String getRelativeUrl() {
        return relativeUrl;
    }

    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void addData(T item) {
        this.data.add(item);
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void addParam(String key, Object value) {
        if (params != null) {
            params.put(key, value);
        }
    }

    public int getOffset() {
        return (getCurrentPage() - 1) * getPageSize();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        if (currentPage < 1) {
            currentPage = 1;
        }
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public Integer getPageCount() {
        if (totalCount < 1) {
            return 0;
        }
       return (totalCount - 1) / pageSize + 1;
    }

}
