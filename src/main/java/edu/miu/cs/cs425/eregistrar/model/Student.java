package edu.miu.cs.cs425.eregistrar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(unique = true)
    private String studentNumber;

    @Column(nullable = false)
    String FirstName;

    private String MiddleName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private double cgpa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    private String  isInternational;





}
