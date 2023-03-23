package com.dto;

import java.util.Objects;

/**
 * Class for BankCard entity which contains fields and basic methods
 */
public class BankCard {
    private String number;
    private User user;

    public BankCard() {
    }

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Objects.equals(number, bankCard.number) && Objects.equals(user, bankCard.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
