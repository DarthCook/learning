package com.example.crud2.controller.DTO;

import com.example.crud2.entity.Bill;
import com.example.crud2.entity.User;
import com.example.crud2.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private UserRepository userRepository;

    private Long id;

    private String name;

    private String email;

    private List<BillDTO> bills;


    public UserDTO(Long id, String name, String email, List<BillDTO> bills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.bills = user.getBills().stream()
                .map(BillDTO::new).collect(Collectors.toList());
    }
    public UserDTO() {
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<BillDTO> getBills() {
        return bills;
    }

    public void setBills(List<BillDTO> bills) {
        this.bills = bills;
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
