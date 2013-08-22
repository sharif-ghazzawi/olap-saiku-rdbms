package com.berico.olap.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "command")
public class Command {

    public static final Command USNORTHCOM = new Command(1, "USNORTHCOM");
    public static final Command USSOUTHCOM = new Command(2, "USSOUTHCOM");
    public static final Command USEUCOM = new Command(3, "USEUCOM");
    public static final Command USCENTCOM = new Command(4, "USCENTCOM");
    public static final Command USAFRICOM = new Command(5, "USAFRICOM");
    public static final Command USPACOM = new Command(6, "USPACOM");
    public static final Command NULL = new Command(7, "N/A");

    private Integer id;
    private String name;

    public Command() {}

    private Command(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
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
}
