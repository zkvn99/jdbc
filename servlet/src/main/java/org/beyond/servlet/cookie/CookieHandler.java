package org.beyond.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/cookie")
public class CookieHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");

    /* 1. 쿠키 생성 */
    Cookie firstNameCookie = new Cookie("firstName", firstName);
    Cookie lastNameCookie = new Cookie("lastName", lastName);

    /* 2. 쿠키 만료 시간 설정 */
    firstNameCookie.setMaxAge(60 * 60 * 24);    // 초 단위 (하루)
    lastNameCookie.setMaxAge(60 * 60 * 24);

    /* 3. 응답 헤더에 쿠키를 담음 */
    resp.addCookie(firstNameCookie);
    resp.addCookie(lastNameCookie);
  }
}
