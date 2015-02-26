package com.bensiver.payments.models;


public class AddTransaction extends Transaction {

  private String cardNumber;
  private String limit;

  public static class AddTransactionBuilder {
    private AddTransaction transaction;

    public AddTransactionBuilder() {
      transaction = new AddTransaction();
    }

    public AddTransactionBuilder name(String name) {
      transaction.setName(name);
      return this;
    }

    public AddTransactionBuilder cardNumber(String cardNumber) {
      transaction.setCardNumber(cardNumber);
      return this;
    }

    public Transaction build() {
      return transaction;
    }

  }

}
