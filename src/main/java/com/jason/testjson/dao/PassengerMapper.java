package com.jason.testjson.dao;

import com.jason.testjson.model.Passenger;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PassengerMapper {
    int findCount();

    void save(Passenger passenger);

    Passenger findById(@Param("id") Long id);

    Passenger findFirstByCode(String code);

    List<Passenger> findAll();
}
