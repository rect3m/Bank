package com.rect2m.Bank.logic;

import com.rect2m.Bank.model.Person;
import java.util.Scanner;

public class AuthenticationService {
  public static Person performAuthentication(Person[] people) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Введіть ім'я користувача: ");
    String enteredUsername = scanner.nextLine();
    
    System.out.print("Введіть пароль: ");
    String enteredPassword = scanner.nextLine();
    
    for (Person person : people) {
      if (person.authenticate(enteredUsername, enteredPassword)) {
        return person;
      }
    }
    
    return null;
  }
}
