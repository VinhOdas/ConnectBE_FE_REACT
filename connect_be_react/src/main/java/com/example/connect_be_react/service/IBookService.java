package com.example.connect_be_react.service;

import com.example.connect_be_react.dto.BookDto;
import com.example.connect_be_react.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<BookDto> getAll(String name, String typeBook, Pageable pageable);

    Book findBookById(Integer id);

    void deleteBook(Integer id);

    void editBook(Book book);

    void addBook(Book book);
}
