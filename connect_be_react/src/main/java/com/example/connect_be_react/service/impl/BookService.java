package com.example.connect_be_react.service.impl;

import com.example.connect_be_react.model.Book;
import com.example.connect_be_react.repository.IBookRepository;
import com.example.connect_be_react.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
 @Autowired
    private IBookRepository bookRepository;


    @Override
    public List<Book> getAll( ) {
        return bookRepository.getAll();
    }
}