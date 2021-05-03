package com.wcig.app.handler;

import com.wcig.app.model.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = SexEnum.class)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        String val = parameter.getVal();
        ps.setString(i, val);
    }

    @Override
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        String val = rs.getString(columnName);
        return SexEnum.ofSex(val);
    }

    @Override
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        String val = rs.getString(columnIndex);
        return SexEnum.ofSex(val);
    }

    @Override
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String val = cs.getString(columnIndex);
        return SexEnum.ofSex(val);
    }
}
