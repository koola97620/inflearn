package Abstraction;

/**
 * @author choijaeyong on 02/05/2019.
 * @project inflearn-oop
 * @description
 */
public class Payment {

  private PayService payService;

  public void payment(PayService payService) {
    PayService result = PayServiceFactory.getInstance(payService);
    System.out.println(result.getClass().getName());

  }

  public void cancel() {
    PayService result = PayServiceFactory.getInstance(payService);

  }

}
