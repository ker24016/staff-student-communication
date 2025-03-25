package com.byui.studentstaffcommunication.repository;

import com.byui.studentstaffcommunication.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllByNameContainingIgnoreCase(String name, Pageable pageable);

}
