package com.codewithjarence.exercises;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private final MortgageCalculator mortgageCalculator;
    private final NumberFormat CURRENCY;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        CURRENCY = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void printMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        String mortgageFormatted = CURRENCY.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-----------------");
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (double balance: mortgageCalculator.getRemainingBalances()) {
            System.out.println(CURRENCY.format(balance));
        }
    }
}
