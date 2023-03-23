package com.impl;

import com.bank.api.BankInterface;
import com.dto.*;

/**
 * Implementation of the Bank Interface
 */
public class BankImpl implements BankInterface {

    @Override
    public BankCard createBankCard(BankCardType bankCardType, User user) {
        BankCard toReturn;
        switch (bankCardType) {
            case CREDIT:
                toReturn = new CreditBankCard(bankCardType.toString(), user);
                break;
            case DEBIT:
                toReturn = new DebitBankCard(bankCardType.toString(), user);
                break;
            default:
                throw new IllegalArgumentException("Wrong bank card type:" + bankCardType);
        }
        return toReturn;
    }
}
