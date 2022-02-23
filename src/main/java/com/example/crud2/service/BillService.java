package com.example.crud2.service;

import com.example.crud2.controller.DTO.BillDTO;
import com.example.crud2.entity.Bill;
import com.example.crud2.entity.User;
import com.example.crud2.repository.BillRepository;
import com.example.crud2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Bill addBill(BigDecimal amount) {
        Bill bill = new Bill(amount);
        billRepository.save(bill);
        return bill;
    }

    public void updateBill(Long id, BigDecimal amount) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        bill.setAmount(amount);
        billRepository.save(bill);
    }

    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    public void deleteBill(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        billRepository.delete(bill);
    }

    public Bill showUpdateForm(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        return bill;

    }
}
