package edu.miu.cs.cs425.eregistrar.Repository;


import edu.miu.cs.cs425.eregistrar.model.Role;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query(value = "select distinct r from Role r join r.users u where u.userId=:userId")
    List<Role> findRolesByUserId(Integer userId);

}
