package com.michaelgorohov.checkoutapp;

public class Item {


  private String name;
  private String price;
  private int count;

  public Item(String name, String price) {
    this.name = name;
    this.price = price;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
