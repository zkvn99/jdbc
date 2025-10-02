package org.beyond.servlet.session;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/session-delete")
public class DeleteSessionData extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    Enumeration<String> keys = session.getAttributeNames();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      System.out.println(key + " : " + session.getAttribute(key));
    }

    /* 세션 데이터 제거 방법
    * 1. 설정 만료 시간이 지나 세션 자동 제거
    * 2. removeAttribute()로 속성 제거
    * 3. invalidate() 로 세션의 모든 데이터 제거 (세션 무효화, 강제 만료)
    * */
    System.out.println("=======================");
    session.removeAttribute("firstName");
    keys = session.getAttributeNames();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      System.out.println(key + " : " + session.getAttribute(key));
    }

    System.out.println("========================");
    session.invalidate();
    keys = session.getAttributeNames();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      System.out.println(key + " : " + session.getAttribute(key));
    }

  }
}
