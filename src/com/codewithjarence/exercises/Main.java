package com.codewithjarence.exercises;

public class Main {
    static void main() {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1,30);

        var mortgageCalculator = new MortgageCalculator(principal, annualInterest, years);

        var mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }
}
