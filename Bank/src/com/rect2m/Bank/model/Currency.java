package com.rect2m.Bank.model;

public enum Currency {
  UAH("UAH", "1"),
  USD("USD", "2"),
  EUR("EUR", "3");
  
  private final String name;
  private final String code;
  
  Currency(String name, String code) {
    this.name = name;
    this.code = code;
  }
  
  public String getName() {
    return name;
  }
  
  public String getCode() {
    return code;
  }
  public static Currency getCurrencyByCode(String code) {
    for (Currency currency : values()) {
      if (currency.getCode().equalsIgnoreCase(code)) {
        return currency;
      }
    }
    return null;
  }
}