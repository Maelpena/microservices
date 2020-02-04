package com.jsonplaceholder.Students.controllers;

import com.jsonplaceholder.Students.entities.Student;
import com.jsonplaceholder.Students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired

    private StudentRepository studentRepository;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    Student getOne(@PathVariable Integer id) throws Exception {
        //log.info("Retrieving course with id : " + id);
        return studentRepository.findById(id)
                .orElseThrow(() -> new Exception("No student found with id : " + id));
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }

    @PutMapping("/students/{id}")
    Student putById(@RequestBody Student newStudent, @PathVariable Integer id) {
        return studentRepository.findById(id)
                .map(stud -> {
                    stud.setStudent_id(id);

                    if (newStudent.getFirstname() != null)
                            stud.setFirstname(newStudent.getFirstname());

                    if (newStudent.getLastname() != null)
                        stud.setLastname(newStudent.getLastname());

                    if (newStudent.getBirthdate() != null)
                        stud.setBirthdate(newStudent.getBirthdate());

                    if (newStudent.getGradeId() != null)
                        stud.setGradeId(newStudent.getGradeId());

                    return studentRepository.save(stud);
                } )
                .orElseGet(() -> {
                    newStudent.setStudent_id(id);
                    return studentRepository.save(newStudent);
                });
    }
}

