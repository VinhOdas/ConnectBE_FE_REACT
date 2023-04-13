package com.example.connect_be_react.controller;

import com.example.connect_be_react.model.Book;
import com.example.connect_be_react.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public ResponseEntity<Page<Book>> getAll() {
        List<Book> benXes = bookService.getAll();
        if (benXes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(benXes, HttpStatus.OK);
    }



}
