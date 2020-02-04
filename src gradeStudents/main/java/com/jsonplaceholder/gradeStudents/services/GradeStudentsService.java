package com.jsonplaceholder.gradeStudents.services;


import com.jsonplaceholder.gradeStudents.clients.IGradeClient;
import com.jsonplaceholder.gradeStudents.clients.IStudentClient;
import com.jsonplaceholder.gradeStudents.entities.Grade;
import com.jsonplaceholder.gradeStudents.entities.GradeStudentsDTO;
import com.jsonplaceholder.gradeStudents.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Service
public class GradeStudentsService {


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

    public GradeStudentsDTO getGradeStudents(Integer gradeId) {
        log.info("Call to the Grade client - getOneById : " + gradeId);
        Grade grade = iGradeClient.getOneById(gradeId);

        log.info("Call to the Students client - getAll");
        List<Student> GradeStudents = iStudentClient.getAll().stream().filter(s -> s.getGradeId().equals(gradeId)).collect(Collectors.toList());

        return new GradeStudentsDTO(grade, GradeStudents) ;
    }

    public List<GradeStudentsDTO> getAllGradeStudents() {

        List<Grade> grade = iGradeClient.getAll();
        List<Student> gradeStudents = iStudentClient.getAll();
        List<GradeStudentsDTO> gradStudList = new ArrayList<>();
        for(Grade g : grade) {
            List<Student> students = gradeStudents.stream().filter(s -> s.getGradeId().equals(g.getId())).collect(Collectors.toList());
            gradStudList.add(new GradeStudentsDTO(g, students));

        }

        return gradStudList;
    }

}
