package com.serviceimpl.initializator;

import com.dto.BankCard;
import com.dto.Subscription;
import com.dto.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dto.BankCardType.CREDIT;

/**
 * Class for filling objects with values.
 */
public class EntityInitializer {

    /**
     * List for saving created subscriptions.
     */
    public static List<Subscription> subscriptions = subscriptionInitializer().collect(Collectors.toList());

    /**
     * Method for creating stream of subscriptions.
     *
     * @return stream of subscriptions.
     */
    public static Stream<Subscription> subscriptionInitializer() {
        return Stream.of(new Subscription(new BankCard("125", new User("Ilya",
                        "Efimchik",
                        LocalDate.of(2020, 1, 8))), LocalDate.of(2020, 1, 8)),
                new Subscription(new BankCard("401", new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8))),
                        LocalDate.of(2020, 1, 8)),
                new Subscription(new BankCard("505", new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8))),
                        LocalDate.of(2020, 1, 8)));
    }

    /**
     * Method for creating stream of user.
     *
     * @return stream of users.
     */
    public static Stream<User> userInitializer() {
        return Stream.of(new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8)),
                new User("Ilya", "Efimchik", LocalDate.of(2020, 10, 8)),
                new User("Sasha", "Efimchik", LocalDate.of(2020, 10, 8)),
                new User("Ilya", "Efimchik", LocalDate.of(2020, 10, 8)));
    }

    /**
     * Method for creating stream of bankCards
     *
     * @return stream of bankCards
     */
    public static Stream<BankCard> bankCardInitializator() {
        return Stream.of(new BankCard(CREDIT.toString(), new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8))),
                new BankCard(CREDIT.toString(), new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8))),
                new BankCard(CREDIT.toString(), new User("Ilya", "Efimchik", LocalDate.of(2020, 1, 8))));
    }
}
