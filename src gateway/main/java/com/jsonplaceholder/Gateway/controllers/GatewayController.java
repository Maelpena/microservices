package com.jsonplaceholder.Gateway.controllers;

import com.jsonplaceholder.Gateway.entities.Grade;
import com.jsonplaceholder.Gateway.entities.GradeStudentsDTO;
import com.jsonplaceholder.Gateway.entities.Student;
import com.jsonplaceholder.Gateway.services.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(gatewayService.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    ResponseEntity<List<Grade>> getAllGrades() {
        return new ResponseEntity<>(gatewayService.getAllGrades(), HttpStatus.OK);
    }

    @RequestMapping(value = "/gradestudents", method = RequestMethod.GET)
    ResponseEntity<Object> getAllGradeStudentsDTO() {
        return new ResponseEntity<>(gatewayService.getAllGradeStudentsDTO(), HttpStatus.OK);
    }
}

