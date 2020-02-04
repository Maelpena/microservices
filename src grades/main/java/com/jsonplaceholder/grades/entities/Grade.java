package com.jsonplaceholder.grades.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Grade {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getGrade_id() {
        return id;
    }

    public void setGrade_id(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer year;


}
