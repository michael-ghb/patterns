package com.michaelgorohov.checkoutapp;

public class NForMOffer implements Offer {

  private int n;
  private int m;

  public NForMOffer(int n, int m) {
    this.n = n;
    this.m = m;
  }

  public int nForM(int count) {

    int remainder = count % n;
    int result = (count - remainder) / n * m + remainder;
    return result;
  }

  @Override
  public void apply(Item item) {
    item.setCount(nForM(item.getCount()));
  }
}
