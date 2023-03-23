package com.serviceimpl;

import com.dto.BankCard;
import com.dto.Subscription;
import com.dto.User;
import com.service.api.ServiceInterface;
import com.serviceimpl.exception.NullValueException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.serviceimpl.initializator.EntityInitializer.*;

/**
 * Class for the implementation of IService interface
 */
public class ServiceImpl implements ServiceInterface {

    public ServiceImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return userInitializer().collect(Collectors.toList());
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate) {
        List<Subscription> subscriptions = subscriptionInitializer().collect(Collectors.toList());
        subscriptions.stream()
                .filter(subscriptionPredicate)
                .forEach(System.out::println);
        return subscriptions;
    }

    @Override
    public void subscribe(BankCard bankCard) {
        Subscription subscription = new Subscription(bankCard, LocalDate.now());
        subscriptions.add(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) {
        Stream<Subscription> subscriptionStream = subscriptionInitializer();
        System.out.println(subscriptionStream);
        return Optional
                .ofNullable(subscriptionStream
                        .filter(subscription -> number.equals(subscription.getBankCard().getNumber()
                        ))
                        .findAny()
                        .orElseThrow(() -> new NullValueException("Nothing found...")));
    }
}

