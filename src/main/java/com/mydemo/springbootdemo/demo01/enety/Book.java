package com.mydemo.springbootdemo.demo01.enety;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Book {

    @Id
    private Long id;
    private String name;
    private Date date;
    private Double price;
}
