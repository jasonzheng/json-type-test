package com.jason.testjson.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.jason.testjson.utils.JsonUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhengjun
 * @date 2017/12/27 08:40
 * @Description: jsonb映射
 */
public abstract class JsonTypeHandler<T extends Object> extends BaseTypeHandler<T> {
    protected static final ObjectMapper objectMapper = JsonUtils.OBJECT_MAPPER;
    private Class<T> clazz;

    protected JsonTypeHandler(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.clazz = clazz;
    }

    protected T parse(String json) {

        if (json == null || json.length() == 0) {
            return null;
        }

        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("FATAL ERROR read json");
        }
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(parameter);
        } catch (JsonProcessingException e) {
            throw new SQLException("invalid json string");
        }
        PGobject pGobject = new PGobject();
        pGobject.setType("jsonb");
        pGobject.setValue(jsonString);
        ps.setObject(i, pGobject);
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parse(rs.getString(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return  parse(rs.getString(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return  parse(cs.getString(columnIndex));
    }
}
