package org.beyond.servlet.request.querystring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/querystring")
public class QueryStringTest extends HttpServlet {
  /* 서블릿이 매핑된 주소로 Get 방식의 요청이 발생하면 doGet 메소드가 호출 */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    /* HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 메소드를 이용해 추출 가능
    * 요청에 넘어온 데이터는 hashmap으로 관리되고 있고
    * key로 name 속성을 전달하면 value 값을 반환 받을 수 있음 */
    String name = req.getParameter("name");
    // 반환 타입은 늘 String 이므로 필요한 타입으로 parsing 처리가 필요할 수 있음
    int age = Integer.parseInt(req.getParameter("age"));
    java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
    String gender = req.getParameter("gender");
    String national = req.getParameter("national");
    // checkbox는 다중으로 값을 입력 받을 수 있으므로 문자열 배열로 전달됨
    String[] hobbies = req.getParameterValues("hobbies");

    System.out.println("name : " + name);
    System.out.println("age : " + age);
    System.out.println("birthday : " + birthday);
    System.out.println("gender : " + gender);
    System.out.println("national : " + national);
    System.out.println("hobbies : " + hobbies);
  }
}
