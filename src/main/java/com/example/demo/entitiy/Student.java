package com.example.demo.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "student")
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email", unique = true)
    private  String email;
//حولت نوع الايميل الى سترنق لانه يرفض بالداتابيس
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date create_at = new Date(System.currentTimeMillis());

    public Student(String first_name, String last_name, String email, Date create_at) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.create_at = create_at;
    }

}
//update