package com.augmentum.oes.modle;

import java.io.Serializable;

public class RolePermission implements Serializable {

    private static final long serialVersionUID = 4430832748309773514L;

    private int roleId;
    private int permissionId;
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public int getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }


}
