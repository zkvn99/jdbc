package hello.jdbc.statement;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
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
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);
    System.out.print("조회할 사번 입력 : ");
    int empId = sc.nextInt();

    try {
      stmt = conn.createStatement();
      rset = stmt.executeQuery(
          "SELECT EMP_ID, EMP_NAME, SALARY FROM employee WHERE EMP_ID = " + empId
      );

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
      close(stmt);
      close(conn);
    }
  }
}
