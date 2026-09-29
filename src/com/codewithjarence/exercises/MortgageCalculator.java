package com.codewithjarence.exercises;

public class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;

    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        return principal
                * (getMonthlyInterest() * Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        return principal
                * (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsMade))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private double getMonthlyInterest() {
        byte PERCENT = 100;
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
}
