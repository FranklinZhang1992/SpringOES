package com.augmentum.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.augmentum.oes.dao.UserRoleDao;
import com.augmentum.oes.exception.DataBaseException;
import com.augmentum.oes.jdbc.JDBCUtil;

public class UserRoleDaoImpl implements UserRoleDao {

    @Override
    public int getRoleById(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JDBCUtil jdbcUtil = null;

        int roleId = 0;
        try {
            jdbcUtil = new JDBCUtil();
            conn = jdbcUtil.getMysqlConnection();
            String sql = "SELECT `role_id` FROM `online_exam_system`.`user_role` WHERE user_id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                roleId = rs.getInt("role_id");
            }
        } catch (SQLException e) {
            throw new DataBaseException("SQL Error");
        } finally {
            jdbcUtil.release(rs, stmt, conn);
        }
        return roleId;
    }

}
