package com.berico.olap.model.impl;

import com.berico.olap.util.Constants;
import com.berico.olap.model.Cube;
import com.berico.olap.model.Dimension;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

@Entity
@Table(name = "personFact")
public class PersonFact implements Cube {

    private Integer id;
    private Person person;
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
    private Percentile personPercentile;
    private Integer documentLengthWords;
    private Integer personFrequency;
    private Float personFrequencyShare;
    private Integer position;
    private Integer positionPercentile;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.PERSON)) {
            setPerson((Person) d);
        } else if (name.equals(Constants.DOCUMENT)) {
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
        } else if (name.equals(Constants.PERSON_PERCENTILE)) {
            setPersonPercentile((Percentile) d);
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
    @JoinColumn(name = "personId")
    @ForeignKey(name = Constants.FK_PERSON_PERSONFACT)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentId")
    @ForeignKey(name = Constants.FK_DOCUMENT_PERSONFACT)
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedLocationId")
    @ForeignKey(name = Constants.FK_EXLOCATION_PERSONFACT)
    public ExtractedLocation getExtractedLocation() {
        return extractedLocation;
    }

    public void setExtractedLocation(ExtractedLocation exLocation) {
        this.extractedLocation = exLocation;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedDateId")
    @ForeignKey(name = Constants.FK_EXDATE_PERSONFACT)
    public Date getExtractedDate() {
        return extractedDate;
    }

    public void setExtractedDate(Date exDate) {
        this.extractedDate = exDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publicationDateId")
    @ForeignKey(name = Constants.FK_PUBDATE_PERSONFACT)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date pubDate) {
        this.publicationDate = pubDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingestDateId")
    @ForeignKey(name = Constants.FK_INGDATE_PERSONFACT)
    public Date getIngestDate() {
        return ingestDate;
    }

    public void setIngestDate(Date ingestDate) {
        this.ingestDate = ingestDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "collectionDateId")
    @ForeignKey(name = Constants.FK_COLDATE_PERSONFACT)
    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date colDate) {
        this.collectionDate = colDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classificationId")
    @ForeignKey(name = Constants.FK_CLASSIFICATION_PERSONFACT)
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sourceId")
    @ForeignKey(name = Constants.FK_SOURCE_PERSONFACT)
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthGroupId")
    @ForeignKey(name = Constants.FK_DOCLENGTHGROUP_PERSONFACT)
    public DocumentLengthGroup getDocumentLengthGroup() {
        return documentLengthGroup;
    }

    public void setDocumentLengthGroup(DocumentLengthGroup docLengthGroup) {
        this.documentLengthGroup = docLengthGroup;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthPercentileId")
    @ForeignKey(name = Constants.FK_DOCLENGTHPERCENTILE_PERSONFACT)
    public Percentile getDocumentLengthPercentile() {
        return documentLengthPercentile;
    }

    public void setDocumentLengthPercentile(Percentile docLengthPercentile) {
        this.documentLengthPercentile = docLengthPercentile;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personPercentileId")
    @ForeignKey(name = Constants.FK_PERSONPERCENTILE_PERSONFACT)
    public Percentile getPersonPercentile() {
        return personPercentile;
    }

    public void setPersonPercentile(Percentile personPercentile) {
        this.personPercentile = personPercentile;
    }

    @Column(name = "documentLengthWords")
    public Integer getDocumentLengthWords() {
        return documentLengthWords;
    }

    public void setDocumentLengthWords(Integer docLengthWords) {
        this.documentLengthWords = docLengthWords;
    }

    @Column(name = "personFrequency")
    public Integer getPersonFrequency() {
        return personFrequency;
    }

    public void setPersonFrequency(Integer wordDocCount) {
        this.personFrequency = wordDocCount;
    }

    @Column(name = "personFrequencyShare")
    public Float getPersonFrequencyShare() {
        return personFrequencyShare;
    }

    public void setPersonFrequencyShare(Float wordDocCountShare) {
        this.personFrequencyShare = wordDocCountShare;
    }

    @Column(name = "position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Column(name = "positionPercentile")
    public Integer getPositionPercentile() {
        return positionPercentile;
    }

    public void setPositionPercentile(Integer positionPercentile) {
        this.positionPercentile = positionPercentile;
    }
}
