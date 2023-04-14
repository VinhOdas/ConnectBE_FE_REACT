package com.example.connect_be_react.service.impl;

import com.example.connect_be_react.dto.BookDto;
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
    public Page<BookDto> getAll(String name, String typeBook ,Pageable pageable ) {
        return bookRepository.getAll(name, typeBook, pageable);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteBook(id);

    }

    @Override
    public void editBook(Book book) {
        bookRepository.editBook(book);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }
}
