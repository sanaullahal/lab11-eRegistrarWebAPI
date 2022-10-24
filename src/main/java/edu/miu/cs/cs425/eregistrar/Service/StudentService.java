package edu.miu.cs.cs425.eregistrar.Service;

import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    public abstract Student addStudent(Student student);
    public abstract Iterable<Student> findAll();
    public abstract Student getStudentById(Integer studentId);
    public abstract void deleteStudentById(Integer studentId);


}
