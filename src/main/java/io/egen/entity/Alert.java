package io.egen.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
public class Alert {

    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "VARCHAR(6)")
    private String priority;

    @Column(columnDefinition = "VARCHAR(40)")
    private String description;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date timestamp;

    @Column(columnDefinition = "DECIMAL(10,8)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(11,8)")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(timestamp);
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
