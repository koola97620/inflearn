package me.jdragon.springinit;

import java.io.PrintStream;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringinitApplication {

  public static void main(String[] args) {
//    SpringApplication.run(SpringinitApplication.class, args);
//    SpringApplication app = new SpringApplication(SpringinitApplication.class);
//    app.setBanner((environment, sourceClass, out) -> {
//      out.println("======================");
//      out.println("JDragon");
//      out.println("======================");
//    });
    //app.setBannerMode(Banner.Mode.OFF);
//    app.run(args);

    new SpringApplicationBuilder()
        .sources(SpringinitApplication.class)
        .run(args);


  }

}
