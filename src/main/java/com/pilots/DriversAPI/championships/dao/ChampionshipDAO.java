package com.pilots.DriversAPI.championships.dao;

import com.pilots.DriversAPI.championships.model.Championship;
import com.pilots.DriversAPI.championships.model.DriverResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChampionshipDAO implements IChampionshipDAO {

    private List<Championship> championships;

    public ChampionshipDAO() {
        // static data to load on application start, replacing database call
        Championship c = new Championship("1", "F1", 2022);
        List<DriverResult> results = new ArrayList<>(){
            {
                add(new DriverResult("1", 454, "RED BULL RACING RBPT", 1));
                add(new DriverResult("2", 308, "FERRARI", 16));
                add(new DriverResult("3", 305, "RED BULL RACING RBPT", 11));
                add(new DriverResult("4", 275, "MERCEDES", 63));
                add(new DriverResult("5", 246, "FERRARI", 55));
                add(new DriverResult("6", 240, "MERCEDES", 44));
                add(new DriverResult("7", 122, "MCLAREN MERCEDES", 4));
                add(new DriverResult("8", 92, "ALPINE RENAULT", 31));
                add(new DriverResult("9", 81, "ALPINE RENAULT", 14));
                add(new DriverResult("10", 49, "ALFA ROMEO FERRARI", 77));
                add(new DriverResult("11", 37, "MCLAREN MERCEDES", 4));
                add(new DriverResult("12", 37, "ASTON MARTIN ARAMCO MERCEDES", 5));
                add(new DriverResult("13", 25, "HAAS FERRARI", 20));
                add(new DriverResult("14", 23, "ALPHATAURI RBPT", 10));
                add(new DriverResult("15", 18, "ASTON MARTIN ARAMCO MERCEDES", 18));
                add(new DriverResult("16", 12, "HAAS FERRARI", 47));
                add(new DriverResult("17", 12, "ALPHATAURI RBPT", 22));
                add(new DriverResult("18", 6, "ALFA ROMEO FERRARI", 24));
                add(new DriverResult("19", 4, "WILLIAMS MERCEDES", 23));
                add(new DriverResult("20", 2, "WILLIAMS MERCEDES", 6));
            }
        };
        c.setDriverResults(results);
        championships = new ArrayList();
        championships.add(c);
    }

    @Override
    public List<Championship> findAll() {
        return championships;
    }

    @Override
    public Championship findById(String id) {
        return championships.stream().filter(championship -> championship.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public DriverResult updateDriverScore(String id, String driverId, int score) {
        Championship championship = championships.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
        if (championship != null) {
            DriverResult result = championship.getDriverResults().stream().filter(driverResult -> driverResult.getDriverId().equals(driverId)).findAny().orElse(null);
            if (result != null) {
                result.setScore(score);
                return result;
            }
        }
        return null;
    }

    @Override
    public DriverResult saveDriverScore(String id, String driverId, DriverResult res) {
        Championship championship = championships.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
        if (championship != null) {
            DriverResult result = championship.getDriverResults().stream().filter(driverResult -> driverResult.getDriverId().equals(driverId)).findAny().orElse(null);
            if (result != null) {
                return null;
            }
            championship.getDriverResults().add(res);
            return res;
        }
        return null;
    }

    @Override
    public DriverResult getDriverResult(String id, String driverId) {
        Championship championship = championships.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
        if (championship != null) {
            DriverResult result = championship.getDriverResults().stream().filter(driverResult -> driverResult.getDriverId().equals(driverId)).findAny().orElse(null);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    @Override
    public void deleteDriverScore(String id, String driverId) {
        Championship c = championships.stream().filter(championship -> championship.getId().equals(id)).findAny().orElse(null);
        if (c != null) {
            DriverResult result = c.getDriverResults().stream().filter(driverResult -> driverResult.getDriverId().equals(driverId)).findAny().orElse(null);
            if (result != null) {
                c.getDriverResults().remove(result);
            }
        }
    }

    @Override
    public void save(Championship d) {
        championships.add(d);
    }

    @Override
    public void deleteById(String id) {
        Championship d = championships.stream().filter(championship -> championship.getId().equals(id)).findAny().orElse(null);
        if (d != null) {
            championships.remove(d);
        }
    }
}
