package org.beyond.servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/otherservlet")
public class OtherServletRedirect extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    /* 비즈니스 로직 수행 후 */
    System.out.println("get 요청 정상 수락 후 응답");
    resp.sendRedirect("redirect");
  }
}
