package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class Source implements Dimension<String> {
	private String id;
	private String source;
	private String sourceType;
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	
	

}
