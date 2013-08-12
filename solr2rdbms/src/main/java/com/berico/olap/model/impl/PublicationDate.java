package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class PublicationDate implements Dimension<String> {
	private String id;
	private int pubDateMonth;
	private int pubDateYear;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id=id;
		
	}

	public int getPubDateMonth() {
		return pubDateMonth;
	}

	public void setPubDateMonth(int pubDateMonth) {
		this.pubDateMonth = pubDateMonth;
	}

	public int getPubDateYear() {
		return pubDateYear;
	}

	public void setPubDateYear(int pubDateYear) {
		this.pubDateYear = pubDateYear;
	}
	

}
