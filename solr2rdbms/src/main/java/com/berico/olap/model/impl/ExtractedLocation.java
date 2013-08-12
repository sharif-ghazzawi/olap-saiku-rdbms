package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class ExtractedLocation implements Dimension<String> {
	private String id;
	private String locationName;
	private String countryId;
	private String countryName;
	private String commandid;
	private String commmandName;
	private float lattitude;
	private float longitude;
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id=id;
		
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCommandid() {
		return commandid;
	}

	public void setCommandid(String commandid) {
		this.commandid = commandid;
	}

	public String getCommmandName() {
		return commmandName;
	}

	public void setCommmandName(String commmandName) {
		this.commmandName = commmandName;
	}

	public float getLattitude() {
		return lattitude;
	}

	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
