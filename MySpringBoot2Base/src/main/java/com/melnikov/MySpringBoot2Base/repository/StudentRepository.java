package com.melnikov.MySpringBoot2Base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.melnikov.MySpringBoot2Base.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
