package com.codewithjarence.exercises;

public class MortgageReport {
    public static void printMortgage(double mortgage) {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-----------------");
        String mortgageFormatted = Main.CURRENCY.format(mortgage);
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");

        for (short month = 1; month <= years * Main.MONTHS_IN_YEAR; month++) {
            double balance = MortgageCalculator.calculateBalance(principal, annualInterest, years, month);
            System.out.println(Main.CURRENCY.format(balance));
        }
    }
}
