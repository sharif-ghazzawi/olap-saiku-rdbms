package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="document_legth_group")
public class DocumentLengthGroup implements Dimension<Integer> {
	private Integer id;
	private int upperBound;
	private int lowerBound;
	private String coarseId;
	private int coarseUpperBound;
	private int coarseLowerBound;
	
	@Id
	@Column(name="groupId")
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id=id;
		
	}
	
	@Column(name="docLengthUpper")
	public int getUpperBound() {
		return upperBound;
	}
	
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	@Column(name="docLengthLower")
	public int getLowerBound() {
		return lowerBound;
	}
	
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	@Column(name="docLengthGroupCoarsId")
	public String getCoarseId() {
		return coarseId;
	}
	
	public void setCoarseId(String coarseId) {
		this.coarseId = coarseId;
	}
	
	@Column(name="docLengthCoarseUpper")
	public int getCoarseUpperBound() {
		return coarseUpperBound;
	}
	
	public void setCoarseUpperBound(int coarseUpperBound) {
		this.coarseUpperBound = coarseUpperBound;
	}
	
	@Column(name="docLengthCoarseLower")
	public int getCoarseLowerBound() {
		return coarseLowerBound;
	}
	
	public void setCoarseLowerBound(int coarseLowerBound) {
		this.coarseLowerBound = coarseLowerBound;
	}

}
