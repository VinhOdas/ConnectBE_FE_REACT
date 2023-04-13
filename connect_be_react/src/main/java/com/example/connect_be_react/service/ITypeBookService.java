package com.example.connect_be_react.service;

import com.example.connect_be_react.model.TypeBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITypeBookService  {

    List<TypeBook> getAll();
}
