package com.example.demo.service;


import com.example.demo.entitiy.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


//    private List<Book> books = new ArrayList<>(Arrays.asList(
//            new Book()
//    ));
//
//    public List<Book> getAllBooks(){
//        List<Book> books = new ArrayList<>();
//        bookRepository.findAll().forEach(books :: add);
//        return books;
//    }
//
//    public Book getBook(String id){
//        return books.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//    }
//
//    public void addBook(Book book){
//        bookRepository.save(book);
//    }
}
