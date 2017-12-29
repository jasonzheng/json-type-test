package com.jason.testjson.typehandler;

import com.jason.testjson.model.Address;

/**
 * @author zhengjun
 * @date 2017/12/27 15:02
 * @Description:
 */
public class ListAddressTypeHandler extends ListJsonTypeHandler {
    public ListAddressTypeHandler() {
        super(Address.class);
    }
}
