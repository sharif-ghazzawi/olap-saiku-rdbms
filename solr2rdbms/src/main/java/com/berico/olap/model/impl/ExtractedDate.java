package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="extracted_date")
public class ExtractedDate implements Dimension<String> {
	private String id;
	private int exDateMonth;
	private int exDateYear;
	
	@Id
	@Column(name="dateId")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="exDateMonth")
	public int getExDateMonth() {
		return exDateMonth;
	}

	public void setExDateMonth(int exDateMonth) {
		this.exDateMonth = exDateMonth;
	}

	@Column(name="exDateYear")
	public int getExDateYear() {
		return exDateYear;
	}

	public void setExDateYear(int exDateYear) {
		this.exDateYear = exDateYear;
	}

}
