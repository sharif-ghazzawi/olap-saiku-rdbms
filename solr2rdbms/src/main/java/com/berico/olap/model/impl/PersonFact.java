package com.berico.olap.model.impl;

import com.berico.olap.model.Constants;
import com.berico.olap.model.Cube;
import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "personFact")
public class PersonFact implements Cube {

    private Integer id;
    private Integer personId;
    private Integer documentId;
    private Integer exLocationId;
    private Integer exDateId;
    private Integer pubDateId;
    private Integer ingDateId;
    private Integer colDateId;
    private Integer classificationId;
    private Integer sourceId;
    private Integer docLengthGroupId;
    private Integer docLengthPercentileId;
    private Integer wordStemPercentileId;
    private int wordDocCount;
    private int wordDocCountShare;
    private int position;
    private int position_percentile;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.PERSON)) {
            setPersonId(((Person) d).getId());
        } else if (name.equals(Constants.DOCUMENT)) {
            setDocumentId(((Document) d).getId());
        } else if (name.equals(Constants.EXTRACTED_LOCATION)) {
            setExLocationId(((ExtractedLocation) d).getId());
        } else if (name.equals(Constants.EXTRACTED_DATE)) {
            setExDateId(((ExtractedDate) d).getId());
        } else if (name.equals(Constants.PUBLICATION_DATE)) {
            setPubDateId(((PublicationDate) d).getId());
        } else if (name.equals(Constants.INGESTION_DATE)) {
            setIngDateId(((IngestionDate) d).getId());
        } else if (name.equals(Constants.COLLECTION_DATE)) {
            setColDateId(((CollectionDate) d).getId());
        } else if (name.equals(Constants.CLASSIFICATION)) {
            setClassificationId(((Classification) d).getId());
        } else if (name.equals(Constants.SOURCE)) {
            setSourceId(((Source) d).getId());
        } else if (name.equals(Constants.DOCUMENT)) {
            setDocLengthGroupId(((DocumentLengthGroup) d).getId());
        } else if (name.equals(Constants.DOCUMENT_LENGTH_PERCENTILE)) {
            setDocLengthPercentileId(((DocumentLengthPercentile) d).getId());
        } else if (name.equals(Constants.WORD_STEM_PERCENTILE)) {
            setWordStemPercentileId(((WordStemPercentile) d).getId());
        }
    }

    @Column(name = "id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "documentId")
    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    @Column(name = "exLocationId")
    public Integer getExLocationId() {
        return exLocationId;
    }

    public void setExLocationId(Integer exLocationId) {
        this.exLocationId = exLocationId;
    }

    @Column(name = "exDateId")
    public Integer getExDateId() {
        return exDateId;
    }

    public void setExDateId(Integer exDateId) {
        this.exDateId = exDateId;
    }

    @Column(name = "pubDateId")
    public Integer getPubDateId() {
        return pubDateId;
    }

    public void setPubDateId(Integer pubDateId) {
        this.pubDateId = pubDateId;
    }

    @Column(name = "ingDateId")
    public Integer getIngDateId() {
        return ingDateId;
    }

    public void setIngDateId(Integer ingDateId) {
        this.ingDateId = ingDateId;
    }

    @Column(name = "colDateId")
    public Integer getColDateId() {
        return colDateId;
    }

    public void setColDateId(Integer colDateId) {
        this.colDateId = colDateId;
    }

    @Column(name = "classification")
    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    @Column(name = "source")
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
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
