package com.example.demowebmvc;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author choijaeyong on 05/04/2019.
 * @project demo-web-mvc
 * @description
 */
public class VisitTimeInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    HttpSession session = request.getSession();
    if(session.getAttribute("visitTime") == null) {
      session.setAttribute("visitTime" , LocalDateTime.now());
    }

    return true;
  }
}
