package com.example.mycrud.controllers;

import com.example.mycrud.controllers.accountDTO.AccountDTO;
import com.example.mycrud.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO.getName(),
                accountDTO.getEmail(), accountDTO.getBill());
    }
}
