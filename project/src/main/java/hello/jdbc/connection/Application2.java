package hello.jdbc.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {

  public static void main(String[] args) {
    Properties props = new Properties();
    Connection con = null;

    try {
      props.load(
          new FileReader("src/main/java/hello/jdbc/connection/jdbc-config.properties")
      );
      /* DB 연결 정보가 문자로 작성 되어 있는 것을 파일로 분리
       * */
      String url = props.getProperty("url");
      String user = props.getProperty("user");
      String password = props.getProperty("password");
      con = DriverManager.getConnection(
          url, user, password
      );
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        /* DBMS와의 연결이 종료 될 때 호출되어야 함 */
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
