package com.example.demo.service;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


//    public ResponseEntity getStudents(){
//        return ResponseEntity.ok(this.studentRepository.findAll());
//    }

    public Optional<Student> getStudentById_UsingPath(Long id){
        return this.studentRepository.findById(id);
    }

    public Optional<Student> getStudentById_UsingParam(Long id){
        return this.studentRepository.findById(id);
    }



    public List<StudentDTO> getStudent(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream().map(this::mapDtoToEntity).collect(Collectors.toList());
    }
    public StudentDTO mapDtoToEntity(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setEmail(student.getEmail());
        studentDTO.setFirstName(student.getFirst_name());
        studentDTO.setLastName(student.getLast_name());
        return studentDTO;
    }

    public StudentDTO createStudent(StudentDTO studentDTO){
        studentRepository.save(mapEntityToDto(studentDTO));
        return  studentDTO;
    }

    public Student mapEntityToDto(StudentDTO studentDTO){
    Student studentEntity = new Student();
    studentEntity.setEmail(studentDTO.getEmail());
    studentEntity.setFirst_name(studentDTO.getFirstName());
    studentEntity.setLast_name(studentDTO.getLastName());
    studentEntity.setCreate_at(LocalDateTime.now());
        return  studentEntity;
    }



//    @PostMapping(path = "/createNP")        //to post entity without being private without using DTO
//    public void CreateWithoutDto(Student student){
//        studentRepository.save(student);
//    }


    public String removeAllStudent(){
        studentRepository.deleteAll();
        return "all students deleted.";
    }

    public String deleteStudentById_UsingParam(Long id){
        this.studentRepository.deleteById(id);
        return "Student with "+id+" has been deleted.";
    }

//    @DeleteMapping(path = "/deleteByPath")   //to delete entity by choosing path
    public String deleteStudentById_UsingPath(Long id){
        this.studentRepository.deleteById(id);
        return "Student with "+id+" has been deleted.";
    }

    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setFirst_name(student.getFirst_name());
        existingStudent.setLast_name(student.getLast_name());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }


}

