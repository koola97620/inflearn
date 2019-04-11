package Encapsulation;

import java.util.concurrent.TimeUnit;

/**
 * @author choijaeyong on 11/04/2019.
 * @project inflearn-oop
 * @description
 */
public class Timer {
//  public long startTime;
//  public long stopTime;

  private long startTime;
  private long stopTime;

  public void start() {
    this.startTime = System.currentTimeMillis();
  }
  public void stop() {
    this.stopTime = System.currentTimeMillis();
  }
  public long elapsedTime(TimeUnit unit) {
    switch (unit) {
      case MILLISECONDS:
        return stopTime-startTime;
      default:
        return 0;
    }
  }

}
