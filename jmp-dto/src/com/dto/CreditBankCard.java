package com.dto;

/**
 * Class for CreditBankCard entity which contains constructor and extends BankCard class
 */
public class CreditBankCard extends BankCard {

    public CreditBankCard(String number, User user) {
        super(number, user);
    }
}
