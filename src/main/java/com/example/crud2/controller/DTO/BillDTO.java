package com.example.crud2.controller.DTO;

import com.example.crud2.entity.Bill;

import javax.persistence.Column;
import java.math.BigDecimal;

public class BillDTO {

    private Long billId;

    private BigDecimal amount;

    public BillDTO(Long billId, BigDecimal amount) {
        this.billId = billId;
        this.amount = amount;
    }

    public BillDTO(Bill bill) {
        this.billId = bill.getBillId();
        this.amount = bill.getAmount();
    }

    public BillDTO() {}

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
