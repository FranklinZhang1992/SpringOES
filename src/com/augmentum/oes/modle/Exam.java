package com.augmentum.oes.modle;

import java.io.Serializable;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class Exam implements Serializable {

    private static final long serialVersionUID = -9202191897920239405L;

    private int id;

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "description is required")
    @NotEmpty(message = "description is required")
    private String description;

    @NotNull(message = "single question score is required")
    @NotEmpty(message = "single question score is required")
    private int singleQuestionScore;

    @NotNull(message = "question quantity is required")
    @NotEmpty(message = "question quantity is required")
    private int questionQuantity;
    private int totalScore;

    @NotNull(message = "duration is required")
    @NotEmpty(message = "duration is required")
    private int duration;
    private int examineeCount;
    private double passRate;
    private double averageScore;

    @NotNull(message = "pass standard is required")
    @NotEmpty(message = "pass standard is required")
    private double passStandard;

    @NotNull(message = "user id is required")
    @NotEmpty(message = "user id is required")
    private int userId;
    private String createTime;
    private String lastUpdatedTime;
    private int deleted;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getSingleQuestionScore() {
        return singleQuestionScore;
    }
    public void setSingleQuestionScore(int singleQuestionScore) {
        this.singleQuestionScore = singleQuestionScore;
    }
    public int getQuestionQuantity() {
        return questionQuantity;
    }
    public void setQuestionQuantity(int questionQuantity) {
        this.questionQuantity = questionQuantity;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getExamineeCount() {
        return examineeCount;
    }
    public void setExamineeCount(int examineeCount) {
        this.examineeCount = examineeCount;
    }
    public double getPassRate() {
        return passRate;
    }
    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }
    public double getAverageScore() {
        return averageScore;
    }
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
    public double getPassStandard() {
        return passStandard;
    }
    public void setPassStandard(double passStandard) {
        this.passStandard = passStandard;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }
    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
    public int getDeleted() {
        return deleted;
    }
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


}
