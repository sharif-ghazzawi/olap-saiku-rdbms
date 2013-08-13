package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class OrganizationFact extends FactCube {

    private String organizationId;

    public void addDimension(String name, Dimension d) {
        if (name.equals("organization")) {
            setOrganizationId(((Organization) d).getId());
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
