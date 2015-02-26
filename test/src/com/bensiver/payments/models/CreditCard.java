package com.bensiver.payments.models;

import com.bensiver.payments.validation.Luhn10;

/**
 * A payment method that consists of a limit, balance, and cardholder.
 *
 * Payments are made by first checking if the requested payment amount is allowed based upon the card's current. If so, the balance is updated
 * accordingly. Any payment request that would result in a balance above the limit is ignored.
 *
 */
public class CreditCard implements PaymentMethod {

  private int cardNumber;
  private int balance;
  private int limit;
  private String cardHolder;

  @Override
  public void pay(int amount) {
    charge(amount);
  }

  public void charge(int amount) {
    int newBalance = balance + amount;
    if (newBalance < limit) {
      balance = newBalance;
    }
  }

  public void credit(int amount) {
    if (amount > 0) {
      balance -= amount;
    }
  }

  public boolean isValid() {
    return Luhn10.check(cardNumber);
  }

  public void setCardNumber(int cardNumber) {
    this.cardNumber = cardNumber;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }


  public static class CreditCardBuilder {
    private CreditCard card;

    public CreditCardBuilder() {
      card = new CreditCard();
    }

    public CreditCardBuilder cardNumber(int number) {
      card.setCardNumber(number);
      return this;
    }

    public CreditCardBuilder balance(int balance) {
      card.setBalance(balance);
      return this;
    }

    public CreditCardBuilder limit(int limit) {
      card.setLimit(limit);
      return this;
    }

    public CreditCardBuilder cardHolder(String cardHolder) {
      card.setCardHolder(cardHolder);
      return this;
    }

    public CreditCard build() {
      return card;
    }

  }

}
