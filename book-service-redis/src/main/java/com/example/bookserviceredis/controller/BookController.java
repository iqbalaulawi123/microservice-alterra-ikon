package com.example.bookserviceredis.controller;

import com.example.bookserviceredis.model.BaseResponse;
import com.example.bookserviceredis.model.Book;
import com.example.bookserviceredis.repository.BookRepository;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public BaseResponse<List<Book>> getAll(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);

        BaseResponse<List<Book>> response = new BaseResponse<>(
                "success",
                "all books",
                books
        );
        return response;
    }
    @GetMapping("/{id}")
    public BaseResponse<Optional<Book>> getById(@PathVariable String id){
        Optional<Book> books = bookRepository.findById(id);
        BaseResponse<Optional<Book>> response = new BaseResponse<>(
                "success",
                "books by id:"+id,
                books
        );
        return response;
    }

    @PostMapping
    public BaseResponse<Book> create(@RequestBody Book book){
        UUID uuid = UUID.randomUUID();

        Book saved_book = bookRepository.save(book);

        BaseResponse<Book> response = new BaseResponse<>(
                "success",
                "book created",
                saved_book
        );
        return response;
    }

    @PutMapping
    public BaseResponse<Book> update(@RequestBody Book book, @PathVariable String id){
        Book updated_book = bookRepository.save(book);

        BaseResponse<Book> response = new BaseResponse<>(
                "success",
                "book edited id:"+id,
                updated_book
        );
        return response;
    }

    @DeleteMapping
    public BaseResponse delete(@PathVariable String id){
        bookRepository.deleteById(id);
        BaseResponse response = new BaseResponse<>(
                "success",
                "book deleted id:"+id,
                null
        );
        return response;
    }
}
