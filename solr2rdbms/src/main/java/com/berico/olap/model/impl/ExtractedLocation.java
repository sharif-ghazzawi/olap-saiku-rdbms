package com.berico.olap.model.impl;

import com.berico.olap.util.Constants;
import com.berico.olap.model.Dimension;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

@Entity
@Table(name = "extractedLocation")
public class ExtractedLocation implements Dimension {

    private Integer id;
    private Integer clavinId;
    private String name;
    private Integer countryClavinId;
    private String countryIso;
    private String countryName;
    private Command command;
    private Integer subnationalClavinId;
    private String subnationalName;
    private Float latitude;
    private Float longitude;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "clavinId")
    public Integer getClavinId() {
        return this.clavinId;
    }

    public void setClavinId(Integer clavinId) {
        this.clavinId = clavinId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "countryClavinId")
    public Integer getCountryClavinId() {
        return countryClavinId;
    }

    public void setCountryClavinId(Integer countryClavinId) {
        this.countryClavinId = countryClavinId;
    }

    @Column(name = "countryIso")
    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    @Column(name = "countryName")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "commandId")
    @ForeignKey(name = Constants.FK_COMMAND_EXTRACTEDLOCATION)
    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Column(name = "subnationalClavinId")
    public Integer getSubnationalClavinId() {
        return this.subnationalClavinId;
    }

    public void setSubnationalClavinId(Integer subnationalClavinId) {
        this.subnationalClavinId = subnationalClavinId;
    }

    @Column(name = "subnationalName")
    public String getSubnationalName() {
        return subnationalName;
    }

    public void setSubnationalName(String subnationalName) {
        this.subnationalName = subnationalName;
    }

    @Column(name = "latitude")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
