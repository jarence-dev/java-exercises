package com.codewithjarence.exercises;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
    static void main() {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        var scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double mortgage = principal
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }
}
