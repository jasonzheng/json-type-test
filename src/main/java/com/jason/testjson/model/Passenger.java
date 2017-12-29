package com.jason.testjson.model;

import com.jason.testjson.utils.JsonUtils;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author zhengjun
 * @date 2017/12/26 21:35
 * @Description:
 */
@Data
public class Passenger {
    private Long id;
    private String paxCode;
    private String paxName;

    /**
    **测试Map类型存储为json，数据库类型为VARCHAR
    **/
    private Map<String, Object> tag1;

    /**
     **测试Map类型存储为json，数据库类型为jsonb
     **/
    private Map<String, Object> tag2;

    /**
     **测试对象存储为json，数据库类型为VARCHAR，使用map转换
     **/
    private Address tag3;

    /**
     **测试对象存储为json，数据库类型为jsonb，使用map转换
     **/
    private Consignee tag4;

    /**
     **测试List对象存储为json，数据库类型为VARCHAR
     **/
    private List<Address> tag5;

    /**
     **测试List对象存储为json，数据库类型为jsonb
     **/
    private List<Address> tag6;

    /**
     **测试对象存储为json，数据库类型为VARCHAR
     **/
    private Address address;

    /**
     **测试对象存储为json，数据库类型为jsonb
     **/
    private Consignee consignee;

    private Timestamp createTime;
    private Timestamp updateTime;

    public void setTag3(Object tag3) {
        if (tag3 instanceof Map) {
            this.tag3 = JsonUtils.OBJECT_MAPPER.convertValue(tag3, Address.class);
        } else {
            this.tag3 = (Address) tag3;
        }
    }

    public void setTag4(Object tag4) {
        if (tag4 instanceof Map) {
            this.tag4 = JsonUtils.OBJECT_MAPPER.convertValue(tag4, Consignee.class);
        } else {
            this.tag4 = (Consignee) tag4;
        }
    }
}
