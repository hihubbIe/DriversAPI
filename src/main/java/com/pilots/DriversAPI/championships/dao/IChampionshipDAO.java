package com.pilots.DriversAPI.championships.dao;

import com.pilots.DriversAPI.championships.model.Championship;
import com.pilots.DriversAPI.championships.model.DriverResult;

import java.util.List;

public interface IChampionshipDAO {
    List<Championship> findAll();
    Championship findById(String id);
    DriverResult updateDriverScore(String id, String driverId, int score);
    DriverResult saveDriverScore(String id, String driverId, DriverResult res);
    DriverResult getDriverResult(String id, String driverId);
    void deleteDriverScore(String id, String driverId);
    void save(Championship d);
    void deleteById(String id);
}
