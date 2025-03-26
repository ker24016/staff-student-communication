package com.byui.studentstaffcommunication.repository;

import com.byui.studentstaffcommunication.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    List<User> getAllByNameContainingIgnoreCase(String name, Pageable pageable);

}
