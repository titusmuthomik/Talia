package com.loan.talia.service;

import com.loan.talia.entity.LoanEntity;

import java.util.List;

public interface LoanService {
    LoanEntity save(LoanEntity loan);
    List<LoanEntity> getAllLoans();

    LoanEntity getLoanBYId(Long id);
    LoanEntity updateLoan(Long id, LoanEntity loan);

    String deleteLoan(Long id);

    List<LoanEntity> getLoanByStatus(String status);

    LoanEntity getLoanByIdAndStatus(String status, Long id);

    List<LoanEntity> getOverDueLoans();

}
