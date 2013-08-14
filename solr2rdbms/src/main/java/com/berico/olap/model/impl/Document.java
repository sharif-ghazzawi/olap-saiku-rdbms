package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Column;
import javax.persistence.Id;

public class Document implements Dimension<String> {

    private String id;
    private String documentTitle;
    private String fullText;

    @Id
    @Column(name = "documentId")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "documentTitle")
    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    @Column(name = "fulltext")
    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

}
