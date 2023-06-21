package com.loan.talia.service;

import com.loan.talia.model.Loan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LoanServiceImplementation implements LoanService{

    List<Loan> loans = new ArrayList<>();
    @Override
    public Loan save(Loan loan) {
        if(loan.getLoanId() == null) {
            String loanId = UUID.randomUUID().toString();
            String customerId = UUID.randomUUID().toString();
            loan.setLoanId(loanId);
            loan.setCustomerId(customerId);
        }

        loans.add(loan);
        return loan;
    }

    @Override
    public List<Loan> getAllLoans() {
        return loans;
    }

    @Override
    public Loan getLoanBYId(String id) {

        return loans.stream()
                .filter(loanFilter -> loanFilter.getLoanId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No loan found with the id " + id));
    }

    @Override
    public Loan updateLoan(String id, Loan loan) {
        return null;
    }

    @Override
    public String deleteLoan(String id) {
        Loan loan =  loans.stream()
                .filter(loanFilter -> loanFilter.getStatus().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No loan found with the id" + id));

        return "Loan successfully deleted";
    }

    @Override
    public List<Loan> getLoanByStatus(String status) {
        List<Loan> loansByStatus = new ArrayList<>();

        for(Loan loan : loans) {
            if(loan.getStatus().equalsIgnoreCase(status)) {
                loansByStatus.add(loan);
            }
        }
        return loansByStatus;
    }


    @Override
    public Loan getLoanByIdAndStatus(String status, String id) {
        return loans.stream()
                .filter(newLoan -> newLoan.getStatus().equalsIgnoreCase(status))
                .filter(anotherLoan -> anotherLoan.getLoanId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No loan found with status " + status + " and id " + id));
    }

    @Override
    public List<Loan> getOverDueLoans() {
        List<Loan> overDueLoans = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for(Loan loan : loans) {
            if(LocalDate.parse(loan.getPaymentDate()).isAfter(currentDate)) {
                overDueLoans.add(loan);
            }
        }

        return overDueLoans;

    }

}
