package com.melnikov.MySpringBoot2Base.dao;

import org.springframework.stereotype.Repository;
import com.melnikov.MySpringBoot2Base.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDao {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}
