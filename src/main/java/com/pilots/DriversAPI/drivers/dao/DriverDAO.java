package com.pilots.DriversAPI.drivers.dao;

import com.fasterxml.jackson.core.JsonFactory;
import com.pilots.DriversAPI.drivers.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverDAO implements IDriverDAO {

    private List<Driver> drivers;

    public DriverDAO() {
        // static data to load on application start, replacing database call
        Driver[] ds = new Driver[]{
                new Driver("1","Verstappen", "Max", "30/09/1997", "NED"),
                new Driver("2","Leclerc", "Charles", "16/10/1997", "MON"),
                new Driver("3","Perez", "Sergio", "26/01/1990", "MEX"),
                new Driver("4","Russel", "George", "15/02/1998", "GBR"),
                new Driver("5","Sainz", "Carlos", "01/09/1994", "ESP"),
                new Driver("6","Hamilton", "Lewis", "07/01/1985", "GBR"),
                new Driver("7","Norris", "Lando", "13/11/1999", "GBR"),
                new Driver("8","Ocon", "Esteban", "17/09/1996", "FRA"),
                new Driver("9","Alonso", "Fernando", "29/07/1981", "ESP"),
                new Driver("10","Bottas", "Valterri", "28/08/1989", "FIN"),
                new Driver("11","Ricciardo", "Daniel", "01/07/1989", "AUS"),
                new Driver("12","Vettel", "Sebastian", "03/07/1987", "GER"),
                new Driver("13","Magnussen", "Kevin", "05/10/1992", "DEN"),
                new Driver("14","Gasly", "Pierre", "07/02/1996", "FRA"),
                new Driver("15","Stroll", "Lance", "29/10/1998", "CAN"),
                new Driver("16","Schumacher", "Mick", "22/03/1999", "GER"),
                new Driver("17","Tsunoda", "Yuki", "11/05/2000", "JPN"),
                new Driver("18","Zhou", "Guanyu", "30/05/1999", "CHN"),
                new Driver("19","Albon", "Alex", "23/03/1996", "THA"),
                new Driver("20","Latifi", "Nicholas", "29/06/1995", "CAN")
        };
        drivers = new ArrayList();
        for (Driver d : ds) {
            drivers.add(d);
        }
    }

    @Override
    public List<Driver> findAll() {
        return drivers;
    }

    @Override
    public Driver findById(String id) {
        return drivers.stream().filter(driver -> driver.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Driver save(Driver d) {
        drivers.add(d);
        return d;
    }

    @Override
    public void deleteById(String id) {
        Driver d = drivers.stream().filter(driver -> driver.getId().equals(id)).findAny().orElse(null);
        if (d != null) {
            drivers.remove(d);
        }
    }
}
