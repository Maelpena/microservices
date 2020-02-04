package com.jsonplaceholder.Gateway.entities;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Grade {

    private Integer grade_id;
    private String title;
    private Integer year;
}
