package com.example.demo.config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public abstract class CustomTypeHandler extends BaseTypeHandler {

    @Override
    public Object getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return UUID.fromString(rs.getString(columnName));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return UUID.fromString((cs.getString(columnIndex)));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, ((UUID) parameter).toString());
    }
}
