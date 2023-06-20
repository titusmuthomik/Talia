package com.loan.talia.service;

import com.loan.talia.model.Loan;

import java.util.List;

public interface LoanService {
    Loan save(Loan loan);
    List<Loan> getAllLoans();

    Loan getLoanBYId(String id);
    Loan updateLoan(String id, Loan loan);

    String deleteLoan(String id);

    List<Loan> getLoanByStatus(String status);

    Loan getLoanByIdAndStatus(String status, String id);

    List<Loan> getOverDueLoans();

}
