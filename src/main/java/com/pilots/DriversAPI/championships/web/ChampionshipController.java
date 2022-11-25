package com.pilots.DriversAPI.championships.web;

import com.pilots.DriversAPI.Logger;
import com.pilots.DriversAPI.championships.dao.IChampionshipDAO;
import com.pilots.DriversAPI.championships.model.Championship;
import com.pilots.DriversAPI.championships.model.DriverResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/championships")
public class ChampionshipController {

    @Autowired
    private IChampionshipDAO dao;

    @GetMapping()
    public ResponseEntity<List<Championship>> findAll() {
        Logger.logGET("/championships");
        List<Championship> result = dao.findAll();

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Championship> findOne(@PathVariable String id) {
        Logger.logGET("/championships/" + id);
        Championship result = dao.findById(id);

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(value="/{id}/{driverId}")
    public ResponseEntity<DriverResult> findOneDriverResult(@PathVariable String id, @PathVariable String driverId) {
        Logger.logGET("/championships/" + id + "/" + driverId);
        DriverResult result = dao.getDriverResult(id, driverId);

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping(value="/{id}/{driverId}")
    public DriverResult saveDriverScore(@PathVariable String id, @PathVariable String driverId, @RequestBody DriverResult res) {
        Logger.logPOST("/championships/" + id + "/" + driverId, res.toString());
        return dao.saveDriverScore(id, driverId, res);
    }

    @DeleteMapping(value="/{id}/{driverId}")
    public void deleteDriverScore(@PathVariable String id, @PathVariable String driverId) {
        Logger.logDELETE("/championships/" + id + "/" + driverId);
        dao.deleteDriverScore(id, driverId);
    }

    @PutMapping(value="/{id}/{driverId}")
    public ResponseEntity<DriverResult> updateOneDriverScore(@PathVariable String id, @PathVariable String driverId, @RequestBody int score) {
        Logger.logPUT("/championships/" + id + "/" + driverId, "" + score);
        dao.updateDriverScore(id, driverId, score);

        DriverResult updated = dao.updateDriverScore(id, driverId, score);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    @PostMapping()
    public void save(@RequestBody Championship d) {
        Logger.logPOST("/championships", d.toString());
        dao.save(d);
    }

    @DeleteMapping(value="/{id}")
    public void deleteOne(@PathVariable String id) {
        Logger.logDELETE("/championships/" + id);
        dao.deleteById(id);
    }
}
