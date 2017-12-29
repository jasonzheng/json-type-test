package com.jason.testjson.dao;

import com.jason.testjson.model.Address;
import com.jason.testjson.model.Consignee;
import com.jason.testjson.model.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * 数据库连接池使用测试
 *
 * @author tuzongxun
 * @date 2017年2月15日 上午11:16:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class PassengerDaoTest {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private PassengerMapper passengerDao;

    @Test
    public void findCountTest() {
        int count = passengerDao.findCount();
        System.out.println(count);
    }

    @Test
    public void saveTest() {
        Passenger passenger = new Passenger();
        passenger.setPaxCode("001");
        passenger.setPaxName("张三");
        Map<String, Object> tag = new HashMap <String, Object>(){
            {
                put("01", "01");
                put("02", "TravleSky");
                put("03", 100);
            }
        };
        passenger.setTag1(tag);
        passenger.setTag2(tag);

        Address address = new Address("China", "Beijing", "Beijing", "7 Yunmin Av.,Houshayu, Shunyi Dist.",
                "jason");
        passenger.setTag3(address);
        passenger.setAddress(address);

        Consignee consignee = new Consignee("jason", null, "zheng", "jason zheng");
        passenger.setTag4(consignee);
        passenger.setConsignee(consignee);
        passengerDao.save(passenger);
        System.out.println(passenger);
    }

    @Test
    public void findByIdTest() {
        Passenger passenger = passengerDao.findById(1L);
        printData(passenger);
    }

    @Test
    public void findFirstByCodeTest() {
        Passenger passenger = passengerDao.findFirstByCode("001");
        printData(passenger);
    }

    @Test
    public void findAllTest() {
        List <Passenger> passengers = passengerDao.findAll();
        System.out.println(passengers);
    }

    private void printData(Passenger passenger) {
        if (passenger == null) {
            return;
        }
        System.out.println(passenger);

        System.out.println("Tag1:");
        printMap(passenger.getTag1());

        System.out.println("Tag2:");
        printMap(passenger.getTag2());

        System.out.println("Tag3:");
        System.out.println(passenger.getTag3());

        System.out.println("Tag4:");
        System.out.println(passenger.getTag4());
    }

    private void printMap(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (String in : map.keySet()) {
            Object str = map.get(in);
            System.out.println(in + "     " + str);
        }
    }
}
