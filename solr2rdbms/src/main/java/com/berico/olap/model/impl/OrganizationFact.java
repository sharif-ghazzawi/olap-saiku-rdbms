package com.berico.olap.model.impl;

import com.berico.olap.model.Constants;
import com.berico.olap.model.Dimension;

public class OrganizationFact extends FactCube {

    private String organizationId;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.ORGANIZATION)) {
            setOrganizationId(((Organization) d).getId());
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
        } else if (name.equals(Constants.DOCUMENT_LENGTH_GROUP)) {
            setDocLengthGroupId(((DocumentLengthGroup) d).getId());
        } else if (name.equals(Constants.DOCUMENT_LENGTH_PERCENTILE)) {
            setDocLengthPercentileId(((DocumentLengthPercentile) d).getId());
        } else if (name.equals(Constants.WORD_STEM_PERCENTILE)) {
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
