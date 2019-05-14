import me.jdragon.Application;
import me.jdragon.Exam;
import me.jdragon.ExamFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author choijaeyong on 14/05/2019.
 * @project springbootgettingstarted
 * @description
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class test {

  @Autowired
  ApplicationContext context;

  @Test
  public void test() {
    ExamFactoryBean obj = (ExamFactoryBean)context.getBean("examFactoryBean");
    obj.log();

  }

}
