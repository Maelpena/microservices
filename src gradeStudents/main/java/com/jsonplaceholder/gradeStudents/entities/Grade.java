package com.jsonplaceholder.gradeStudents.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Generated;

@Data
public class Grade {
    public Integer getId() {
        return grade_id;
    }


    private Integer grade_id;
    private String title;
    private Integer year;
}
