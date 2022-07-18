package com.example.demo.controller;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.entitiy.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping(path = "/getAllStudents")                   //return all entity in normal way
//    public ResponseEntity getAllStudents(){
//        return studentService.getStudents();
//    }

    @GetMapping(path = "/getAllStudent")
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        return new ResponseEntity<>(studentService.getStudent(),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getStudentById/{id}")         //return specific id entity by using @PathVariable
    public Optional<Student> getStudentById_InPath(@PathVariable Long id){
        return studentService.getStudentById_UsingPath(id);
    }

    @GetMapping(path = "/getStudentById")              //return specific Param by using @RequestParam
    public Optional<Student> getStudentById_InParam(@RequestParam Long id){
        return this.studentService.getStudentById_UsingParam(id);
    }

    @PostMapping(path = "/createStudent")             //to post entity being private using DTO
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO student = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    @PostMapping(path = "/createNP")        //to post entity without being private without using DTO
//    public void SaveWithoutDto(@RequestBody Student student){
//        studentService.CreateWithoutDto(student);
//    }


    @DeleteMapping(path = "/deleteAllStudents")        //to delete all entity
    public String deleteAllStudents(){
        return studentService.removeAllStudent();
    }

    @DeleteMapping(path = "/deleteStudentById/{id}")   //to delete id entity by choosing Param
    public String deleteStudentById_InParam(@PathVariable Long id){
        return studentService.deleteStudentById_UsingParam(id);
    }

    @DeleteMapping(path = "/deleteStudentById")   //to delete entity by choosing path
    public String deleteStudentById_InPath(@RequestParam Long id){
        return studentService.deleteStudentById_UsingPath(id);
    }

    @PutMapping(path = "/updateStudentById")
    public Student updateStudentById(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}

