package org.beyond.servlet.lifecycle.servicemethod;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/request-service")
public class ServiceMethodTest extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String httpMethod = req.getMethod();
    System.out.println("httpMethod: " + httpMethod);

    if ("GET".equals(httpMethod)) {
      doGet(req, resp);
    } else if ("POST".equals(httpMethod)) {
      doPost(req, resp);
    }

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("GET 방식의 요청 처리 메소드 동작");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("POST 방식의 요청 처리 메소드 동작");
  }
}
