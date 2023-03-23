package com.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class for Subscription entity which contains fields and basic methods
 */
public class Subscription {
    private BankCard bankCard;
    private LocalDate startDate;

    public Subscription(BankCard bankCard, LocalDate startDate) {
        this.bankCard = bankCard;
        this.startDate = startDate;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(bankCard, that.bankCard) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankCard, startDate);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "bankCard=" + bankCard +
                ", startDate=" + startDate +
                '}';
    }
}
