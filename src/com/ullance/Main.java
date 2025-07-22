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
        double principal = 0;
        float monthlyInterestRate = 0;
        int months = 0;

        // Grabbing input
        do {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextDouble();
            if (principal < 1_000 || principal > 1_000_000){
                System.out.println("Enter a number between 1,000 and 1,000,000.");
            }
        } while (principal < 1_000 || principal > 1_000_000);

        do {
            System.out.print("Annual Interest Rate: ");
            monthlyInterestRate = (scanner.nextFloat());
            if (monthlyInterestRate <= 0 || monthlyInterestRate > 30){
                System.out.println("Enter a value greater than 0 and less than or equal 30.");
            }
        } while (monthlyInterestRate <= 0 || monthlyInterestRate > 30);
        monthlyInterestRate = (monthlyInterestRate /PERCENT)/ANNUAL_MONTHS; // annual interest rate turned into monthly

        do {
            System.out.print("Period (Years): ");
            months = scanner.nextInt();
            if (months < 1 || months > 30){
                System.out.println("Enter a value between 1 and 30.");
            }
        } while (months < 1 || months > 30);
        months = months  * ANNUAL_MONTHS; // years turned into months
        
        // Math hehe
        double mortgage = principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months))/(Math.pow(1 + monthlyInterestRate, months) - 1));
        String currencyMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        // Final answer yippee
        System.out.println("Mortgage: " + currencyMortgage);
        scanner.close();
    }
}