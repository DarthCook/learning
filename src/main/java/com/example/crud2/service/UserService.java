package com.example.crud2.service;

import com.example.crud2.controller.DTO.BillDTO;
import com.example.crud2.entity.Bill;
import com.example.crud2.entity.User;
import com.example.crud2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(String name, String email, List<BillDTO> billsDTO) {
        List<Bill> bills = billsDTO.stream().map(Bill::new).collect(Collectors.toList());
        User user = new User(name, email, bills);
        userRepository.save(user);
        return user;
    }

    public void updateUser(Long id, String name, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        userRepository.delete(user);
    }

    public User showUpdateForm(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        return user;

    }
}
