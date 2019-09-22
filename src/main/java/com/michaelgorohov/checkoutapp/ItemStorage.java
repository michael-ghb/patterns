package com.michaelgorohov.checkoutapp;

import java.util.HashMap;
import java.util.Map;

public class ItemStorage {

  Map<String, Item> storage = new HashMap<>();

  public ItemStorage() {
    addAllItems();
  }

  private void addAllItems() {
    addToStorage("Apple", "0.6");
    addToStorage("Orange", "0.25");
  }

  private void addToStorage(String name, String price) {
    storage.put(name, new Item(name, price));
  }

  public Item getItem(String name) {
    return storage.get(name);
  }
}
