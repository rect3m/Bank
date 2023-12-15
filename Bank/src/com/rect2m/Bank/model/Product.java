package com.rect2m.Bank.model;

public class Product {
  private String name;
  private String description;
  private double price;
  
  public Product(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }
  
  public String getName() {
    return name;
  }
  
  public double getPrice() {
    return price;
  }

  public static Product[] createProducts() {
    Product[] products = new Product[10];

    products[0] = new Product("Масло", "Селянське вершкове масло", 40.0);
    products[1] = new Product("Багет", "Французький багет", 25.0);
    products[2] = new Product("Ягоди", "Мікс ягід, 250 г", 60.0);
    products[3] = new Product("Цитруси", "Асорті цитрусових фруктів", 45.0);
    products[4] = new Product("Свинина", "Свіжа свинина", 90.0);
    products[5] = new Product("Брокколі", "Свіжий брокколі", 35.0);
    products[6] = new Product("Кавун", "Солодкий кавун", 25.0);
    products[7] = new Product("Чай", "Зелений чай, 50 г", 25.0);
    products[8] = new Product("Рис", "Довгозернистий рис, 1 кг", 30.0);
    products[9] = new Product("Моцарела", "Моцарела, 250 г", 60.0);

    return products;
  }
}
