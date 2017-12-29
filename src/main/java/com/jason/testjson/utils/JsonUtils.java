package com.jason.testjson.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.List;

/**
 * @author zhengjun
 * @date 2017/12/27 09:09
 * @Description:
 */
public class JsonUtils {
    public static final ObjectMapper OBJECT_MAPPER = createObjectMapper();

    /**
     * 初始化ObjectMapper
     *
     * @return
     */
    private static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper;
    }

    public static <T> List<T> json2List(String json, Class <T> clazz) throws IOException {
        JavaType type = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz);

        List <T> list = OBJECT_MAPPER.readValue(json, type);
        return list;
    }
}
