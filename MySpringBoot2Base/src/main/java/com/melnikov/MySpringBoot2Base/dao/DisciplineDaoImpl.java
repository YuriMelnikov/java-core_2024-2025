package com.melnikov.MySpringBoot2Base.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import com.melnikov.MySpringBoot2Base.entity.Discipline;

import java.util.List;

@Slf4j
@Repository
public class DisciplineDaoImpl implements DisciplineDao {

    private final EntityManager entityManager;

    public DisciplineDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query.getResultList();
        log.info("getAllDisciplines" + allDisciplines);
        return allDisciplines;
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return entityManager.merge(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from Discipline where id = :disciplineId");
        query.setParameter("disciplineId", id);
        query.executeUpdate();
    }
}
