package com.example.demo.repository;

import com.example.demo.entitiy.Book;
import com.example.demo.entitiy.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
