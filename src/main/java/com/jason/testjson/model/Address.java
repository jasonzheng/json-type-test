package com.jason.testjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengjun
 * @date 2017/12/26 21:42
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String country;
    private String province;
    private String city;
    private String streetAddress;
    private String fullName;
}
