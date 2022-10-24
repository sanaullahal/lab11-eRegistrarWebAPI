package edu.miu.cs.cs425.eregistrar;

import edu.miu.cs.cs425.eregistrar.Service.StudentService;
import edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ERegistrarApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }
    StudentService studentService;

    public ERegistrarApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1=new Student(1,"000-61-0001"," Anna","m","Smith",3.78, LocalDate.of(2019,5,12),"yes");
        Student s2=new Student(2,"000-61-0002"," Anna","m","Smith",3.78, LocalDate.of(2019,5,12),"yes");
        Student s3=new Student(3,"000-61-0003"," Anna","m","Smith",3.78, LocalDate.of(2019,5,12),"yes");
        Student s4=new Student(4,"000-61-0004"," Anna","m","Smith",3.78, LocalDate.of(2019,5,12),"yes");
        Student[] students={s1,s2,s3,s4};
//        for (Student s:students){
//            studentService.addStudent(s);
//        }
    }
}
