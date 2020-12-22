package com.jason.lee.typehandler;

import com.jason.lee.entity.UserStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author huanli9
 * @description
 * @date 2020/12/22 14:04
 */
public class MyTypeHandler implements TypeHandler<UserStatus> {

    // 定义当前数据如何保存
    @Override
    public void setParameter(PreparedStatement ps, int i, UserStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getCode().toString());
    }

    @Override
    public UserStatus getResult(ResultSet rs, String columnName) throws SQLException {
        // 根据状态码返回枚举对象
        int code = rs.getInt(columnName);
        return UserStatus.getUserStatus(code);
    }

    @Override
    public UserStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return UserStatus.getUserStatus(code);
    }

    @Override
    public UserStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return UserStatus.getUserStatus(code);
    }
}
