package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class DocumentLengthPercentile implements Dimension<Integer> {
	private Integer id;
	private int upperBound;
	private int lowerBound;
	private String coarseId;
	private int coarseUpperBound;
	private int coarseLowerBound;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
		
	}
	public int getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	public int getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	public String getCoarseId() {
		return coarseId;
	}
	public void setCoarseId(String coarseId) {
		this.coarseId = coarseId;
	}
	public int getCoarseUpperBound() {
		return coarseUpperBound;
	}
	public void setCoarseUpperBound(int coarseUpperBound) {
		this.coarseUpperBound = coarseUpperBound;
	}
	public int getCoarseLowerBound() {
		return coarseLowerBound;
	}
	public void setCoarseLowerBound(int coarseLowerBound) {
		this.coarseLowerBound = coarseLowerBound;
	}
	
}
