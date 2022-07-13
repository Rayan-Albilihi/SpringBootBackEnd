package com.example.demo.controller;


import com.example.demo.DTO.StudentDTO;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entitiy.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentController(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    @GetMapping(path = "/get")                   //return all entity in normal way
    public ResponseEntity getAllStudents(){return  ResponseEntity.ok(this.studentRepository.findAll());}

    @GetMapping(path = "/getParam/{id}")         //return specific Path by using @PathVariable
    public Optional<Student> getStudentByParam(@PathVariable Long id){
        return this.studentRepository.findById(id);
    }

    @GetMapping(path = "/getPath")              //return specific Param by using @RequestParam
    public Optional<Student> getStudentByPath(@RequestParam Long id){
        return this.studentRepository.findById(id);
    }
    @PostMapping(path = "/createP")             //to post entity being private using DTO
    public ResponseEntity<StudentDTO> Create(@RequestBody Student student){
        studentRepository.save(student);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student,studentDTO);
        return  ResponseEntity.ok(studentDTO);
    }

    @PostMapping(path = "/createNP")        //to post entity without being private without using DTO
    public void registerNewStudent(@RequestBody Student student){
        studentRepository.save(student);
    }


    //    @DeleteMapping
//    public void deleteStudent(Student student){
//        studentRepository.delete(student);
//    }


//    @PostMapping(path = "/createP")             //to post entity being private using DTO
//    public ResponseEntity<StudentDTO> Create(@RequestBody Student student){
//        if (student != null){
//            studentRepository.save(student);
//            StudentDTO studentDTO = new StudentDTO();
//            BeanUtils.copyProperties(student,studentDTO);
//            return  ResponseEntity.ok(studentDTO);
//        }else return ResponseEntity.notFound().build();}

}
