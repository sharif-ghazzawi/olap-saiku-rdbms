package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="wordfact")
public class WordFact extends FactCube {

	private String wordId;
	
	public void addDimension(String name, Dimension d) {
		if (name.equals("word")){
			setWordId(((Word)d).getId());
		} else if (name.equals("document")) {
			setDocumentId(((Document)d).getId());
		} else if (name.equals("exLocation")) {
			setExLocationId(((ExtractedLocation)d).getId());
		} else if (name.equals("exDate")) {
			setExDateId(((ExtractedDate)d).getId());
		} else if (name.equals("pubDate")) {
			setPubDateId(((PublicationDate)d).getId());
		} else if (name.equals("ingDate")) {
			setIngDateId(((IngestionDate)d).getId());
		} else if (name.equals("colDate")) {
			setColDateId(((CollectionDate)d).getId());
		} else if (name.equals("classification")){
			setClassificationId(((Classification)d).getId());
		} else if (name.equals("source")) {
			setSourceId(((Source)d).getId());
		} else if (name.equals("docLengthGroup")) {
			setDocLengthGroupId(((DocumentLengthGroup)d).getId());
		} else if (name.equals("docLengthPercentile")) {
			setDocLengthPercentileId(((DocumentLengthPercentile)d).getId());
		} else if (name.equals("wordStemPercentile")) {
			setWordStemPercentileId(((WordStemPercentile)d).getId());
		}
	}

    @Column(name="wordId")
    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }
}
