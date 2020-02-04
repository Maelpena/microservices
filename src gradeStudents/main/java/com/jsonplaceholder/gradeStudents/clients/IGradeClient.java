package com.jsonplaceholder.gradeStudents.clients;

import com.jsonplaceholder.gradeStudents.entities.Grade;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name ="GradeClient")

public interface IGradeClient {
    @RequestLine("GET /{id}")
    Grade getOneById(@Param("id") Integer id);

    @RequestLine("GET /")
    List<Grade> getAll();
}
