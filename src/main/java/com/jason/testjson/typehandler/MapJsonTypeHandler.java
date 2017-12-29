package com.jason.testjson.typehandler;

import java.util.HashMap;

/**
 * @author zhengjun
 * @date 2017/12/27 08:40
 * @Description: Map和jsonb映射
 */
public class MapJsonTypeHandler extends JsonTypeHandler {
    public MapJsonTypeHandler() {
        super(HashMap.class);
    }
}
