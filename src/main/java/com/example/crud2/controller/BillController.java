package com.example.crud2.controller;

import com.example.crud2.controller.DTO.BillDTO;
import com.example.crud2.controller.DTO.UserDTO;
import com.example.crud2.entity.Bill;
import com.example.crud2.entity.User;
import com.example.crud2.service.BillService;
import com.example.crud2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
public class BillController {

    @Autowired
    private BillService billService;

//    @GetMapping("/signup")
//    public String showSignUpFrom(User user) {
//        return "adduser";
//    }

    @PostMapping("/addbill")
    public String addBill(@ModelAttribute("bill") BillDTO billDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "adduser";
        }

        billService.addBill(billDTO.getAmount());
        return "redirect:/index";
    }

    @GetMapping("/indexbill")
    public String showUserList(Model model) {
        model.addAttribute("bills", billService.findAllBills());
        return "index";
    }

    @GetMapping("/edit_bill/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Bill bill = billService.showUpdateForm(id);
        model.addAttribute("bill", bill);
        return "updateuser";
    }

    @PostMapping("/update_bill/{id}")
    public String updateBill(@PathVariable("id") Long id, @ModelAttribute("bill") BillDTO billDTO, BindingResult result, Model model) {
        if(result.hasErrors()) {
            billDTO.setBillId(id);
            return "updateuser";
        }

        billService.updateBill(id, billDTO.getAmount());
        return "redirect:/index";
    }

    @GetMapping("/delete_bill/{id}")
    public String deleteBill(@PathVariable("id") Long id) {
        billService.deleteBill(id);
        return "redirect:/index";
    }

}
