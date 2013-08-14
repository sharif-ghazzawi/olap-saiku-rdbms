package com.berico.olap.model.impl;

import com.berico.olap.model.Cube;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public abstract class FactCube implements Cube {

    private String id;
    private String documentId;
    private String exLocationId;
    private String exDateId;
    private String pubDateId;
    private String ingDateId;
    private String colDateId;
    private String classificationId;
    private String sourceId;
    private Integer docLengthGroupId;
    private Integer docLengthPercentileId;
    private Integer wordStemPercentileId;
    private int wordDocCount;
    private int wordDocCountShare;
    private int position;
    private int position_percentile;

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "factId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "documentId")
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @Column(name = "exLocationId")
    public String getExLocationId() {
        return exLocationId;
    }

    public void setExLocationId(String exLocationId) {
        this.exLocationId = exLocationId;
    }

    @Column(name = "exDateId")
    public String getExDateId() {
        return exDateId;
    }

    public void setExDateId(String exDateId) {
        this.exDateId = exDateId;
    }

    @Column(name = "pubDateId")
    public String getPubDateId() {
        return pubDateId;
    }

    public void setPubDateId(String pubDateId) {
        this.pubDateId = pubDateId;
    }

    @Column(name = "ingDateId")
    public String getIngDateId() {
        return ingDateId;
    }

    public void setIngDateId(String ingDateId) {
        this.ingDateId = ingDateId;
    }

    @Column(name = "colDateId")
    public String getColDateId() {
        return colDateId;
    }

    public void setColDateId(String colDateId) {
        this.colDateId = colDateId;
    }

    @Column(name = "classification")
    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId;
    }

    @Column(name = "source")
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "docLengthGroup")
    public Integer getDocLengthGroupId() {
        return docLengthGroupId;
    }

    public void setDocLengthGroupId(Integer docLengthGroupId) {
        this.docLengthGroupId = docLengthGroupId;
    }

    @Column(name = "docLengthPercentile")
    public Integer getDocLengthPercentileId() {
        return docLengthPercentileId;
    }

    public void setDocLengthPercentileId(Integer docLengthPercentileId) {
        this.docLengthPercentileId = docLengthPercentileId;
    }

    @Column(name = "wordStemPercentile")
    public Integer getWordStemPercentileId() {
        return wordStemPercentileId;
    }

    public void setWordStemPercentileId(Integer wordStemPercentileId) {
        this.wordStemPercentileId = wordStemPercentileId;
    }

    @Column(name = "wordDocCount")
    public int getWordDocCount() {
        return wordDocCount;
    }

    public void setWordDocCount(int wordDocCount) {
        this.wordDocCount = wordDocCount;
    }

    @Column(name = "wordDocCountShare")
    public int getWordDocCountShare() {
        return wordDocCountShare;
    }

    public void setWordDocCountShare(int wordDocCountShare) {
        this.wordDocCountShare = wordDocCountShare;
    }

    @Column(name = "position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Column(name = "position_percentile")
    public int getPosition_percentile() {
        return position_percentile;
    }

    public void setPosition_percentile(int position_percentile) {
        this.position_percentile = position_percentile;
    }
}
