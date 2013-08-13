package com.berico.olap.model.impl;

import com.berico.olap.model.Constants;
import com.berico.olap.model.Dimension;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personfact")
public class PersonFact extends FactCube {

    private String personId;

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

    @Column(name = "personId")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
