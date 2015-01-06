package com.augmentum.oes.modle;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import com.augmentum.oes.util.StringUtil;


public class Question {


    private int id;

    @NotNull(message = "title is required")
    @NotEmpty(message = "title is required")
    private String title;

    @NotNull(message = "option A is required")
    @NotEmpty(message = "option A is required")
    private String optionA;
    @NotNull(message = "option B is required")
    @NotEmpty(message = "option B is required")
    private String optionB;
    @NotNull(message = "option C is required")
    @NotEmpty(message = "option C is required")
    private String optionC;
    @NotNull(message = "option D is required")
    @NotEmpty(message = "option D is required")
    private String optionD;
    @NotNull(message = "answer is required")
    @NotEmpty(message = "answer is required")
    private String answer;
    private int deleted;
    private int userId;
    private String creaetTime;
    private String lastUpdatedTime;
    @SuppressWarnings("unused")
    private String qId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getOptionA() {
        return optionA;
    }
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public String getOptionC() {
        return optionC;
    }
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public String getOptionD() {
        return optionD;
    }
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public int getDeleted() {
        return deleted;
    }
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getCreaetTime() {
        return creaetTime;
    }
    public void setCreaetTime(String creaetTime) {
        this.creaetTime = creaetTime;
    }
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }
    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
    public String getqId() {
        return StringUtil.getQId(this.id);
    }
    public void setqId() {
        this.qId = StringUtil.getQId(id);
    }



}
