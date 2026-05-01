package com.codewithmosh;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(mortgageCalculator mortgageCalculator) {
        double mortgage = mortgageCalculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(mortgageCalculator mortgageCalculator, byte MONTHS_IN_YEAR, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = mortgageCalculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
