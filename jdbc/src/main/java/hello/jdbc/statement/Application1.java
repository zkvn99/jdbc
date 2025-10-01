package hello.jdbc.statement;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application1 {

  public static void main(String[] args) {
    Connection con = getConnection();
    Statement stmt = null;
    ResultSet rset = null;
    try {
      /* Statement : 쿼리를 운반하고 그 결과를 반환하는 객체 */
      stmt = con.createStatement();
      /* ResultSet : Statement 객체를 통해 조회 처리 된 결과를 다루는 객체 */
      rset = stmt.executeQuery("SELECT * FROM employee");

      while(rset.next()) { // 결과 행의 존재 여부 확인
        System.out.println(
            rset.getString("emp_name") + " "
                + rset.getInt("salary")
        );
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      close(rset);
      close(stmt);
      close(con);
    }
  }

}
