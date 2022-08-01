package com.example.demo.repository;

import com.example.demo.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query( "select s from student s where s.email = :email ")
    Student findStudentByEmail(@Param("email") String email);

//    List<Student> getStudentByEmail(String email);

}
