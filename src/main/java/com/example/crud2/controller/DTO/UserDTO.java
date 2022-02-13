package com.example.crud2.controller.DTO;

import com.example.crud2.entity.User;
import com.example.crud2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDTO {

    private UserRepository userRepository;

    private Long id;

    private String name;

    private String email;

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id ));
        user.setId(id);
    }
}
