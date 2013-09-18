package com.berico.olap.model.impl;

import com.berico.olap.model.*;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word implements Dimension {

    private Integer id;
    private String word;
    private String stem;
    private Integer fineId;
    private String fineName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String name) {
        this.word = name;
    }

    @Column(name = "stem")
    public String getStem() {
        return stem;
    }

    public void setStem(String concept) {
        this.stem = concept;
    }

    @Column(name = "fine_id")
    public Integer getFineId() {
        return fineId;
    }

    public void setFineId(Integer fineId) {
        this.fineId = fineId;
    }

    @Column(name = "fine_name")
    public String getFineName() {
        return fineName;
    }

    public void setFineName(String fineName) {
        this.fineName = fineName;
    }
}