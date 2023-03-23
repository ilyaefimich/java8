package com.bank.api;

import com.dto.BankCard;
import com.dto.BankCardType;
import com.dto.User;

/**
 * Interface for BankCard
 */
public interface BankInterface {
    /**
     * Method for creating BankCard
     *
     * @param bankCardType type of the bankCard
     * @param user         object of the User class
     * @return BankCard
     */
    BankCard createBankCard(BankCardType bankCardType, User user);

}
