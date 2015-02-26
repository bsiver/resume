package com.bensiver.payments.service;

import com.bensiver.payments.models.PaymentMethod;
import com.bensiver.payments.models.Transaction;

public interface TransactionService {

  public void addPaymentMethod(String name, PaymentMethod method);

  public String getSummary();

  public void processTransaction(Transaction transaction);

}
