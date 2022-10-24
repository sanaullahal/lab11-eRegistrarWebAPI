package edu.miu.cs.cs425.eregistrar.Repository;


import edu.miu.cs.cs425.eregistrar.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

