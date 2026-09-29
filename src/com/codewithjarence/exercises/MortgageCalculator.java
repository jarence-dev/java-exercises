package com.codewithjarence.exercises;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;
    final static NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(Locale.US);
    static void main() {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1,30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        MortgageReport.printMortgage(mortgage);

        MortgageReport.printPaymentSchedule(principal, annualInterest, years);
    }

    private static double calculateMortgage(int principal, float annualInterest, byte years) {
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

}
