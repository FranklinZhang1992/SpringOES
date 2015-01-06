package com.augmentum.oes.modle;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 6766736997418056625L;

    private int id;
    private String userName;
    private String password;
    private String fullName;
    private String telephone;
    private String gender;
    private String chineseName;
    private String email;
    private String createdTime;
    private String lastUpdatedTime;
    private int deleted;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getChineseName() {
        return chineseName;
    }
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
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
    public static long getSerialversionuid() {
        return serialVersionUID;
    }



}
