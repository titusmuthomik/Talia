package com.loan.talia.controller;

import com.loan.talia.model.Loan;
import com.loan.talia.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan save(@RequestBody Loan loan){
        return loanService.save(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable String id) {
        return loanService.getLoanBYId(id);
    }

    @GetMapping("/status/{status}")
    public List<Loan> getLoansByStatus(@PathVariable String status) {
        return loanService.getLoanByStatus(status);
    }

    @GetMapping("/status/{status}/{id}")
    public Loan getBYIdAndStatus(@PathVariable String status, @PathVariable String id) {
        return loanService.getLoanByIdAndStatus(status, id);
    }
}
