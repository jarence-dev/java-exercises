package com.codewithjarence.exercises;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;
    final static NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(Locale.US);
    static void main() {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1,30);

        double mortgage = MortgageCalculator.calculateMortgage(principal, annualInterest, years);
        MortgageReport.printMortgage(mortgage);

        MortgageReport.printPaymentSchedule(principal, annualInterest, years);
    }

}
