package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="source")
public class Source implements Dimension<String> {
	private String id;
	private String source;
	private String sourceType;
	
	@Id
	@Column(name="sourceId")
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id=id;
	}
	
	@Column(name="source")
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name="sourceType")
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	
	

}
