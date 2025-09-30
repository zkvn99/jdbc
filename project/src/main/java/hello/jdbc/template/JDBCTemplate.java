package hello.jdbc.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

  public static Connection getConnection() {
    Properties props = new Properties();
    Connection con = null;

    try {
      props.load(new FileReader("src/main/java/hello/jdbc/connection/jdbc-config.properties"));
      String url = props.getProperty("url");
      con = DriverManager.getConnection(
          url, props
      );

      /* 자동 커밋 설정을 수동 커밋 설정으로 변경하여 서비스에서 트랜잭션을
      * 컨트롤 할 수 있도록 한다 */
      con.setAutoCommit(false);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return con;
  }

  /* Connection을 닫는 개념은 별도의 메소드로 분리하고 실제 닫는 시점은 Service 계층에서 진행 */
  public static void close(Connection con) {
    try {
      if (con != null && !con.isClosed()) con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(ResultSet resultSet) {
    try {
      if (resultSet != null && !resultSet.isClosed()) resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(Statement statement) {
    try {
      if (statement != null && !statement.isClosed()) statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /* 트랜잭션 컨트롤을 위한 메소드 추가 */
  public static void commit(Connection con) {
    try {
      if (con != null && !con.isClosed()) con.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void rollback(Connection con) {
    try {
      if (con != null && !con.isClosed()) con.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
