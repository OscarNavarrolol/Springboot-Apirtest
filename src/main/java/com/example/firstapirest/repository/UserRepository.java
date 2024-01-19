package com.example.firstapirest.repository;

import com.example.firstapirest.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public abstract ArrayList<User> findByPriority(Integer priority);

}
