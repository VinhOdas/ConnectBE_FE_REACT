package com.example.connect_be_react.controller;

import com.example.connect_be_react.dto.BookDto;
import com.example.connect_be_react.model.Book;
import com.example.connect_be_react.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public ResponseEntity<Page<BookDto>> getAll(@PageableDefault(size = 3)Pageable pageable,
                                             @RequestParam(required = false, defaultValue = "") String name,
                                             @RequestParam(required = false, defaultValue = "") String typeBook) {
        Page<BookDto> books = bookService.getAll(name,typeBook,pageable);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") Integer id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Integer id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editBenXe(@RequestBody @Validated BookDto bookDto, BindingResult bindingResult, @PathVariable("id") Integer id) {
        Book book = bookService.findBookById(id);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(bookDto, book);
        bookService.editBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBenXe(@RequestBody @Validated BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
