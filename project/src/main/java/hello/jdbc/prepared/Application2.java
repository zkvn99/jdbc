package hello.jdbc.prepared;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 사번을 Scanner로 입력 받아서 사원의 정보를 출력하는 프로그램 작성
* 출력할 사원의 정보 : emp_id, emp_name, salary
* 없는 사번이면 "해당 사원의 조회 결과가 없습니다." 출력 */
public class Application2 {

  public static void main(String[] args) {
    Connection conn = getConnection();
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);
    System.out.print("조회할 사번 입력 : ");
    int empId = sc.nextInt();

    try {
      /* PreparedStatement 는 placeholder를 사용하여 하나의 문자열 형태로 쿼리를 작성 */
      pstmt = conn.prepareStatement(
          "select emp_id, emp_name, salary from employee " +
              "where emp_id = ? and ent_yn = ?"
      );
      /* 쿼리 실행 전 placeholder의 내용을 인덱스 번호를 통해 설정 */
      pstmt.setInt(1, empId);
      pstmt.setString(2, "N");
      rset = pstmt.executeQuery();

      if (!rset.next()) {
        System.out.println("해당 사원의 조회 결과가 없습니다.");
      } else {
        System.out.println(
            "emp_id : " + rset.getInt("emp_id") + "\n"
                + "emp_name : " + rset.getString("emp_name") + "\n"
                + "salary : " + rset.getDouble("salary")
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
