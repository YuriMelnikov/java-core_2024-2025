package com.melnikov.MySpringBoot2Base.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.melnikov.MySpringBoot2Base.dao.StudentDao;
import com.melnikov.MySpringBoot2Base.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        Student student = studentDao.getStudent(id);
        if (student == null) {
            throw new EntityNotFoundException("Студент с " + id + " не найден");
        }
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Student student = studentDao.getStudent(id);
        if (student == null) {
            throw new EntityNotFoundException("Студент с " + id + " не найден");
        }
        studentDao.deleteStudent(id);
    }
}
