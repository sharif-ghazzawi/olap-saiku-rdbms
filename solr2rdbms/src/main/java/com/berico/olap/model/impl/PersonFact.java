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
    private ExtractedLocation exLocation;
    private ExtractedDate exDate;
    private PublicationDate pubDate;
    private IngestionDate ingDate;
    private CollectionDate colDate;
    private Classification classification;
    private Source source;
    private DocumentLengthGroup docLengthGroup;
    private DocumentLengthPercentile docLengthPercentile;
    private PersonPercentile personPercentile;
    private int docLengthWords;
    private int personFrequency;
    private int personFrequencyShare;
    private int position;
    private int positionPercentile;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.PERSON)) {
            setPerson((Person) d);
        } else if (name.equals(Constants.DOCUMENT)) {
            setDocument((Document) d);
        } else if (name.equals(Constants.EXTRACTED_LOCATION)) {
            setExLocation((ExtractedLocation) d);
        } else if (name.equals(Constants.EXTRACTED_DATE)) {
            setExDate((ExtractedDate) d);
        } else if (name.equals(Constants.PUBLICATION_DATE)) {
            setPubDate((PublicationDate) d);
        } else if (name.equals(Constants.INGESTION_DATE)) {
            setIngDate((IngestionDate) d);
        } else if (name.equals(Constants.COLLECTION_DATE)) {
            setColDate((CollectionDate) d);
        } else if (name.equals(Constants.CLASSIFICATION)) {
            setClassification((Classification) d);
        } else if (name.equals(Constants.SOURCE)) {
            setSource((Source) d);
        } else if (name.equals(Constants.DOCUMENT_LENGTH_GROUP)) {
            setDocLengthGroup((DocumentLengthGroup) d);
        } else if (name.equals(Constants.DOCUMENT_LENGTH_PERCENTILE)) {
            setDocLengthPercentile((DocumentLengthPercentile) d);
        } else if (name.equals(Constants.PERSON_PERCENTILE)) {
            setPersonPercentile((PersonPercentile) d);
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
    public ExtractedLocation getExLocation() {
        return exLocation;
    }

    public void setExLocation(ExtractedLocation exLocation) {
        this.exLocation = exLocation;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedDateId")
    @ForeignKey(name = Constants.FK_EXDATE_PERSONFACT)
    public ExtractedDate getExDate() {
        return exDate;
    }

    public void setExDate(ExtractedDate exDate) {
        this.exDate = exDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publicationDateId")
    @ForeignKey(name = Constants.FK_PUBDATE_PERSONFACT)
    public PublicationDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(PublicationDate pubDate) {
        this.pubDate = pubDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingestDateId")
    @ForeignKey(name = Constants.FK_INGDATE_PERSONFACT)
    public IngestionDate getIngDate() {
        return ingDate;
    }

    public void setIngDate(IngestionDate ingDate) {
        this.ingDate = ingDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "collectionDateId")
    @ForeignKey(name = Constants.FK_COLDATE_PERSONFACT)
    public CollectionDate getColDate() {
        return colDate;
    }

    public void setColDate(CollectionDate colDate) {
        this.colDate = colDate;
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
    public DocumentLengthGroup getDocLengthGroup() {
        return docLengthGroup;
    }

    public void setDocLengthGroup(DocumentLengthGroup docLengthGroup) {
        this.docLengthGroup = docLengthGroup;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthPercentileId")
    @ForeignKey(name = Constants.FK_DOCLENGTHPERCENTILE_PERSONFACT)
    public DocumentLengthPercentile getDocLengthPercentile() {
        return docLengthPercentile;
    }

    public void setDocLengthPercentile(DocumentLengthPercentile docLengthPercentile) {
        this.docLengthPercentile = docLengthPercentile;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personPercentileId")
    @ForeignKey(name = Constants.FK_PERSONPERCENTILE_PERSONFACT)
    public PersonPercentile getPersonPercentile() {
        return personPercentile;
    }

    public void setPersonPercentile(PersonPercentile personPercentile) {
        this.personPercentile = personPercentile;
    }

    @Column(name = "documentLengthWords")
    public int getDocLengthWords() {
        return docLengthWords;
    }

    public void setDocLengthWords(int docLengthWords) {
        this.docLengthWords = docLengthWords;
    }

    @Column(name = "personFrequency")
    public int getPersonFrequency() {
        return personFrequency;
    }

    public void setPersonFrequency(int wordDocCount) {
        this.personFrequency = wordDocCount;
    }

    @Column(name = "personFrequencyShare")
    public int getPersonFrequencyShare() {
        return personFrequencyShare;
    }

    public void setPersonFrequencyShare(int wordDocCountShare) {
        this.personFrequencyShare = wordDocCountShare;
    }

    @Column(name = "position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Column(name = "positionPercentile")
    public int getPositionPercentile() {
        return positionPercentile;
    }

    public void setPositionPercentile(int positionPercentile) {
        this.positionPercentile = positionPercentile;
    }
}
