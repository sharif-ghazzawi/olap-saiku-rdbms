package com.berico.olap.model.impl;

import com.berico.olap.util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "command")
public class Command {

    public static final Command NORTHCOM = new Command(1, Constants.NORTHCOM);
    public static final Command SOUTHCOM = new Command(2, Constants.SOUTHCOM);
    public static final Command EUCOM = new Command(3, Constants.EUCOM);
    public static final Command CENTCOM = new Command(4, Constants.CENTCOM);
    public static final Command AFRICOM = new Command(5, Constants.AFRICOM);
    public static final Command PACOM = new Command(6, Constants.PACOM);
    public static final Command NULL = new Command(7, Constants.NULL_COMMAND);

    private Integer id;
    private String name;

    protected Command() {
        this(NULL);
    }

    private Command(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Command(Command command) {
        this.id = command.id;
        this.name = command.name;
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

    private void setName(String name) {
        this.name = name;
    }
}
