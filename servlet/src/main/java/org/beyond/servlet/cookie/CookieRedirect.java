package org.beyond.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cookie-redirect")
public class CookieRedirect extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    /* redirect 시 이전 req 정보는 존재하지 않으며 새로운 req 정보가 넘어옴 */
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    System.out.println("firstName:" + firstName + " lastName:" + lastName);

    /* 저장 된 쿠키 값을 꺼내서 확인 */
    Cookie[] cookies = req.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("firstName")) {
        firstName = cookie.getValue();
      } else if (cookie.getName().equals("lastName")) {
        lastName = cookie.getValue();
      }
    }

    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.print("<h1>your firstName is " + firstName + " and lastName is " + lastName + "</h1>");
  }
}
