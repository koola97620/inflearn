package me.jdragon.springinit;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 28/04/2019.
 * @project springinit
 * @description
 */

@Component
public class ApplicationRunnerExam implements CommandLineRunner {

//  ApplicationRunner 용
//  @Override
//  public void run(ApplicationArguments args) throws Exception {
//    System.out.println("foo : " + args.containsOption("foo"));
//    System.out.println("bar : " + args.containsOption("bar"));
//  }


  @Override
  public void run(String... args) throws Exception {
    Arrays.stream(args).forEach(System.out::println);

  }
}
