package com.melnikov.MySpringBoot2Base.controller;

import org.springframework.web.bind.annotation.*;
import com.melnikov.MySpringBoot2Base.entity.Student;
import com.melnikov.MySpringBoot2Base.model.Result;
import com.melnikov.MySpringBoot2Base.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private final StudentService studentService;

    public MyController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public Result<List<Student>> getAllStudents() {
        return new Result<>(Result.SUCCESS_MESSAGE, studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public Result<Student> getStudent(@PathVariable("id") int id) {
        return new Result<>(Result.SUCCESS_MESSAGE, studentService.getStudent(id));
    }

    @PostMapping("/students")
    public Result<Student> saveStudent(@RequestBody Student student) {
        return new Result<>(Result.SUCCESS_MESSAGE, studentService.saveStudent(student));
    }

    @PutMapping("/students")
    public Result<Student> updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new Result<>(Result.SUCCESS_MESSAGE, student);
    }

    @DeleteMapping("/students/{id}")
    public Result<Object> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return new Result<>(Result.SUCCESS_MESSAGE, null);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}
