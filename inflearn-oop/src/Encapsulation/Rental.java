package Encapsulation;

/**
 * @author choijaeyong on 11/04/2019.
 * @project inflearn-oop
 * @description
 */
public class Rental {
  private Movie movie;
  private int daysRented;

  public int getFrequentRenterPoints() {
//    if(movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
//      return 2;
//    }else {
//      return 1;
//    }
    return movie.isNewRelease(daysRented);
  }

}
