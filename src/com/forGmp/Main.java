package com.forGmp;
import com.service.a
import com.dto.BankCard;
import com.dto.User;
import com.impl.BankImpl;
import com.serviceimpl.ServiceImpl;

import java.time.LocalDate;

import static com.dto.BankCardType.CREDIT;

/**
 * Main application class.
 */
public class Main {

    /**
     * Main method for testing.
     *
     * @param args String[] args
     */

    public static void main(String[] args) {
        IService service = new ServiceImpl();
        IBank bank = new BankImpl();
        BankCard bankCard=bank.createBankCard(CREDIT, service.getAllUsers().get(0));
        System.out.println(service.getAllUsers().toString());
        service.subscribe(bankCard);
        System.out.println(service.getSubscriptionByBankCardNumber("401"));
        System.out.println(service.getAverageUsersAge());
        System.out.println(IService.isPlayableUser(new User("Ilya", "Efimchik", LocalDate.of(2020, 10, 8))));
        service.getAllSubscriptionsByCondition(service.testPredicateAndComposition());
    }
}
