package hello.jdbc.sqlinjection;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application1 {

    private static String empId = "200";
    private static String empName = "' or 1=1 and emp_id='200";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        String query = "select * from employee where emp_id = '" + empId + "' and emp_name = '" + empName + "'";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                System.out.println(rset.getString("emp_name") + "님 환영합니다.");
            } else {
                System.out.println("해당 사원은 존재하지 않습니다.");
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