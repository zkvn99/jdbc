package hello.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

  public static void main(String[] args) {
    Connection con = null;

    try {
      /* DB 연결 정보가 잘못 작성 된 경우 Connection 객체 생성이 불가능하므로
      * SQLException 발생 가능
      * */
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306", "practice", "practice"
      );
    } catch (SQLException e) {
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
