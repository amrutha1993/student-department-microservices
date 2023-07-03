package com.microservice.studentservice.repository;

import com.microservice.studentservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public Student findById(Long id){
        return students.stream()
                .filter(student -> student.studentId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Student> findAll(){
        return students;
    }

    public List<Student> findByDepartmentId(Long deptId){
        return students.stream()
                .filter(a -> a.deptId().equals(deptId))
                .toList();
    }
}
