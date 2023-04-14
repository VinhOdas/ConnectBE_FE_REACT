package com.example.connect_be_react.dto;

import com.example.connect_be_react.model.TypeBook;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookDto {
    private Integer id;
    @Pattern(regexp = "BO-[0-9]{4}$", message = " định dạng BO-XXXX")
    private String idName;
    @Size(max = 100, message = "Tên sách không dài quá 100 ký tự")
    private String name;
    private String day;
    @Positive(message = "Số lượng sách phải là số nguyên dương")
    @Digits(fraction = 0, message = "Số lượng sách phải là số nguyên", integer = 10)
    private Integer soLuong;
    private TypeBook typeBook;
    private boolean flagDelete = false;

    public BookDto() {
    }

    public BookDto(Integer id, String idName, String name, String day, Integer soLuong, TypeBook typeBook, boolean flagDelete) {
        this.id = id;
        this.idName = idName;
        this.name = name;
        this.day = day;
        this.soLuong = soLuong;
        this.typeBook = typeBook;
        this.flagDelete = flagDelete;
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

    public TypeBook getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(TypeBook typeBook) {
        this.typeBook = typeBook;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
