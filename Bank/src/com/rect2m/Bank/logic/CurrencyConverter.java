package com.rect2m.Bank.logic;

import com.rect2m.Bank.model.Currency;

public class CurrencyConverter {
  private static final double USD_TO_UAH_RATE = 37.0;
  private static final double EUR_TO_UAH_RATE = 40.0;

  public static double convert(double amount, Currency fromCurrency, Currency toCurrency) {
    if (fromCurrency == null || toCurrency == null) {
      return amount;
    }

    if (fromCurrency.equals(Currency.UAH) && toCurrency.equals(Currency.USD)) {
      return amount / USD_TO_UAH_RATE;
    } else if (fromCurrency.equals(Currency.UAH) && toCurrency.equals(Currency.EUR)) {
      return amount / EUR_TO_UAH_RATE;
    } else if (fromCurrency.equals(Currency.USD) && toCurrency.equals(Currency.UAH)) {
      return amount * USD_TO_UAH_RATE;
    } else if (fromCurrency.equals(Currency.EUR) && toCurrency.equals(Currency.UAH)) {
      return amount * EUR_TO_UAH_RATE;
    } else if (fromCurrency.equals(Currency.USD) && toCurrency.equals(Currency.EUR)) {
      return amount * (USD_TO_UAH_RATE / EUR_TO_UAH_RATE);
    } else if (fromCurrency.equals(Currency.EUR) && toCurrency.equals(Currency.USD)) {
      return amount * (EUR_TO_UAH_RATE / USD_TO_UAH_RATE);
    } else {
      return amount;
    }
  }
}

