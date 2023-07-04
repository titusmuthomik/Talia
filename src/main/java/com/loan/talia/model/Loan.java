package com.loan.talia.model;

public class Loan {
    private String loanId;
    private String status;
    private String customerId;
    private Double amount;
    private String disbursementDate;
    private String paymentDate;
    private String dueDate;



    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", status='" + status + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", disbursementDate='" + disbursementDate + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}
