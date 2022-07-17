package com.example.demo.controller;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.entitiy.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/getAll")                   //return all entity in normal way
    public ResponseEntity getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/getParam/{id}")         //return specific id entity by using @PathVariable
    public Optional<Student> getByParam(@PathVariable Long id){
        return studentService.getStudentByParam(id);
    }

    @GetMapping(path = "/getPath")              //return specific Param by using @RequestParam
    public Optional<Student> getByPath(@RequestParam Long id){
        return this.studentService.getStudentByPath(id);
    }

    @PostMapping(path = "/createP")             //to post entity being private using DTO
    public ResponseEntity<StudentDTO> SaveWithDto(@RequestBody Student student){
        return  studentService.CreateWithDto(student);
    }

    @PostMapping(path = "/createNP")        //to post entity without being private without using DTO
    public void SaveWithoutDto(@RequestBody Student student){
        studentService.CreateWithoutDto(student);
    }


    @DeleteMapping(path = "/deleteAll")        //to delete all entity
    public String deleteAll(){
        return studentService.deleteAllStudent();
    }

    @DeleteMapping(path = "/deleteByParam/{id}")   //to delete id entity by choosing Param
    public String deleteByParam (@PathVariable Long id){
        return studentService.deleteStudentByParam(id);
    }

    @DeleteMapping(path = "/deleteByPath")   //to delete entity by choosing path
    public String deleteByPath(@RequestParam Long id){
        return studentService.deleteStudentByPath(id);
    }

    @PutMapping(path = "/update")
    public Student update(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}

//    @PostMapping(path = "/createP")             //to post entity being private using DTO
//    public ResponseEntity<StudentDTO> Create(@RequestBody Student student){
//        if (student != null){
//            studentRepository.save(student);
//            StudentDTO studentDTO = new StudentDTO();
//            BeanUtils.copyProperties(student,studentDTO);
//            return  ResponseEntity.ok(studentDTO);
//        }else return ResponseEntity.notFound().build();}
