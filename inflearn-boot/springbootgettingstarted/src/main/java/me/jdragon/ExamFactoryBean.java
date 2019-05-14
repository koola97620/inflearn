package me.jdragon;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 14/05/2019.
 * @project springbootgettingstarted
 * @description
 */

@Component
public class ExamFactoryBean implements GenericExam<Exam> {

  public ExamFactoryBean() {
    System.out.println("=======================================bean~");
  }

  public void log() {
    System.out.println("----------");
  }

}
