package com.microservice.studentservice.model;

public record Student(Long studentId, Long deptId, String studentName, int age, String gender) {


}
