/**
 * 
 */
package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="person")
public class Person implements Dimension<String> {
	private String id;
	private String person;
	private String fine;
	private String medium;
	private String coarse;
	
	@Id
	@Column(name="personId")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		
	}

	@Column(name="person")
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
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
