package com.bensiver.payments.models;


/**
 * Abstract object representing a transaction that can occur during the processing of credit card statements.
 *
 */
public abstract class Transaction {

  private String name;
  private String cardNumber;

  public String getName() {
    return name;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

}
