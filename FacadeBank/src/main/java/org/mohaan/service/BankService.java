package org.mohaan.service;

import org.springframework.stereotype.Component;

@Component
public class BankService {
    private final AccountService accountService;
    private final TransferService transferService;
    private final DepositService depositService;

    public BankService (AccountService accountService, TransferService transferService, DepositService depositService) {
        this.accountService = accountService;
        this.transferService = transferService;
        this.depositService = depositService;
    }

    public void getAccountDetails(String accountId) {
        accountService.getAccountDetails(accountId);
    }

    public void transferMoney(String fromAccountId, String toAccountId, double money) {
        transferService.transferMoney(fromAccountId, toAccountId, money);
    }

    public void depositMoney(String accountId, double money) {
        depositService.deposit(accountId, money);
    }
}
