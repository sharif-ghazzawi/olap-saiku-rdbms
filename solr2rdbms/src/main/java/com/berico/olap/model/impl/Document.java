package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document implements Dimension {

    private Integer id;
    private String drsiId;
    private String title;
    private String body;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "drsiDocId")
    public String getDrsiId() {
        return drsiId;
    }

    public void setDrsiId(String drsiId) {
        this.drsiId = drsiId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "body", length = 65535)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
