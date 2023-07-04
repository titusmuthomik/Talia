package com.loan.talia.service;

import com.loan.talia.entity.LoanEntity;
import com.loan.talia.exception.CustomException;
import com.loan.talia.repository.LoanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImplementation implements LoanService{

    @Autowired
    private LoanRepository loanRepository;
    @Override
    public LoanEntity save(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<LoanEntity> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public LoanEntity getLoanBYId(Long id) {


        return loanRepository.findById(id)
                .orElseThrow(() -> new CustomException("A Loan with id" + id + "could not be found in the database", "NOT_FOUND", 404));
    }

    @Override
    public LoanEntity updateLoan(Long id, LoanEntity updateLoan) {
        LoanEntity existingLoan = loanRepository.findById(id)
                .orElseThrow(() -> new CustomException("A Loan with id" + id + "could not be found in the database", "NOT_FOUND", 404));

        existingLoan.setPaymentDate(updateLoan.getPaymentDate());
        existingLoan.setAmount(updateLoan.getAmount());

        loanRepository.save(existingLoan);

        return existingLoan;
    }

    @Override
    public String deleteLoan(Long id) {
        loanRepository.deleteById(id);
        return "loan with id "+ id +" successfully deleted";
    }

    @Override
    public List<LoanEntity> getLoanByStatus(String status) {
        List<LoanEntity> loanEntityList = loanRepository.findAll();

        return loanEntityList.stream()
                .filter(loanEntity -> loanEntity.getStatus().equalsIgnoreCase(status))
                .map(loanFilter -> {
                    LoanEntity loan = new LoanEntity();
                    BeanUtils.copyProperties(loanFilter, loan);
                    return loan;
                })
                .collect(Collectors.toList());
    }

    @Override
    public LoanEntity getLoanByIdAndStatus(String status, Long id) {
        List<LoanEntity> loanEntityList = loanRepository.findAll();


        return loanEntityList.stream()
                .filter(loan -> loan.getStatus().equalsIgnoreCase(status))
                .filter(loanEntity -> loanEntity.getLoanId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CustomException("No loan of status " + status +" with the id of " + id, "NOT_FOUND", 404));

    }

    @Override
    public List<LoanEntity> getOverDueLoans() {
        return null;
    }


//    @Override
//    public Loan save(Loan loan) {
//        if(loan.getLoanId() == null) {
//            String loanId = UUID.randomUUID().toString();
//            String customerId = UUID.randomUUID().toString();
//            loan.setLoanId(loanId);
//            loan.setCustomerId(customerId);
//        }
//
//        loans.add(loan);
//        return loan;
//    }
//
//    @Override
//    public List<Loan> getAllLoans() {
//        return loans;
//    }
//
//    @Override
//    public Loan getLoanBYId(String id) {
//
//        return loans.stream()
//                .filter(loanFilter -> loanFilter.getLoanId().equalsIgnoreCase(id))
//                .findFirst()
//                .orElseThrow(() -> new NullPointerException("No loan found with the id " + id));
//    }
//
//    @Override
//    public Loan updateLoan(String id, Loan loan) {
//        return null;
//    }
//
//    @Override
//    public String deleteLoan(String id) {
//        Loan loan =  loans.stream()
//                .filter(loanFilter -> loanFilter.getStatus().equalsIgnoreCase(id))
//                .findFirst()
//                .orElseThrow(() -> new NullPointerException("No loan found with the id" + id));
//
//        return "Loan successfully deleted";
//    }
//
//    @Override
//    public List<Loan> getLoanByStatus(String status) {
//        List<Loan> loansByStatus = new ArrayList<>();
//
//        for(Loan loan : loans) {
//            if(loan.getStatus().equalsIgnoreCase(status)) {
//                loansByStatus.add(loan);
//            }
//        }
//        return loansByStatus;
//    }
//
//
//    @Override
//    public Loan getLoanByIdAndStatus(String status, String id) {
//        return loans.stream()
//                .filter(newLoan -> newLoan.getStatus().equalsIgnoreCase(status))
//                .filter(anotherLoan -> anotherLoan.getLoanId().equalsIgnoreCase(id))
//                .findFirst()
//                .orElseThrow(() -> new NullPointerException("No loan found with status " + status + " and id " + id));
//    }
//
//    @Override
//    public List<Loan> getOverDueLoans() {
//        List<Loan> overDueLoans = new ArrayList<>();
//        LocalDate currentDate = LocalDate.now();
//
//        for(Loan loan : loans) {
//            if(LocalDate.parse(loan.getPaymentDate()).isAfter(currentDate)) {
//                overDueLoans.add(loan);
//            }
//        }
//
//        return overDueLoans;
//
//    }

}
