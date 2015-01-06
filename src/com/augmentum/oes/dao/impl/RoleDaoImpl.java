package com.augmentum.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.augmentum.oes.dao.RoleDao;
import com.augmentum.oes.exception.DataBaseException;
import com.augmentum.oes.jdbc.JDBCUtil;
import com.augmentum.oes.modle.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao {

    @Override
    public String getRoleById(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JDBCUtil jdbcUtil = null;

        String roleString = new String();
        try {
            jdbcUtil = new JDBCUtil();
            conn = jdbcUtil.getMysqlConnection();
            String sql = "SELECT `name`, `code` FROM `online_exam_system`.`role` WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                roleString = rs.getString("code");
            }
        } catch (SQLException e) {
            throw new DataBaseException("SQL Error");
        } finally {
            jdbcUtil.release(rs, stmt, conn);
        }
        return roleString;
    }

}
