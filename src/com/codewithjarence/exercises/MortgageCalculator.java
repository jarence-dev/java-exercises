package com.codewithjarence.exercises;

public class MortgageCalculator {
    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        double monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        double monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
