package com.augmentum.oes.modle;

import java.io.Serializable;

public class UserRole implements Serializable {

    private static final long serialVersionUID = -4649976335352209966L;

    private int userId;
    private int roleId;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


}
