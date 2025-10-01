package org.beyond.servlet.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Custom Error Page 응답하는 서블릿 */
@WebServlet(value = "/showErrorPage")
public class ExceptionHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");

    Enumeration<String> attrs = req.getAttributeNames();
    while(attrs.hasMoreElements()) {
      String attr = attrs.nextElement();
      System.out.println(attr + " : " + req.getAttribute(attr));
    }

    int statusCode = (int) req.getAttribute("javax.servlet.error.status_code");
    String message = (String) req.getAttribute("javax.servlet.error.message");
    String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

    StringBuilder sb = new StringBuilder();
    sb.append("<html>")
        .append("<head>")
        .append("<title> 에러 페이지 </title>")
        .append("</head>")
        .append("<body>")
        .append("<h1>")
        .append(statusCode)
        .append("</h1>")
        .append("<h1>")
        .append(message)
        .append("</h1>")
        .append("<h1>")
        .append(servletName)
        .append("</h1>")
        .append("</body>")
        .append("</html>");

    PrintWriter printWriter = resp.getWriter();
    printWriter.println(sb);
  }
}
