package com.codewithmosh;

public class MortgageCalculator {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.annualInterest = annualInterest;
        this.principal = principal;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterest / PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateBalance(
            short numberOfPaymentsMade
    ) {
        float monthlyInterest = annualInterest / PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = years * Main.MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
