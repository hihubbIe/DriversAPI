package com.pilots.DriversAPI.drivers.dao;

import com.pilots.DriversAPI.drivers.model.Driver;

import java.util.List;

public interface IDriverDAO {
    List<Driver> findAll();
    Driver findById(String id);
    Driver save(Driver d);
    void deleteById(String id);
}
