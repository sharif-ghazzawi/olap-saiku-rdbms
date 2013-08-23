package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "source")
public class Source implements Dimension {

    private Integer id;
    private String name;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
