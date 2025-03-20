package com.byui.studentstaffcommunication.repository;

import com.byui.studentstaffcommunication.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> getAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
