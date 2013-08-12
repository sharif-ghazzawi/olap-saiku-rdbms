package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class ExtractedDate implements Dimension<String> {
	private String id;
	private int exDateMonth;
	private int exDateYear;
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getExDateMonth() {
		return exDateMonth;
	}

	public void setExDateMonth(int exDateMonth) {
		this.exDateMonth = exDateMonth;
	}

	public int getExDateYear() {
		return exDateYear;
	}

	public void setExDateYear(int exDateYear) {
		this.exDateYear = exDateYear;
	}

}
