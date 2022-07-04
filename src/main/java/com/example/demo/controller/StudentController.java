package com.example.demo.controller;


import com.example.demo.repository.StudentRepository;
import com.example.demo.entitiy.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        return  ResponseEntity.ok(this.studentRepository.findAll());
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
//    @DeleteMapping
//    public ResponseEntity setProducts(){
//        return  ResponseEntity.ok(this.studentRepository.deleteAll();));
//    }

}
