package com.codewithjarence.exercises;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;
    final static Scanner SCANNER = new Scanner(System.in);
    final static NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(Locale.US);
    static void main() {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1_000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1,30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        printMortgage(mortgage);

        printPaymentSchedule(principal, annualInterest, years);
    }

    private static double readNumber(String prompt, int min, int max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = SCANNER.nextDouble();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
    }

    private static double calculateMortgage(int principal, float annualInterest, byte years) {
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private static void printMortgage(double mortgage) {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-----------------");
        String mortgageFormatted = CURRENCY.format(mortgage);
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }

    private static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");

        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(CURRENCY.format(balance));
        }
    }
}
