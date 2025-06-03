package com.DSE.FinalProject.repository;
import com.DSE.FinalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findTopByOrderByIdDesc();
    List<User> findByRole(String role);
    Optional<User> findByEmailAndRole(String email, String role);


}
