package hello.jdbc.crud.insert;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.commit;
import static hello.jdbc.template.JDBCTemplate.getConnection;
import static hello.jdbc.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application1 {

  public static void main(String[] args) {
    Connection conn = getConnection();
    PreparedStatement pstmt = null;
    String sql = "insert into tbl_menu"
        + "(menu_name, menu_price, category_code, orderable_status)" +
        "values (?, ?, ?, ?)";

    int result = 0;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, "봉골레청국장");
      pstmt.setInt(2, 12000);
      pstmt.setInt(3, 4);
      pstmt.setString(4, "Y");

      /* insert, update, delete 시 수행 된 행의 개수를 int로 반환
      * 호출 메소드는 executeUpdate */
      result = pstmt.executeUpdate();

      /* 자동으로 커밋되지 않도록 설정한 뒤 서비스 내에서 트랜잭션 컨트롤 */
      if (result > 0) {
        commit(conn);
      } else {
        rollback(conn);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
      close(conn);
    }
  }
}
