package com.example.connect_be_react.repository;

import com.example.connect_be_react.model.Book;
import com.example.connect_be_react.model.TypeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeBookRepository extends JpaRepository<TypeBook, Integer> {
    @Query(value = "select * from type_book ",nativeQuery = true)
    List<TypeBook> getAll();
}
