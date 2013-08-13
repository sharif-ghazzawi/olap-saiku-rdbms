package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "extracted_location")
public class ExtractedLocation implements Dimension<String> {
    private String id;
    private String locationName;
    private String countryId;
    private String countryName;
    private String commandid;
    private String commmandName;
    private float lattitude;
    private float longitude;

    @Id
    @Column(name = "locationId")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;

    }

    @Column(name = "locationName")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Column(name = "countryId")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Column(name = "countryName")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "commandId")
    public String getCommandid() {
        return commandid;
    }

    public void setCommandid(String commandid) {
        this.commandid = commandid;
    }

    @Column(name = "commandName")
    public String getCommmandName() {
        return commmandName;
    }

    public void setCommmandName(String commmandName) {
        this.commmandName = commmandName;
    }

    @Column(name = "latitude")
    public float getLattitude() {
        return lattitude;
    }

    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }

    @Column(name = "longitude")
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

}
