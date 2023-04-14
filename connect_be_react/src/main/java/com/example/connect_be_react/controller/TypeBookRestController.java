package com.example.connect_be_react.controller;

import com.example.connect_be_react.model.Book;
import com.example.connect_be_react.model.TypeBook;
import com.example.connect_be_react.service.IBookService;
import com.example.connect_be_react.service.ITypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/typeBook")
public class TypeBookRestController {
    @Autowired
    private ITypeBookService  typeBookService;
    @GetMapping("")
    public ResponseEntity<List<TypeBook>> getAll() {
        List<TypeBook> typeBooks = typeBookService.getAll();
        if (typeBooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeBooks, HttpStatus.OK);
    }


}


