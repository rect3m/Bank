package com.rect2m.Bank;

import static com.rect2m.Bank.ui.MenuHandler.startMenu;
import com.rect2m.Bank.model.Account;
import com.rect2m.Bank.logic.BankCard;
import com.rect2m.Bank.logic.AuthenticationService;
import com.rect2m.Bank.model.Person;
import com.rect2m.Bank.model.Product;


public class Main {

  public static void main(String[] args) {
    Person[] people = Person.personCreate();
    Account.createAccountsForPeople(people);

    Product[] product =Product.createProducts();
    Person authenticatedPerson = AuthenticationService.performAuthentication(people);
    BankCard card = BankCard.generateBankCardForAccount(authenticatedPerson.getAccount());

    if (authenticatedPerson != null) {
      System.out.println("Авторизація успішна");
      authenticatedPerson.displayInfo();
      card.displayInfo();
      startMenu(authenticatedPerson.getAccount(),card);
    } else {
      System.out.println("Невірне ім'я користувача або пароль.");
    }
  }
}