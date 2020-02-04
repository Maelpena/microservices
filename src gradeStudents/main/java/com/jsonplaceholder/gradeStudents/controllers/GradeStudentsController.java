package com.jsonplaceholder.gradeStudents.controllers;

import com.jsonplaceholder.gradeStudents.entities.GradeStudentsDTO;
import com.jsonplaceholder.gradeStudents.entities.Student;
//import com.jsonplaceholder.gradeStudents.repository.StudentRepository;
import com.jsonplaceholder.gradeStudents.services.GradeStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeStudentsController {

    @Autowired
    private GradeStudentsService gradeStudentsService;


    @RequestMapping("/gradestudents/{gradeId}")
    ResponseEntity<GradeStudentsDTO> getGradeStudents(@PathVariable Integer gradeId) {
        return new ResponseEntity<>(gradeStudentsService.getGradeStudents(gradeId), HttpStatus.OK);

    }

    @RequestMapping("/gradestudents")
    ResponseEntity<List<GradeStudentsDTO>> getAllGradeStudents() {
        return new ResponseEntity<>(gradeStudentsService.getAllGradeStudents(), HttpStatus.OK);

    }
}
