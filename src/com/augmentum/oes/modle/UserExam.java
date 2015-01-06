package com.augmentum.oes.modle;

import java.io.Serializable;

public class UserExam implements Serializable {

    private static final long serialVersionUID = -8065398798000496997L;

    private int userId;
    private int examId;
    private int examScore;
    private String startTime;
    private String finishTime;
    private String result;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getExamId() {
        return examId;
    }
    public void setExamId(int examId) {
        this.examId = examId;
    }
    public int getExamScore() {
        return examScore;
    }
    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }


}
