package com.example.connect_be_react.repository;

import com.example.connect_be_react.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {
//    @Query(value = "select * from book where flag_delete = false ",nativeQuery = true)
//    Page<Book> getAll(Pageable pageable);

    @Query(value = "select * from book where flag_delete = false ",nativeQuery = true)
    List<Book> getAll();
}
