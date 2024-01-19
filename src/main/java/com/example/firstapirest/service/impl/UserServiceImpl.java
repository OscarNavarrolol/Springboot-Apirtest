package com.example.firstapirest.service.impl;

import com.example.firstapirest.entity.User;
import com.example.firstapirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> getAll(){
        return (ArrayList<User>) userRepository.findAll();
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }


    public ArrayList<User> getByPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }


    public boolean deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


}
