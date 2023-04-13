package com.example.connect_be_react.service.impl;


import com.example.connect_be_react.model.TypeBook;
import com.example.connect_be_react.repository.ITypeBookRepository;
import com.example.connect_be_react.service.ITypeBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBookService implements ITypeBookService {
    @Autowired
   private ITypeBookRepository typeBookRepository;
    @Override
    public List<TypeBook> getAll() {
        return typeBookRepository.getAll();
    }
}
