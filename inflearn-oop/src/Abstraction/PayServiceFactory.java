package Abstraction;

/**
 * @author choijaeyong on 02/05/2019.
 * @project inflearn-oop
 * @description
 */
public class PayServiceFactory {

  public static PayService getInstance(PayService payService) {
    return payService instanceof KakaoPayService ? ((KakaoPayService) payService) : ((BankPayService) payService);
  }

}
