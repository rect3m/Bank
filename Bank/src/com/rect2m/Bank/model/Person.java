package com.rect2m.Bank.model;

import com.rect2m.Bank.logic.BankCard;
import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private String username;
  private String password;
  private Account account;  // Обліковий запис (може бути null)
  private List<BankCard> bankCards;
  
  public Person(String name, String username, String password) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.bankCards = new ArrayList<>();
  }
  
  public String getName() {
    return name;
  }
  
  public Account getAccount() {
    return account;
  }
  
  public void setAccount(Account account) {
    this.account = account;
  }
  
  public void displayInfo() {
    System.out.println("Ім'я: " + name);
    System.out.println("Ім'я користувача: " + username);
    
    if (account != null) {
      System.out.println("Номер акаунту: " + account.getAccountNumber());
      
      
      if (account.getOwner() == this) {
        System.out.println("Ви є власником цього аккаунту.");
      } else {
        System.out.println("Ви довірений користувач цього облікового запису.");
      }
      
      List<BankCard> cards = account.getAssociatedCards();
      for (BankCard card : cards) {
        System.out.println("Номер карти: " + card.getCardNumber());
      }
    } else {
      System.out.println("Інформація про аккаунт відсутня.");
    }
  }
  public boolean authenticate(String enteredUsername, String enteredPassword) {
    return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
  }
  
  public static Person[] personCreate() {
    Person[] people = new Person[5];
    
    people[0] = new Person("Василь", "Vasya28", "Vpass");
    people[1] = new Person("Микола", "Kolia97", "passK");
    people[2] = new Person("Євген", "Zhenia54", "paZss");
    people[3] = new Person("Дмитро", "Dima47", "password");
    people[4] = new Person("Аліна", "Alina02", "pAss");
    
    return people;
  }
}