package com.example.connect_be_react.service;

import com.example.connect_be_react.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
}
