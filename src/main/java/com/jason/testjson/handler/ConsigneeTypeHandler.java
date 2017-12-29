package com.jason.testjson.handler;

import com.jason.testjson.model.Consignee;

/**
 * @author zhengjun
 * @date 2017/12/27 14:57
 * @Description:
 */
public class ConsigneeTypeHandler extends JsonTypeHandler {
    public ConsigneeTypeHandler() {
        super(Consignee.class);
    }
}
