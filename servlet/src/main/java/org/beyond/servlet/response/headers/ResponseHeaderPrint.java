package org.beyond.servlet.response.headers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/headers-res")
public class ResponseHeaderPrint extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setHeader("Refresh", "1");
    long currentTime = System.currentTimeMillis();

    StringBuilder sb = new StringBuilder();
    sb.append("<html>")
      .append("<head>")
      .append("<title> 응답 페이지 </title>")
      .append("</head>")
      .append("<body>")
      .append("<h1>")
      .append(currentTime)
      .append("</h1>")
      .append("</body>")
      .append("</html>");

    PrintWriter printWriter = resp.getWriter();
    printWriter.println(sb);


    /* Response Header 정보 출력 */
    Collection<String> responseHeaders = resp.getHeaderNames();
    for (String headerName : responseHeaders) {
      System.out.println("headerName : " + headerName);
    }
  }
}
