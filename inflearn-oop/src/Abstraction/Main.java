package Abstraction;

/**
 * @author choijaeyong on 02/05/2019.
 * @project inflearn-oop
 * @description
 */
public class Main {
  public static void main(String[] args) {

    Payment payment = new Payment();

    payment.payment(PayServiceFactory.getInstance(new KakaoPayService()));
    payment.payment(PayServiceFactory.getInstance(new BankPayService()));

    //payment.payment(new KakaoPayService());
    //payment.payment(new BankPayService());

  }

}
