package com.example.demo.repository;

import com.example.demo.entitiy.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


}
//update
