package com.melnikov.MySpringBoot2Base.controller;

import org.springframework.web.bind.annotation.*;
import com.melnikov.MySpringBoot2Base.entity.Discipline;
import com.melnikov.MySpringBoot2Base.model.Result;
import com.melnikov.MySpringBoot2Base.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyDisciplineController {

    private final DisciplineService disciplineService;

    public MyDisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/disciplines")
    public Result<List<Discipline>> getAllDisciplines() {
        return new Result<>(Result.SUCCESS_MESSAGE, disciplineService.getAllDisciplines());
    }

    @GetMapping("/disciplines/{id}")
    public Result<Discipline> getDiscipline(@PathVariable("id") int id) {
        return new Result<>(Result.SUCCESS_MESSAGE, disciplineService.getDiscipline(id));
    }

    @PostMapping("/disciplines")
    public Result<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        return new Result<>(Result.SUCCESS_MESSAGE, disciplineService.saveDiscipline(discipline));
    }

    @PutMapping("/disciplines")
    public Result<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        disciplineService.saveDiscipline(discipline);
        return new Result<>(Result.SUCCESS_MESSAGE, discipline);
    }

    @DeleteMapping("/disciplines/{id}")
    public Result<Object> deleteDiscipline(@PathVariable("id") int id) {
        disciplineService.deleteDiscipline(id);
        return new Result<>(Result.SUCCESS_MESSAGE, null);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}
