package hello.jdbc.prepared;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application1 {

  public static void main(String[] args) {
    Connection conn = getConnection();
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    try {
      /* PreparedStatement : 쿼리를 운반하고 결과를 반환하는 객체
      * 객체 생성 시 수행할 sql 구문을 설정해서 생성 */
      pstmt = conn.prepareStatement("select * from employee");
      /* 객체 생성 시 이미 sql 구문은 전달 되었으므로 구문을 전달하지 않음 */
      rset = pstmt.executeQuery();

      while (rset.next()) {
        System.out.println(
            rset.getString("EMP_NAME") + " " + rset.getString("SALARY")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rset);
      close(pstmt);
      close(conn);
    }
  }
}
