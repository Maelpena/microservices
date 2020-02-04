package com.jsonplaceholder.Gateway.services;


import com.jsonplaceholder.Gateway.clients.IGradeClient;
import com.jsonplaceholder.Gateway.clients.IGradeStudentsClient;
import com.jsonplaceholder.Gateway.clients.IStudentClient;
import com.jsonplaceholder.Gateway.entities.Grade;
import com.jsonplaceholder.Gateway.entities.GradeStudentsDTO;
import com.jsonplaceholder.Gateway.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Service
public class GatewayService {


    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8081/students");

    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class,"http://localhost:8082/grades");

    private IGradeStudentsClient iGradeStudentsClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeStudentsClient.class, "http://localhost:8083/gradestudents");


    public List<Student> getAllStudents() {
        List<Student> students = iStudentClient.getAll();
        return students;
    }

    public List<Grade> getAllGrades() {
        List<Grade> grades = iGradeClient.getAll();
        return grades;
    }

    public Object getAllGradeStudentsDTO() {
        return iGradeStudentsClient.getAll();
    }



}
