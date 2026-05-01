package com.codewithmosh;

public class mortgageCalculator {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public void start() {
        principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        MortgageReport.printMortgage(this);
        MortgageReport.printPaymentSchedule(this, MONTHS_IN_YEAR, years);
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateBalance(
            short numberOfPaymentsMade
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
