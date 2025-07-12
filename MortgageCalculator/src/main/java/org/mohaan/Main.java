package org.mohaan;

import java.util.*;

import rx.Observable;
import rx.Subscriber;

import static java.util.stream.Collectors.toList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("\n Enter the loan amount: ");
//        double loanAmount = scanner.nextDouble();
//
//        System.out.print("\n Enter the interest rate: ");
//        double interest = scanner.nextDouble();
//
//        System.out.print("\n Enter the number of years of installment: ");
//        int installments = scanner.nextInt() * 12;
//
//        double monthlyInterestRate = interest / 1200;
//        System.out.println(monthlyInterestRate);
//
//        double numeratorPartial = Math.pow((1 + monthlyInterestRate), installments);
//        System.out.println(numeratorPartial);
//
//        double monthlyInstallmentFee = (loanAmount *  (monthlyInterestRate * numeratorPartial)) / (numeratorPartial - 1 );
//
//        System.out.println("\n Your monthly installment fee is " + monthlyInstallmentFee);

        var symbols = Arrays.asList("AAPL", "MSFT", "INTC", "FRSH");

        Observable<StockInfo> feed = StockServer.getFeed(symbols);

        feed.subscribe(System.out::println);

        System.out.println("Done");
    }
}


