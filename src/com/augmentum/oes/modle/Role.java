package com.augmentum.oes.modle;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = 7218791420681790771L;

    private int id;
    private String name;
    private String code;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


}
