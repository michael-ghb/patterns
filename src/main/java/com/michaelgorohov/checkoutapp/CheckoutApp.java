package com.michaelgorohov.checkoutapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutApp {

  private final String apple  = "Apple";
  private final String orange  = "Orange";

  private String applePrice = "0.6";
  private String orangePrice = "0.25";

  public BigDecimal checkout(List<String> inputList) {

    int appleCount = 0;
    int orangeCount = 0;
    BigDecimal result;



    for (String s : inputList) {
      switch (s) {
        case apple :
          appleCount++;
          break;
        case orange:
          orangeCount++;
          break;
        default:
          break;
      }
    }

    BigDecimal aPrice = new BigDecimal(applePrice);
    BigDecimal oPrice = new BigDecimal(orangePrice);

    BigDecimal aCount = new BigDecimal(appleCount);
    BigDecimal oCount = new BigDecimal(orangeCount);

    result = aPrice.multiply(aCount).add(oPrice.multiply(oCount));

    return result;
  }

  public static void main(String[] args) {

    List<String> list = new ArrayList<>(Arrays.asList(new String[] {"Apple", "Apple", "Orange", "Apple"}));
    CheckoutApp checkoutApp = new CheckoutApp();

    BigDecimal result1 = checkoutApp.checkout(list);
    System.out.println("RESULT_1 = " + result1.toString());
  }

}
