package com.bensiver.payments.application;

import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import com.bensiver.payments.parsing.FlatFileTransactionParser;
import com.bensiver.payments.parsing.TransactionParser;
import com.bensiver.payments.service.TransactionService;
import com.bensiver.payments.service.TransactionServiceImpl;

/**
 * Credit card transaction processor that reads transactions from a data source and produces a summary of the transactions.
 *
 */
public class Application {

  public static void main(String[] args) {
    TransactionService transactionService = new TransactionServiceImpl();

    File selectedFile = promptUserForFile();
    if (selectedFile != null) {
      TransactionParser parser = new FlatFileTransactionParser(selectedFile);
      parser.parse();
    }
    else {
      System.out.println("No input file was provided, exiting.");
    }
    System.exit(0);
  }

  private static File promptUserForFile() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    int result = fileChooser.showOpenDialog(new JDialog());
    if (result == JFileChooser.APPROVE_OPTION) {
      return fileChooser.getSelectedFile();
    }
    return null;
  }
}
