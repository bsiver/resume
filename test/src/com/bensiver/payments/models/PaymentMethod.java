package com.bensiver.payments.models;

/**
 * Represents a form of payment to be used for a purchase.
 *
 */
public interface PaymentMethod {

  /**
   * Makes a payment of the specified amount.
   *
   * @param amount The amount to be paid.
   */
  public void pay(int amount);

}
