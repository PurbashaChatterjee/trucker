package io.egen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {

    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "VARCHAR(16)")
    private String make;

    @Column(columnDefinition = "VARCHAR(16)")
    private String model;

    @Column(columnDefinition = "VARCHAR(4)")
    private int year;

    @Column(columnDefinition = "INTEGER(4)")
    private int redlineRpm;

    @Column(columnDefinition = "VARCHAR(3)")
    private int maxFuelVolume;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redLineRpm) {
        this.redlineRpm = redLineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastService) {
        this.lastServiceDate = lastService;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redLineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastService=" + lastServiceDate +
                '}';
    }
}
