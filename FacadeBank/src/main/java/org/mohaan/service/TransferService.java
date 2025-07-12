package org.mohaan.service;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class TransferService {
    public void transferMoney(String fromAccountId, String toAccountId, double money) {
        System.out.println(MessageFormat.format("Transferring money Rs.{0} from {1} to {2}", fromAccountId, toAccountId, money));
    }
}
