package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "classification")
public class Classification implements Dimension {

    private Integer id;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
