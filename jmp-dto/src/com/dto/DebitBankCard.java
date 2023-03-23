package com.dto;

/**
 * Class for DebitBankCard entity which contains constructor and extends BankCard class
 */
public class DebitBankCard extends BankCard {

    public DebitBankCard(String number, User user) {
        super(number, user);
    }
}
