package com.main;

import com.bank.api.BankInterface;
import com.dto.BankCard;
import com.dto.User;
import com.impl.BankImpl;
import com.service.api.ServiceInterface;
import com.serviceimpl.ServiceImpl;

import java.time.LocalDate;

import static com.dto.BankCardType.CREDIT;

public class Main {

    public static void main(String[] args) {
        ServiceInterface service = new ServiceImpl();
        BankInterface bank = new BankImpl();
        BankCard bankCard = bank.createBankCard(CREDIT, service.getAllUsers().get(0));
        System.out.println("Created bankCard: " + bankCard);
        System.out.println("All users: " + service.getAllUsers().toString());
        service.subscribe(new BankCard(CREDIT.toString(), new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8))));
        System.out.println("Found subscription is: " + service.getSubscriptionByBankCardNumber("401"));
        System.out.println("Average age is:" + service.getAverageUsersAge());
        System.out.println(ServiceInterface.isPayableUser(new User("Ilya", "Efimchik", LocalDate.of(2020, 10, 8))));
        service.getAllSubscriptionsByCondition(subscription -> subscription.getStartDate().isAfter(LocalDate.of(2020, 1, 1)));
    }
}