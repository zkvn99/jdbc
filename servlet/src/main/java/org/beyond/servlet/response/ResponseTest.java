package org.beyond.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/response")
public class ResponseTest extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    /* 1. 요청을 받아서 처리한다. (ex, req.getParameter())
    * 2. 비즈니스 로직을 호출한다. (ex, DB 연동 및 CRUD 작업)
    * 3. 응답을 처리한다.
    *    resp 객체를 이용하여 동적인 폼(HTML 문서) 페이지를 만들고 스트림을 이용해 내보내기 함
    * */

    /* 문자열을 이용해 사용자에게 내보내질 페이지 작성 */
    StringBuilder sb = new StringBuilder();
    sb.append("<html>")
        .append("<head>")
        .append("<title> 응답 페이지 </title>")
        .append("</head>")
        .append("<body>")
        .append("<h1>안녕 Servlet Response</h1>")
        .append("</body>")
        .append("</html>");

    resp.setContentType("text/html");   // 응답 데이터의 MIME type 설정
    resp.setCharacterEncoding("UTF-8"); // 응답 데이터의 문자 셋 설정

    resp.setContentType("text/html;charset=UTF-8"); // 위의 두 가지 설정을 한번에

    // 사용자 브라우저에 응답하기 위한 출력 스트림을 resp에서 반환 받음
    PrintWriter printWriter = resp.getWriter();
    printWriter.println(sb);
  }
}
