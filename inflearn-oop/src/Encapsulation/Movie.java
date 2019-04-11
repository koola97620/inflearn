package Encapsulation;

/**
 * @author choijaeyong on 11/04/2019.
 * @project inflearn-oop
 * @description
 */
public class Movie {
  public static int REGULAR = 0;
  public static int NEW_RELEASE = 1;
  private int priceCode;

  public int getPriceCode() {
    return priceCode;
  }

  public int isNewRelease(int daysRented) {
    if(priceCode == NEW_RELEASE && daysRented > 1) {
      return 2;
    }else
      return 1;
  }
}
