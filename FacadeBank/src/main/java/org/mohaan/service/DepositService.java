package org.mohaan.service;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class DepositService {
    public void deposit(String accountId, double money) {
        System.out.println(MessageFormat.format("Depositing the money {0} to the account {1}", accountId, money));
    }
}
