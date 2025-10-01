package org.beyond.servlet.lifecycle.xml;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {

  public LifeCycleTest() {
    System.out.println("XML 매핑 생성자 호출");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("XML 매핑 init 메소드 호출");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("XML 매핑 service 메소드 호출");
  }

  @Override
  public void destroy() {
    System.out.println("XML 매핑 destroy 메소드 호출");
  }
}
