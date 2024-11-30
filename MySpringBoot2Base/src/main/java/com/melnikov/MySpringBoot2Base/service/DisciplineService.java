package com.melnikov.MySpringBoot2Base.service;

import org.springframework.stereotype.Service;
import com.melnikov.MySpringBoot2Base.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}
