package com.example.demo.service;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


//    @GetMapping(path = "/getAll")                   //return all entity in normal way
    public ResponseEntity getAllStudents(){
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

//    @GetMapping(path = "/getParam/{id}")         //return specific id entity by using @PathVariable
    public Optional<Student> getStudentByParam(Long id){
        return this.studentRepository.findById(id);
    }

//    @GetMapping(path = "/getPath")              //return specific Param by using @RequestParam
    public Optional<Student> getStudentByPath(Long id){
        return this.studentRepository.findById(id);
    }

//    @PostMapping(path = "/createP")             //to post entity being private using DTO
    public ResponseEntity<StudentDTO> CreateWithDto(Student student){
        studentRepository.save(student);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student,studentDTO);
        return  ResponseEntity.ok(studentDTO);
    }

//    @PostMapping(path = "/createNP")        //to post entity without being private without using DTO
    public void CreateWithoutDto(Student student){
        studentRepository.save(student);
    }


//    @DeleteMapping(path = "/deleteAll")        //to delete all entity
    public String deleteAllStudent(){
        studentRepository.deleteAll();
        return "all users deleted.";
    }

//    @DeleteMapping(path = "/deleteByParam/{id}")   //to delete id entity by choosing Param
    public String deleteStudentByParam (Long id){
        this.studentRepository.deleteById(id);
        return "User with "+id+" has been deleted.";
    }

//    @DeleteMapping(path = "/deleteByPath")   //to delete entity by choosing path
    public String deleteStudentByPath(Long id){
        this.studentRepository.deleteById(id);
        return "User with "+id+" has been deleted.";
    }

    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setFirst_name(student.getFirst_name());
        existingStudent.setLast_name(student.getLast_name());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }


}

