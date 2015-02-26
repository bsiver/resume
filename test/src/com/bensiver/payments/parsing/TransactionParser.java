package com.bensiver.payments.parsing;

import java.util.List;

import com.bensiver.payments.models.CreditCard;
import com.bensiver.payments.models.Transaction;

/**
 * Base interface representing a method for parsing {@link CreditCard} related transactions from one of several types of data sources (flat file,
 * stdin, JSON, XML, etc.)
 *
 */
public interface TransactionParser {

  /**
   * @return List of {@link Transaction} objects parsed from the data source.
   */
  List<Transaction> parse();

}
