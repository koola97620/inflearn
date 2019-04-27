package me.jdragon.springinit;

import com.sun.org.apache.xpath.internal.Arg;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 28/04/2019.
 * @project springinit
 * @description
 */

@Component
public class ArgumentExam {

  public ArgumentExam(ApplicationArguments arguments) {
    System.out.println("foo : " + arguments.containsOption("foo"));
    System.out.println("bar : " + arguments.containsOption("bar"));

  }


}
