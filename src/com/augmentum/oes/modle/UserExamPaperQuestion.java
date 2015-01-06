package com.augmentum.oes.modle;

import java.io.Serializable;

public class UserExamPaperQuestion implements Serializable {

    private static final long serialVersionUID = -8156095655555467534L;

    private int userId;
    private int examId;
    private int paperQuestionId;
    private String option;
    private String createTime;
    private String standardAnswer;
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
    public int getPaperQuestionId() {
        return paperQuestionId;
    }
    public void setPaperQuestionId(int paperQuestionId) {
        this.paperQuestionId = paperQuestionId;
    }
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getStandardAnswer() {
        return standardAnswer;
    }
    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }


}
