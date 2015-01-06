package com.augmentum.oes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.augmentum.oes.dao.PermissionDao;
import com.augmentum.oes.exception.DataBaseException;
import com.augmentum.oes.jdbc.JDBCUtil;
import com.augmentum.oes.modle.Permission;

public class PermissionDaoImpl extends BaseDaoImpl<Permission, Integer> implements PermissionDao {

    @Override
    public List<Permission> queryPermissionById(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JDBCUtil jdbcUtil = null;

        Permission permission = null;
        List<Permission> list = null;
        try {
            jdbcUtil = new JDBCUtil();
            conn = jdbcUtil.getMysqlConnection();
            String sql = "SELECT `name`, `code` FROM `online_exam_system`.`permission` WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            list = new ArrayList<Permission>();
            while (rs.next()) {
                permission = new Permission();
                permission.setId(rs.getInt("id"));
                permission.setCode(rs.getString("code"));
                list.add(permission);
            }
        } catch (SQLException e) {
            throw new DataBaseException("SQL Error");
        } finally {
            jdbcUtil.release(rs, stmt, conn);
        }
        return list;
    }

}
