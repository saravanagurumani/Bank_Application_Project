package com.example.BankApplication.loan.enumclass;

public enum LoanType {
    HOME(12.0),
    PERSONAL(11.0),
    EDUCATION(9.0),
    VEHICLE(10.0);

    private final double interestRate;


    LoanType(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
