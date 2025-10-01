package org.beyond.servlet.forward;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/forward")
public class ReceiveInformation extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String userId = req.getParameter("userId");
    String password = req.getParameter("password");

    /* id, pwd에 해당하는 user의 정보를 조회한 뒤 반환 되는 비즈니스 로직이 수행 되었다고
    * 가정하고 'XXX님 환영합니다' 와 같은 메세지 출력 화면을 응답함 */
    req.setAttribute("userName", "홍길동");
    System.out.println(req.getParameter("userName") + "hi");
    /* 비즈니스 로직 수행과 응답 화면 생성을 분리하기 위해 다른 서블릿으로 위임 (forward) */
    RequestDispatcher rd = req.getRequestDispatcher("print");
    rd.forward(req, resp);
  }
}
