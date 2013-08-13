package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

public class Document implements Dimension<String> {
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
