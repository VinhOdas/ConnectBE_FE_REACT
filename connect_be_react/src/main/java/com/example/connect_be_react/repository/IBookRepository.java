package com.example.connect_be_react.repository;

import com.example.connect_be_react.dto.BookDto;
import com.example.connect_be_react.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {
//    @Query(value = "select * from book where flag_delete = false ",nativeQuery = true)
//    Page<Book> getAll(Pageable pageable);

    @Query(value = "select * from book where flag_delete = false and name like concat('%', :name, '%')" +
                             "and type_id  like concat('%', :typeId, '%')",nativeQuery = true)
    Page<BookDto> getAll(@Param("name") String name, @Param("typeId") String typeBook, Pageable pageable);


    @Query(value = "select * from book where flag_delete =false and id =:id",nativeQuery = true)
    Book findBookById(Integer id);
    @Transactional
    @Modifying
    @Query(value = "update book set flag_delete = true where id =:id",nativeQuery = true)
    void deleteBook(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update  book  set " +
            "id_name =:#{#book.id}," +
            "name =:#{#book.name}," +
            "type_id =:#{#book.typeBook}," +
            "day =:#{#book.day}," +
            "so_luong =:#{#book.soLuong}," +
            "where id =:#{#book.id}," +
            "and flag_delete = false ", nativeQuery = true)
    void editBook(@Param("book") Book book);
    @Transactional
    @Modifying
    @Query(value = "insert into book" +
            "(id_name," +
            "name," +
            "type_id," +
            "day," +
            "so_luong," +
            "flag_delete)" +
            "values " +
            "(:#{#book.idName}," +
            ":#{#book.name}," +
            ":#{#book.typeBook," +
            ":#{#book.day}," +
            ":#{#book.soLuong}," +
            ":#{#book.flagDelete})", nativeQuery = true)
    void addBook(@Param("book") Book book);
}
