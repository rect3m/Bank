package com.rect2m.Bank.logic;

import com.rect2m.Bank.model.Product;
import java.util.Scanner;

public interface ProductSells {
  public static void displayProductList(Product[] products) {
    System.out.println("Список продуктів:");
    for (int i = 0; i < products.length; i++) {
      System.out.println((i + 1) + ". " + products[i].getName() + " - " + products[i].getPrice() + " грн");
    }
  }
  
  public static void makePurchase(BankCard card, Product[] products) {
    Scanner scanner = new Scanner(System.in);
    
    displayProductList(products);
    System.out.print("Виберіть номер продукту для покупки (або 0 для виходу): ");
    int choice = scanner.nextInt();
    
    if (choice >= 1 && choice <= products.length) {
      Product selectedProduct = products[choice - 1];
      
      System.out.print("Введіть кількість продуктів: ");
      int quantity = scanner.nextInt();
      
      double totalPrice = selectedProduct.getPrice() * quantity;
      
      card.withdrawFromAccount(card, totalPrice);
      
      System.out.println("Ви успішно придбали " + quantity + " одиниць " + selectedProduct.getName() +
          " за " + totalPrice + " грн.");
      System.out.println("Залишок на картці: " + card.getBalance() + " грн.");
    } else if (choice == 0) {
      System.out.println("Покупка відмінена.");
    } else {
      System.out.println("Невірний вибір. Спробуйте ще раз.");
    }
  }
  
}
