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
    private WordStemPercentile wordStemPercentile;
    private int wordDocCount;
    private int wordDocCountShare;
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
        } else if (name.equals(Constants.WORD_STEM_PERCENTILE)) {
            setWordStemPercentile((WordStemPercentile) d);
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
    @JoinColumn(name = "person")
    @ForeignKey(name = Constants.FK_PERSON_PERSONFACT)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document")
    @ForeignKey(name = Constants.FK_DOCUMENT_PERSONFACT)
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedLocation")
    @ForeignKey(name = Constants.FK_EXLOCATION_PERSONFACT)
    public ExtractedLocation getExLocation() {
        return exLocation;
    }

    public void setExLocation(ExtractedLocation exLocation) {
        this.exLocation = exLocation;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedDate")
    @ForeignKey(name = Constants.FK_EXDATE_PERSONFACT)
    public ExtractedDate getExDate() {
        return exDate;
    }

    public void setExDate(ExtractedDate exDate) {
        this.exDate = exDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publicationDate")
    @ForeignKey(name = Constants.FK_PUBDATE_PERSONFACT)
    public PublicationDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(PublicationDate pubDate) {
        this.pubDate = pubDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingestDate")
    @ForeignKey(name = Constants.FK_INGDATE_PERSONFACT)
    public IngestionDate getIngDate() {
        return ingDate;
    }

    public void setIngDate(IngestionDate ingDate) {
        this.ingDate = ingDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "collectionDate")
    @ForeignKey(name = Constants.FK_COLDATE_PERSONFACT)
    public CollectionDate getColDate() {
        return colDate;
    }

    public void setColDate(CollectionDate colDate) {
        this.colDate = colDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classification")
    @ForeignKey(name = Constants.FK_CLASSIFICATION_PERSONFACT)
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "source")
    @ForeignKey(name = Constants.FK_SOURCE_PERSONFACT)
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthGroup")
    @ForeignKey(name = Constants.FK_DOCLENGTHGROUP_PERSONFACT)
    public DocumentLengthGroup getDocLengthGroup() {
        return docLengthGroup;
    }

    public void setDocLengthGroup(DocumentLengthGroup docLengthGroup) {
        this.docLengthGroup = docLengthGroup;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthPercentile")
    @ForeignKey(name = Constants.FK_DOCLENGTHPERCENTILE_PERSONFACT)
    public DocumentLengthPercentile getDocLengthPercentile() {
        return docLengthPercentile;
    }

    public void setDocLengthPercentile(DocumentLengthPercentile docLengthPercentile) {
        this.docLengthPercentile = docLengthPercentile;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wordStemPercentile")
    @ForeignKey(name = Constants.FK_WORDSTEMPERCENTILE_PERSONFACT)
    public WordStemPercentile getWordStemPercentile() {
        return wordStemPercentile;
    }

    public void setWordStemPercentile(WordStemPercentile wordStemPercentile) {
        this.wordStemPercentile = wordStemPercentile;
    }

    @Column(name = "wordCount")
    public int getWordDocCount() {
        return wordDocCount;
    }

    public void setWordDocCount(int wordDocCount) {
        this.wordDocCount = wordDocCount;
    }

    @Column(name = "wordCountShare")
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

    @Column(name = "positionPercentile")
    public int getPositionPercentile() {
        return positionPercentile;
    }

    public void setPositionPercentile(int positionPercentile) {
        this.positionPercentile = positionPercentile;
    }
}
