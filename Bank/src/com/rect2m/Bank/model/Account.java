package com.rect2m.Bank.model;

import com.rect2m.Bank.logic.BankCard;
import com.rect2m.Bank.logic.CurrencyConverter;
import java.util.ArrayList;
import java.util.List;

public class Account {
  private double balance;
  private Currency currency;
  private String accountNumber;
  private Person owner;
  private List<BankCard> associatedCards;
  
  // Конструктор для створення акаунту і прив'язки його до особи
  public Account(String accountNumber, Person owner) {
    this.accountNumber = accountNumber;
    this.owner = owner;
    this.associatedCards = new ArrayList<>();
  }
  
  public String getAccountNumber() {
    return accountNumber;
  }
  
  public List<BankCard> getAssociatedCards() {
    return associatedCards;
  }

  public double getBalance() {
    return balance;
  }
  
  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }
  
  public Currency getCurrency() {
    return currency;
  }
  
  public void setCurrency(Currency newCurrency) {
    this.currency = newCurrency;
  }

  public Person getOwner() {
    return owner;
  }
  
  public void displayInfo() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Owner: " + owner.getName());
    System.out.println("Balance: " + balance);
    System.out.println("Currency: " + currency.getName());
  }
  
  public static void refreshAccountBalance(BankCard bankCard) {
    Account account = bankCard.getLinkedAccount();  // Отримати акаунт, пов'язаний з карткою
    
    if (account != null) {
      account.setBalance(bankCard.getBalance());
      account.setCurrency(Currency.UAH); // Встановити новий баланс акаунту
    } else {
      System.out.println("Помилка: Картка не пов'язана з акаунтом.");
    }
  }
  
  public static void createAccountsForPeople(Person[] people) {
    for (Person person : people) {
      Account account = new Account("ACC" + person.getName().hashCode(), person);
      person.setAccount(account);
    }
  }
  
  public void changeCurrency(Currency newCurrency) {
    double currentBalance = getBalance();
    double newBalance = CurrencyConverter.convert(currentBalance, getCurrency(), newCurrency);
    setBalance(newBalance);
    setCurrency(newCurrency);
    System.out.println("Баланс та валюта картки оновлені.");
    displayInfo();
  }
}