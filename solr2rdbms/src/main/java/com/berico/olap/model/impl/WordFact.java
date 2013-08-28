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
    private Integer docLengthWords;
    private Integer wordFrequency;
    private Integer wordFrequencyShare;
    private Integer position;
    private Integer positionPercentile;

    public void addDimension(String name, Dimension d) {
        if (name.equals(Constants.WORD)) {
            setWord((Word) d);
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
    public ExtractedLocation getExLocation() {
        return exLocation;
    }

    public void setExLocation(ExtractedLocation exLocation) {
        this.exLocation = exLocation;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "extractedDateId")
    @ForeignKey(name = Constants.FK_EXDATE_WORDFACT)
    public ExtractedDate getExDate() {
        return exDate;
    }

    public void setExDate(ExtractedDate exDate) {
        this.exDate = exDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publicationDateId")
    @ForeignKey(name = Constants.FK_PUBDATE_WORDFACT)
    public PublicationDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(PublicationDate pubDate) {
        this.pubDate = pubDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingestDateId")
    @ForeignKey(name = Constants.FK_INGDATE_WORDFACT)
    public IngestionDate getIngDate() {
        return ingDate;
    }

    public void setIngDate(IngestionDate ingDate) {
        this.ingDate = ingDate;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "collectionDateId")
    @ForeignKey(name = Constants.FK_COLDATE_WORDFACT)
    public CollectionDate getColDate() {
        return colDate;
    }

    public void setColDate(CollectionDate colDate) {
        this.colDate = colDate;
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
    public DocumentLengthGroup getDocLengthGroup() {
        return docLengthGroup;
    }

    public void setDocLengthGroup(DocumentLengthGroup docLengthGroup) {
        this.docLengthGroup = docLengthGroup;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentLengthPercentileId")
    @ForeignKey(name = Constants.FK_DOCLENGTHPERCENTILE_WORDFACT)
    public DocumentLengthPercentile getDocLengthPercentile() {
        return docLengthPercentile;
    }

    public void setDocLengthPercentile(DocumentLengthPercentile docLengthPercentile) {
        this.docLengthPercentile = docLengthPercentile;
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
    public Integer getDocLengthWords() {
        return docLengthWords;
    }

    public void setDocLengthWords(Integer docLengthWords) {
        this.docLengthWords = docLengthWords;
    }

    @Column(name = "wordFrequency")
    public Integer getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Integer wordDocCount) {
        this.wordFrequency = wordDocCount;
    }

    @Column(name = "wordFrequencyShare")
    public Integer getWordFrequencyShare() {
        return wordFrequencyShare;
    }

    public void setWordFrequencyShare(Integer wordDocCountShare) {
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
