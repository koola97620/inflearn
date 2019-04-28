package me.jdragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author choijaeyong on 17/04/2019.
 * @project springbootgettingstarted
 * @description
 */

@SpringBootApplication
public class Application {

  public static void main(String[] args){

//    SpringApplication application = new SpringApplication(Application.class);
//   application.setWebApplicationType(WebApplicationType.SERVLET);
//    application.run(args);


    // 내장톰캣 만드는 과정.
//    Tomcat tomcat = new Tomcat();
//    tomcat.setPort(8080);
//    Context context = tomcat.addContext("/", ".");
//
//    HttpServlet servlet = new HttpServlet() {
//      @Override
//      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//          throws ServletException, IOException {
//        PrintWriter pw = resp.getWriter();
//        pw.write("<html><head><title>");
//        pw.write("hi. i'm tomcat");
//        pw.write("</title></head>");
//        pw.write("<body>");
//        pw.write("<h1>hello tomcat</h1>");
//        pw.write("</body></html>");
//
//
//      }
//    };
//    String servletName = "helloServlet";
//    tomcat.addServlet("/",servletName,servlet);
//    context.addServletMappingDecoded("/hello",servletName);
//
//    tomcat.start();
//    tomcat.getServer().await();



    SpringApplication.run(Application.class,args);
  }

//  @Bean
//  public HoloMan holoMan() {
//    HoloMan holoMan = new HoloMan();
//    holoMan.setName("jd");
//    holoMan.setHowLong(60);
//    return holoMan;
//  }

}
