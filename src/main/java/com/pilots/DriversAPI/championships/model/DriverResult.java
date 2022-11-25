package com.pilots.DriversAPI.championships.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DriverResult {

    public String getDriverId() {
        return driverId;
    }

    public int getScore() {
        return score;
    }

    final String driverId;

    public void setScore(int score) {
        this.score = score;
    }

    int score;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    String team;
    int number;

    @Autowired
    public DriverResult(String driverId, int score, String team, int number) {
        this.driverId = driverId;
        this.score = score;
        this.team = team;
        this.number = number;
    }

    @Override
    public String toString() {
        return "DriverResult{" +
                "driverId='" + driverId + '\'' +
                ", score=" + score +
                ", team='" + team + '\'' +
                ", number=" + number +
                '}';
    }
}
