package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class IngestionDate implements Dimension<String> {
	private String id;
	private int ingDateMonth;
	public int getIngDateMonth() {
		return ingDateMonth;
	}

	public void setIngDateMonth(int ingDateMonth) {
		this.ingDateMonth = ingDateMonth;
	}

	public int getIngDateYear() {
		return ingDateYear;
	}

	public void setIngDateYear(int ingDateYear) {
		this.ingDateYear = ingDateYear;
	}

	private int ingDateYear;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id=id;
	}
	

}
