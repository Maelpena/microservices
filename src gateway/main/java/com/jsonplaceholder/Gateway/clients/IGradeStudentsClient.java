package com.jsonplaceholder.Gateway.clients;

import com.jsonplaceholder.Gateway.entities.Grade;
import com.jsonplaceholder.Gateway.entities.GradeStudentsDTO;
import com.jsonplaceholder.Gateway.entities.Student;
import feign.RequestLine;

import java.util.List;

public interface IGradeStudentsClient {
    @RequestLine("GET /")
    List<GradeStudentsDTO> getAll();
}

