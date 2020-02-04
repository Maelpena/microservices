package com.jsonplaceholder.grades.controllers;

import com.jsonplaceholder.grades.entities.Grade;
import com.jsonplaceholder.grades.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradesController {
    @Autowired

    private GradeRepository gradeRepository;


    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    List<Grade> getAll() {
        return (List<Grade>) gradeRepository.findAll();
    }

    @RequestMapping(value = "/grades", method = RequestMethod.POST)
    Grade newGrade(@RequestBody Grade newGrade) {
        return gradeRepository.save(newGrade);
    }

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.GET)
    Grade getOne(@PathVariable Integer id) throws Exception {
        //log.info("Retrieving course with id : " + id);
        return gradeRepository.findById(id)
                .orElseThrow(() -> new Exception("No grade found with id : " + id));
    }

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable Integer id) {
        gradeRepository.deleteById(id);
    }

    @PutMapping("/grades/{id}")
    Grade putById(@RequestBody Grade newGrade, @PathVariable Integer id) {
        return gradeRepository.findById(id)
                .map(grade -> {
                    grade.setGrade_id(id);

                    if (newGrade.getTitle() != null)
                        grade.setTitle(newGrade.getTitle());

                    if (newGrade.getYear() != null)
                        grade.setYear(newGrade.getYear());

                    return gradeRepository.save(grade);
                } )
                .orElseGet(() -> {
                    newGrade.setGrade_id(id);
                    return gradeRepository.save(newGrade);
                });
    }
}