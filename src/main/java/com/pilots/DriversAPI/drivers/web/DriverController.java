package com.pilots.DriversAPI.drivers.web;

import com.pilots.DriversAPI.Logger;
import com.pilots.DriversAPI.drivers.dao.IDriverDAO;
import com.pilots.DriversAPI.drivers.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private IDriverDAO dao;

    @GetMapping()
    public ResponseEntity<List<Driver>> findAll() {
        Logger.logGET("/drivers");
        List<Driver> result = dao.findAll();

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Driver> findOne(@PathVariable String id) {
        Logger.logGET("/drivers/" + id);
        Driver result = dao.findById(id);

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping()
    public Driver save(@RequestBody Driver d) {
        Logger.logPOST("/drivers", d.toString());
        return dao.save(d);
    }

    @DeleteMapping(value="/{id}")
    public void deleteOne(@PathVariable String id) {
        Logger.logDELETE("/drivers/" + id);
        dao.deleteById(id);
    }
}
