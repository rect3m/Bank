package com.rect2m.Bank.logic;
import static com.rect2m.Bank.model.Account.refreshAccountBalance;

import com.rect2m.Bank.model.Account;
import com.rect2m.Bank.model.Currency;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankCard {
  private String cardNumber;
  private double balance;
  private Account linkedAccount;
  
  public Account getLinkedAccount() {
    return linkedAccount;
  }
  public void linkToAccount(Account account) {
    this.linkedAccount = account;
  }
  
  public BankCard(String cardNumber,Account linkedAccount,double balance) {
    this.cardNumber = cardNumber;
    this.linkedAccount=linkedAccount;
    this.balance = balance;
  }
  
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  public String getCardNumber() {
    return cardNumber;
  }
  
  public double getBalance() {
    return balance;
  }
  
  // Метод для зняття грошей з облікового запису через картку
  public void withdrawFromAccount(BankCard card, double amount) {
    if (card.getBalance() >= amount) {
      card.setBalance(card.getBalance() - amount);
    }
    else {
      System.out.println("На карті не вистачає коштів");
    }
  }
  
  public void displayInfo() {
    System.out.println("Номер карти: " + cardNumber);
    System.out.println("Баланс карти: " + balance);
    System.out.println("Початкова валюта: " + Currency.UAH);
  }
  public static BankCard generateBankCardForAccount(Account account) {
    Random random = new Random();
    String cardNumber = generateRandomCardNumber();
    double randomBalance =(double) random.nextInt(10000,100000);
    
    BankCard card = new BankCard(cardNumber, account, randomBalance);
    List<BankCard> cards= new ArrayList<>();
    cards.add(card);
    refreshAccountBalance(card);
    return card;
  }
  
  private static String generateRandomCardNumber() {
    StringBuilder cardNumber = new StringBuilder();
    Random random = new Random();
    
    for (int i = 0; i < 16; i++) {
      int digit = random.nextInt(10);
      cardNumber.append(digit);
    }
    
    return cardNumber.toString();
  }
  public interface CardDisplay {
     void displayCard(BankCard card);
  }
}