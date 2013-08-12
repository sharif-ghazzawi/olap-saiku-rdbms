package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="organization")
public class Organization implements Dimension<String> {
	private String id;
	private String organization;
	private String fine;
	private String medium;
	private String coarse;
	
	@Id
	@Column(name="organizationId")
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id=id;
		
	}
	
	@Column(name="organization")
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	@Column(name="fine")
	public String getFine() {
		return fine;
	}
	
	public void setFine(String fine) {
		this.fine = fine;
	}
	
	@Column(name="medium")
	public String getMedium() {
		return medium;
	}
	
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	@Column(name="coarse")
	public String getCoarse() {
		return coarse;
	}
	
	public void setCoarse(String coarse) {
		this.coarse = coarse;
	}
	
}
