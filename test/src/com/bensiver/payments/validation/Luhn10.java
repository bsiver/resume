package com.bensiver.payments.validation;

public class Luhn10 {

  public static final boolean check(int cardNumber) {
    String temp = Integer.toString(cardNumber);
    int[] digits = new int[temp.length()];
    for (int i = 0; i < temp.length(); i++) {
      digits[i] = Character.getNumericValue(temp.charAt(i));
    }

    int sum = 0;
    int length = digits.length;
    for (int i = 0; i < length; i++) {

      // get digits in reverse order
      int digit = digits[length - i - 1];

      // every 2nd number multiply with 2
      if (i % 2 == 1) {
        digit *= 2;
      }
      sum += digit > 9 ? digit - 9 : digit;
    }
    return sum % 10 == 0;
  }

}
