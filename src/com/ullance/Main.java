package com.ullance;

import java.text.NumberFormat;
import java.util.Scanner;

// This program calculates monthly mortgage payment
public class Main {
    public static void main(String[] args){
        // Final variables
        final byte ANNUAL_MONTHS = 12;
        final byte PERCENT = 100;

        // Input variables
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Annual Interest Rate: ");
        float monthlyInterestRate = (scanner.nextFloat()/PERCENT)/ANNUAL_MONTHS; // annual interest rate turned into monthly

        System.out.print("Years: ");
        int months = scanner.nextInt() * ANNUAL_MONTHS; // years turned into months

        // Math hehe
        double mortgage = principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months))/(Math.pow(1 + monthlyInterestRate, months) - 1));
        String currencyMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        // Final answer yippee
        System.out.println("Mortgage: " + currencyMortgage);
        scanner.close();
    }
}