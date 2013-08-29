package com.berico.olap.model.impl;

import com.berico.olap.util.Constants;
import com.berico.olap.model.Cube;
import com.berico.olap.model.Dimension;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

@Entity
@Table(name = "wordFact")
public class WordFact implements Cube {

    private Integer id;
    private Word word;
    private Document document;
    private ExtractedLocation extractedLocation;
    private ExtractedDate extractedDate;
    private PublicationDate publicationDate;
    private IngestionDate ingestDate;
    private CollectionDate collectionDate;
    private Classification classification;
    private Source source;
    private DocumentLengthGroup documentLengthGroup;
    private DocumentLengthPercentile documentLengthPercentile;
    private WordStemPercentile wordStemPercentile;
    private Integer documentLengthWords;
    private Integer wordFrequency;
    private Float wordFrequencyShare;
    private Integer position;
    private Integer positionPercentile;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.WORD)) {
            setWord((Word) d);
        } else if (name.equals(Constants.DOCUMENT)) {
            setDocument((Document) d);
        } else if (name.equals(Constants.EXTRACTED_LOCATION)) {
            setExtractedLocation((ExtractedLocation) d);
        } else if (name.equals(Constants.EXTRACTED_DATE)) {
            setExtractedDate((ExtractedDate) d);
        } else if (name.equals(Constants.PUBLICATION_DATE)) {
            setPublicationDate((PublicationDate) d);
        } else if (name.equals(Constants.INGESTION_DATE)) {
            setIngestDate((IngestionDate) d);
        } else if (name.equals(Constants.COLLECTION_DATE)) {
            setCollectionDate((CollectionDate) d);
        } else if (name.equals(Constants.CLASSIFICATION)) {
            setClassification((Classification) d);
        } else if (name.equals(Constants.SOURCE)) {
            setSource((Source) d);
        } else if (name.equals(Constants.DOCUMENT_LENGTH_GROUP)) {
            setDocumentLengthGroup((DocumentLengthGroup) d);
        } else if (name.equals(Constants.DOCUMENT_LENGTH_PERCENTILE)) {
            setDocumentLengthPercentile((DocumentLengthPercentile) d);
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
    @JoinColumn(name = "wordId")
    @ForeignKey(name = Constants.FK_WORD_WORDFACT)
    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentId")
    @ForeignKey(name = Constants.FK_DOCUMENT_WORDFACT)
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedLocationId")
    @ForeignKey(name = Constants.FK_EXLOCATION_WORDFACT)
    public ExtractedLocation getExtractedLocation() {
        return extractedLocation;
    }

    public void setExtractedLocation(ExtractedLocation exLocation) {
        this.extractedLocation = exLocation;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedDateId")
    @ForeignKey(name = Constants.FK_EXDATE_WORDFACT)
    public ExtractedDate getExtractedDate() {
        return extractedDate;
    }

    public void setExtractedDate(ExtractedDate exDate) {
        this.extractedDate = exDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publicationDateId")
    @ForeignKey(name = Constants.FK_PUBDATE_WORDFACT)
    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(PublicationDate pubDate) {
        this.publicationDate = pubDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingestDateId")
    @ForeignKey(name = Constants.FK_INGDATE_WORDFACT)
    public IngestionDate getIngestDate() {
        return ingestDate;
    }

    public void setIngestDate(IngestionDate ingDate) {
        this.ingestDate = ingDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "collectionDateId")
    @ForeignKey(name = Constants.FK_COLDATE_WORDFACT)
    public CollectionDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(CollectionDate colDate) {
        this.collectionDate = colDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classificationId")
    @ForeignKey(name = Constants.FK_CLASSIFICATION_WORDFACT)
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sourceId")
    @ForeignKey(name = Constants.FK_SOURCE_WORDFACT)
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthGroupId")
    @ForeignKey(name = Constants.FK_DOCLENGTHGROUP_WORDFACT)
    public DocumentLengthGroup getDocumentLengthGroup() {
        return documentLengthGroup;
    }

    public void setDocumentLengthGroup(DocumentLengthGroup docLengthGroup) {
        this.documentLengthGroup = docLengthGroup;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthPercentileId")
    @ForeignKey(name = Constants.FK_DOCLENGTHPERCENTILE_WORDFACT)
    public DocumentLengthPercentile getDocumentLengthPercentile() {
        return documentLengthPercentile;
    }

    public void setDocumentLengthPercentile(DocumentLengthPercentile docLengthPercentile) {
        this.documentLengthPercentile = docLengthPercentile;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wordStemPercentileId")
    @ForeignKey(name = Constants.FK_WORDSTEMPERCENTILE_WORDFACT)
    public WordStemPercentile getWordStemPercentile() {
        return wordStemPercentile;
    }

    public void setWordStemPercentile(WordStemPercentile wordStemPercentile) {
        this.wordStemPercentile = wordStemPercentile;
    }

    @Column(name = "documentLengthWords")
    public Integer getDocumentLengthWords() {
        return documentLengthWords;
    }

    public void setDocumentLengthWords(Integer docLengthWords) {
        this.documentLengthWords = docLengthWords;
    }

    @Column(name = "wordFrequency")
    public Integer getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Integer wordDocCount) {
        this.wordFrequency = wordDocCount;
    }

    @Column(name = "wordFrequencyShare")
    public Float getWordFrequencyShare() {
        return wordFrequencyShare;
    }

    public void setWordFrequencyShare(Float wordDocCountShare) {
        this.wordFrequencyShare = wordDocCountShare;
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
