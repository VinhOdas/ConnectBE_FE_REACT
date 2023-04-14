package com.example.connect_be_react.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String idName;
    @Column(unique = true)
    private String name;
    private String day;
    private Integer soLuong;
    private boolean flagDelete = false;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeBook typeBook;

    public Book() {
    }

    public Book(Integer id, String idName, String name, String day, Integer soLuong, boolean flagDelete, TypeBook typeBook) {
        this.id = id;
        this.idName = idName;
        this.name = name;
        this.day = day;
        this.soLuong = soLuong;
        this.flagDelete = flagDelete;
        this.typeBook = typeBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public TypeBook getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(TypeBook typeBook) {
        this.typeBook = typeBook;
    }


}
