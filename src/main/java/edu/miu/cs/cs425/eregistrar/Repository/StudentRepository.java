package edu.miu.cs.cs425.eregistrar.Repository;

import edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
