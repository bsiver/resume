package com.bensiver.payments.service;

import java.util.HashMap;
import java.util.Map;

import com.bensiver.payments.models.PaymentMethod;
import com.bensiver.payments.models.Transaction;

public class TransactionServiceImpl implements TransactionService {

  private static String SUMMARY_FORMAT = "%s: %s";

  Map<String, PaymentMethod> userToPaymentMethod;

  public TransactionServiceImpl() {
    userToPaymentMethod = new HashMap<String, PaymentMethod>();
  }


  @Override
  public void addPaymentMethod(String name, PaymentMethod paymentMethod) {
    userToPaymentMethod.put(name, paymentMethod);
  }

  @Override
  public void processTransaction(Transaction transaction) {

  };

  @Override
  public String getSummary() {
    StringBuilder summary = new StringBuilder();
    for (String user: userToPaymentMethod.keySet()) {
      String balance = userToPaymentMethod.get(user).toString();
      summary.append(String.format(SUMMARY_FORMAT, user, balance));
      summary.append(System.lineSeparator());
    }
    return summary.toString();
  }

}
