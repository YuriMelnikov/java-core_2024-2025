package com.melnikov.MySpringBoot2Base.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.melnikov.MySpringBoot2Base.dao.DisciplineDao;
import com.melnikov.MySpringBoot2Base.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineDao disciplineDao;

    public DisciplineServiceImpl(DisciplineDao disciplineDao) {
        this.disciplineDao = disciplineDao;
    }

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineDao.getAllDisciplines();
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDao.saveDiscipline(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        Discipline discipline = disciplineDao.getDiscipline(id);
        if (discipline == null) {
            throw new EntityNotFoundException("Дисциплина с " + id + " не найдена");
        }
        return disciplineDao.getDiscipline(id);
    }

    @Override
    public void deleteDiscipline(int id) {
        Discipline discipline = disciplineDao.getDiscipline(id);
        if (discipline == null) {
            throw new EntityNotFoundException("Дисциплина с " + id + " не найдена");
        }
        disciplineDao.deleteDiscipline(id);
    }
}
