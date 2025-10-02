package org.beyond.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/session-redirect")
public class SessionRedirect extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    /* session id 를 통해 session 인스턴스를 가져옴 */
    HttpSession session = req.getSession();
    System.out.println("redirect 후 session id : " + session.getId());

    /* 세션 인스턴스에 저장 된 attribute는 다른 요청에서 꺼내 쓸 수 있음 */
    String firstName = session.getAttribute("firstName").toString();
    String lastName = session.getAttribute("lastName").toString();
    System.out.println("firstName : " + firstName + " lastName : " + lastName);

    PrintWriter out = resp.getWriter();
    out.println("<h1> firstName : " + firstName + " lastName : " + lastName + "</h1>");
  }
}
