package edu.miu.cs.cs425.eregistrar.Service.Impl;

import edu.miu.cs.cs425.eregistrar.Repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.Service.StudentService;
import edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);

    }
}
