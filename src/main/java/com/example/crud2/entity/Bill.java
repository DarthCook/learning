package com.example.crud2.entity;

import com.example.crud2.controller.DTO.BillDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "billId")
    private Long billId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public Bill(BigDecimal amount) {
        this.amount = amount;
    }

    public Bill(BillDTO billDTO) {
        this.billId = billDTO.getBillId();
        this.amount = billDTO.getAmount();

    }
    public Bill() {

    }



    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
