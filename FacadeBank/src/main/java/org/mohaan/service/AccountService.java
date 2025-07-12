package org.mohaan.service;

import org.springframework.stereotype.Component;

@Component
public class AccountService {
    public void getAccountDetails(String accountId) {
        System.out.println("The account details for account id " + accountId);
    }
}
