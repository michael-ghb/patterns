package com.michaelgorohov.checkoutapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutApp {

  ItemStorage itemStorage = new ItemStorage();

  public BigDecimal checkout(List<String> inputList, Map<String, Offer> offers) {

    BigDecimal result = new BigDecimal("0");


    Map<String, Integer> itemCount = new HashMap<>();

    for (String s : inputList) {
      if (itemCount.containsKey(s)) {
        itemCount.put(s, itemCount.get(s) + 1);
      } else {
        itemCount.put(s, 1);
      }
    }

    List<Item> items = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
      String key = entry.getKey();
      Item item = itemStorage.getItem(key);
      if (item == null) {
        System.out.println("Item " + key + " is not available");
        continue;
      }
      item.setCount(entry.getValue());

      if (offers.containsKey(key)) {
        Offer offer = offers.get(key);
        offer.apply(item);
      }

      items.add(item);
    }



    for (Item item : items) {
      BigDecimal itemCost = countItemCost(item);
      result = result.add(itemCost);
    }

    return result;
  }

  private BigDecimal countItemCost(Item item){
    BigDecimal price = new BigDecimal(item.getPrice());
    BigDecimal count = new BigDecimal(item.getCount());
    return price.multiply(count);
  }




  public static void main(String[] args) {

    List<String> list = new ArrayList<>(Arrays.asList(new String[] {"Apple", "Apple", "Orange", "Apple"}));
    List<String> list2 = new ArrayList<>(Arrays.asList(new String[] {"Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "gjhol"}));


    CheckoutApp checkoutApp2 = new CheckoutApp();
    Map<String, Offer> offers = new HashMap<>();
    offers.put("Apple", new NForMOffer(2,1));
    offers.put("Orange", new NForMOffer(3,2));



    BigDecimal result1 = checkoutApp2.checkout(list, offers);
    System.out.println("RESULT_1 = " + result1.toString());

    BigDecimal result2 = checkoutApp2.checkout(list2, offers);
    System.out.println("RESULT_2 = " + result2.toString());

  }

}
