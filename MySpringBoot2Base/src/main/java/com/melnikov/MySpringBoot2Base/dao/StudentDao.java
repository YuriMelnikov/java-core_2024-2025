package com.melnikov.MySpringBoot2Base.dao;

import org.springframework.stereotype.Repository;
import com.melnikov.MySpringBoot2Base.entity.Student;

import java.util.List;

@Repository
public interface StudentDao {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
