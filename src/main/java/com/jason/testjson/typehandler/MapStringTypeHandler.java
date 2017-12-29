package com.jason.testjson.typehandler;

import java.util.HashMap;

/**
 * @author zhengjun
 * @date 2017/12/27 08:40
 * @Description: Map和json字符串映射
 */
public class MapStringTypeHandler extends JsonStringTypeHandler {
    public MapStringTypeHandler() {
        super(HashMap.class);
    }
}
