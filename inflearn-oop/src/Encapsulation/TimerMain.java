package Encapsulation;

import java.util.concurrent.TimeUnit;

/**
 * @author choijaeyong on 11/04/2019.
 * @project inflearn-oop
 * @description
 */
public class TimerMain {
  public static void main(String[] args) {
    Timer t = new Timer();
//    t.startTime = System.currentTimeMillis();
//    t.stopTime = System.currentTimeMillis();
//    long elaspedTime = t.stopTime - t.startTime;

    t.start();



    t.stop();

    long time = t.elapsedTime(TimeUnit.MILLISECONDS);

  }

}
