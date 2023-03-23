package com.service.api;

import com.dto.BankCard;
import com.dto.Subscription;
import com.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Service Interface which contains different methods with different entities.
 */
public interface ServiceInterface {
    /**
     * Constant for isPlayableUser() method
     */
    int yearLimit = 18;

    /**
     * Static method for Service Interface which returns true, if the user is over 18 years old.
     *
     * @param user object of the User class.
     * @return true or false.
     */
    static boolean isPayableUser(User user) {
        LocalDate birthday = user.getBirthday();
        LocalDate now = LocalDate.now();
        double yearsOld = ChronoUnit.YEARS.between(birthday, now);
        return yearsOld > yearLimit;
    }

    /**
     * Method for creating new Subscription.
     *
     * @param bankCard object of the BankCard class.
     */
    void subscribe(BankCard bankCard);

    /**
     * Method for getting subscription based on the provided number of the BankCard.
     *
     * @param number BankCard number.
     * @return Found Optional subscription.
     */
    Optional<Subscription> getSubscriptionByBankCardNumber(String number);

    /**
     * Method for getting all users.
     *
     * @return list of the users.
     */
    List<User> getAllUsers();

    /**
     * Method for getting an average age of the users.
     *
     * @return average age.
     */
    default double getAverageUsersAge() {
        var userList = new ArrayList<>(getAllUsers());
        var unmodifiableList = Collections.unmodifiableList(userList);
        List<Double> list = new ArrayList<>();
        for (User users : unmodifiableList) {
            LocalDate birthday = users.getBirthday();
            LocalDate now = LocalDate.now();
            double yearsOld = ChronoUnit.YEARS.between(birthday, now);
            list.add(yearsOld);
        }
        return list.stream()
                .mapToDouble(a -> a)
                .average().orElse(0);
    }

    /**
     * Method for getting all FILTERED BY CONDITION (START DATE) subscription.
     *
     * @param subscriptionPredicate subscription predicate for date filtration.
     * @return filtered subscription.
     */
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate);

}
