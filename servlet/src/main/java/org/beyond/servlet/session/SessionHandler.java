package org.beyond.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/session")
public class SessionHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    /* 서버 쪽에서 관리할 수 있는 세션이라는 인스턴스를 통한 상태 유지 메커니즘이 제공 */
    HttpSession session = req.getSession();

    /* 세션 브라우저 단 한 개의 고유 아이디를 가지고 하나의 인스턴스를 이용
    * 단, 브라우저가 종료되면 해당 세션이 종료되므로 그 이후의 요청은 다른 세션 아이디를 반환
    * 세션 아이디는 cookie에 JSESSIONID 라는 키 값으로 저장 */
    System.out.println(session.getId());

    System.out.println(session.getMaxInactiveInterval());
    session.setMaxInactiveInterval(60 * 10);
    System.out.println(session.getMaxInactiveInterval());

    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    session.setAttribute("firstName", firstName);
    session.setAttribute("lastName", lastName);
  }
}
