package com.augmentum.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.augmentum.oes.dao.RolePermissionDao;
import com.augmentum.oes.exception.DataBaseException;
import com.augmentum.oes.jdbc.JDBCUtil;

public class RolePermissionDaoImpl implements RolePermissionDao {

    @Override
    public int getPermissionById(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JDBCUtil jdbcUtil = null;

        int permissionId = 0;
        try {
            jdbcUtil = new JDBCUtil();
            conn = jdbcUtil.getMysqlConnection();
            String sql = "SELECT `permission_id` FROM `online_exam_system`.`role_permission` WHERE role_id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                permissionId = rs.getInt("permission_id");
            }
        } catch (SQLException e) {
            throw new DataBaseException("SQL Error");
        } finally {
            jdbcUtil.release(rs, stmt, conn);
        }
        return permissionId;
    }

}
