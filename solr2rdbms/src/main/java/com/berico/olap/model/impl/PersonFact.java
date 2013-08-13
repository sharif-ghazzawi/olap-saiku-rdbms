package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personfact")
public class PersonFact extends FactCube {

    private String personId;

    public void addDimension(String name, Dimension d) {
        if (name.equals("person")) {
            setPersonId(((Person) d).getId());
        } else if (name.equals("document")) {
            setDocumentId(((Document) d).getId());
        } else if (name.equals("exLocation")) {
            setExLocationId(((ExtractedLocation) d).getId());
        } else if (name.equals("exDate")) {
            setExDateId(((ExtractedDate) d).getId());
        } else if (name.equals("pubDate")) {
            setPubDateId(((PublicationDate) d).getId());
        } else if (name.equals("ingDate")) {
            setIngDateId(((IngestionDate) d).getId());
        } else if (name.equals("colDate")) {
            setColDateId(((CollectionDate) d).getId());
        } else if (name.equals("classification")) {
            setClassificationId(((Classification) d).getId());
        } else if (name.equals("source")) {
            setSourceId(((Source) d).getId());
        } else if (name.equals("docLengthGroup")) {
            setDocLengthGroupId(((DocumentLengthGroup) d).getId());
        } else if (name.equals("docLengthPercentile")) {
            setDocLengthPercentileId(((DocumentLengthPercentile) d).getId());
        } else if (name.equals("wordStemPercentile")) {
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
