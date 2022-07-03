package com.example.demo.entitiy;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@Entity(name = "book")
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_name")
    private String book_name;

    @Column(name = "student_id", unique = true)
    private  Long student_id;

    @Column(name = "create_at")
    private Date create_at;
}
