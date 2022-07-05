package com.example.demo.controller;


import com.example.demo.DTO.StudentDTO;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entitiy.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentController(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    @GetMapping
    public ResponseEntity getAllStudents(){return  ResponseEntity.ok(this.studentRepository.findAll());}

    @PostMapping(path = "api/student/dto")
    public ResponseEntity<StudentDTO> Create(@RequestBody Student student){
        studentRepository.save(student);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student,studentDTO);
        return  ResponseEntity.ok(studentDTO);
    }

    @PostMapping(path = "/api/student")
    public void registerNewStudent(@RequestBody Student student){
        studentRepository.save(student);
    }


    //    @DeleteMapping
//    public void deleteStudent(Student student){
//        studentRepository.delete(student);
//    }

}
