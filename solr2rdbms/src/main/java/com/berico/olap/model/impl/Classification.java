package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="classification")
public class Classification implements Dimension<String> {
	private String id;
	private String classification;
	
	@Id
	@Column(name="classificationId")
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id=id;
		
	}
	@Column(name="classification")
	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	

}
