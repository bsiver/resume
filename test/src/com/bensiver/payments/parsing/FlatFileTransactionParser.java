package com.bensiver.payments.parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bensiver.payments.models.Transaction;
import com.bensiver.payments.models.Transaction.TransactionBuilder;
import com.bensiver.payments.models.Transaction.TransactionType;

/**
 * Implementation of {@link TransactionParser} that parses space delimited data from a text file into a list of {@link Transaction}.
 *
 */
public class FlatFileTransactionParser implements TransactionParser {

  private static final String DELIMITER = " ";
  private static final int NUM_FIELDS_ADD = 3;
  private static final int NUM_FIELDS_TRANSACTION = 4;
  private File input;

  public FlatFileTransactionParser(File input) {
    this.input = input;
  }

  @Override
  public List<Transaction> parse() {
    List<Transaction> transactions = new ArrayList<Transaction>();
    try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String [] lineData = line.split(DELIMITER);
        if (lineData.length == NUM_FIELDS_ADD || lineData.length == NUM_FIELDS_TRANSACTION) {
          transactions.add(lineDataToTransaction(lineData));
        }
        else {
          System.err.println(String.format("Error parsing line '%s', skipping for now.", line));
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("There was an error while attempting to read the provided file, exiting.");
    }
    return transactions;
  }

  private Transaction lineDataToTransaction(String[] lineData) {
    String transactionText = lineData[0].toUpperCase();
    TransactionType transactionType = TransactionType.valueOf(transactionText);
    String name = lineData[1];
    String cardNumber = lineData[2];
    String amount = lineData.length == NUM_FIELDS_TRANSACTION ? lineData[3] : null;
    return new TransactionBuilder().name(name).cardNumber(cardNumber).type(transactionType).amount(amount).build();
  }
}
