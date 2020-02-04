package com.jsonplaceholder.Gateway.clients;

import com.jsonplaceholder.Gateway.entities.Student;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name ="StudentClient")

public interface IStudentClient {
    @RequestLine("GET /")
    List<Student> getAll();
}


