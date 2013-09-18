package com.berico.olap.model.impl;

import com.berico.olap.model.Cube;
import com.berico.olap.model.Dimension;
import com.berico.olap.util.Constants;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

@Entity
@Table(name = "document_fact")
public class DocumentFact implements Cube {

    private Integer id;
    private Document document;
    private ExtractedLocation extractedLocation;
    private Date extractedDate;
    private Date publicationDate;
    private Date ingestDate;
    private Date collectionDate;
    private Classification classification;
    private Source source;
    private DocumentLengthGroup documentLengthGroup;
    private Percentile documentLengthPercentile;
    private Integer documentLengthWords;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.DOCUMENT)) {
            setDocument((Document) d);
        } else if (name.equals(Constants.EXTRACTED_LOCATION)) {
            setExtractedLocation((ExtractedLocation) d);
        } else if (name.equals(Constants.EXTRACTED_DATE)) {
            setExtractedDate((Date) d);
        } else if (name.equals(Constants.PUBLICATION_DATE)) {
            setPublicationDate((Date) d);
        } else if (name.equals(Constants.INGESTION_DATE)) {
            setIngestDate((Date) d);
        } else if (name.equals(Constants.COLLECTION_DATE)) {
            setCollectionDate((Date) d);
        } else if (name.equals(Constants.CLASSIFICATION)) {
            setClassification((Classification) d);
        } else if (name.equals(Constants.SOURCE)) {
            setSource((Source) d);
        } else if (name.equals(Constants.DOCUMENT_LENGTH_GROUP)) {
            setDocumentLengthGroup((DocumentLengthGroup) d);
        } else if (name.equals(Constants.DOCUMENT_LENGTH_PERCENTILE)) {
            setDocumentLengthPercentile((Percentile) d);
        }
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_id")
    @ForeignKey(name = Constants.FK_DOCUMENT_WORDFACT)
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extracted_location_id")
    @ForeignKey(name = Constants.FK_EXLOCATION_WORDFACT)
    public ExtractedLocation getExtractedLocation() {
        return extractedLocation;
    }

    public void setExtractedLocation(ExtractedLocation exLocation) {
        this.extractedLocation = exLocation;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extracted_date_id")
    @ForeignKey(name = Constants.FK_EXDATE_WORDFACT)
    public Date getExtractedDate() {
        return extractedDate;
    }

    public void setExtractedDate(Date exDate) {
        this.extractedDate = exDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publication_date_id")
    @ForeignKey(name = Constants.FK_PUBDATE_WORDFACT)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date pubDate) {
        this.publicationDate = pubDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingest_date_id")
    @ForeignKey(name = Constants.FK_INGDATE_WORDFACT)
    public Date getIngestDate() {
        return ingestDate;
    }

    public void setIngestDate(Date ingDate) {
        this.ingestDate = ingDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "collection_date_id")
    @ForeignKey(name = Constants.FK_COLDATE_WORDFACT)
    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date colDate) {
        this.collectionDate = colDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classification_id")
    @ForeignKey(name = Constants.FK_CLASSIFICATION_WORDFACT)
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "source_id")
    @ForeignKey(name = Constants.FK_SOURCE_WORDFACT)
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_length_group_id")
    @ForeignKey(name = Constants.FK_DOCLENGTHGROUP_WORDFACT)
    public DocumentLengthGroup getDocumentLengthGroup() {
        return documentLengthGroup;
    }

    public void setDocumentLengthGroup(DocumentLengthGroup docLengthGroup) {
        this.documentLengthGroup = docLengthGroup;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_length_percentile_id")
    @ForeignKey(name = Constants.FK_DOCLENGTHPERCENTILE_WORDFACT)
    public Percentile getDocumentLengthPercentile() {
        return documentLengthPercentile;
    }

    public void setDocumentLengthPercentile(Percentile docLengthPercentile) {
        this.documentLengthPercentile = docLengthPercentile;
    }

    @Column(name = "document_length_words")
    public Integer getDocumentLengthWords() {
        return documentLengthWords;
    }

    public void setDocumentLengthWords(Integer docLengthWords) {
        this.documentLengthWords = docLengthWords;
    }
}
