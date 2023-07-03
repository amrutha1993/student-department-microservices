package com.microservice.studentservice.controller;

import com.microservice.studentservice.model.Student;
import com.microservice.studentservice.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student add (@RequestBody Student student) {
        LOGGER.info("Student add: {}", student);
        return studentRepository.addStudent(student);
    }

    @GetMapping
    public List<Student> findAll(){
        LOGGER.info("Student find all");
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        LOGGER.info("Student find: id={}", id);
        return studentRepository.findById(id);
    }

    @GetMapping("/department/{deptId}")
    public List<Student>findByDepartment(@PathVariable("deptId") Long deptId){
        LOGGER.info("Student find: deptId={}", deptId);
        return studentRepository.findByDepartmentId(deptId);
        }


}
