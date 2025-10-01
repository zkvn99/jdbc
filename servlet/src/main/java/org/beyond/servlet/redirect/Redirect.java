package org.beyond.servlet.redirect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/redirect")
public class Redirect extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("이 서블릿으로 redirect 처리");

    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.println("<h1> 이 서블릿으로 redirect 완료 ! </h1>");
  }
}
