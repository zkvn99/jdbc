package org.beyond.servlet.forward;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class PrintLoginSuccess extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    /* forward 된 servlet 에서도 요청 방식이 그대로 유지 post -> post
     * 또한 전달 된 req, resp 의 모든 정보를 이용해 새로운 req, resp 를 깊은 복사를 통해 만들어
     * 전달 즉, 데이터가 그대로 보존 */
    String userName = (String) req.getAttribute("userName");

    System.out.println(req.getParameter("userName") + "hihihihi");
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter printWriter = resp.getWriter();
    printWriter.println("<h1>" + userName + "</h1>");
  }



}
