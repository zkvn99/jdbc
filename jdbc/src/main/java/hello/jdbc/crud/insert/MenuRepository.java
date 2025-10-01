package hello.jdbc.crud.insert;

import static hello.jdbc.template.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/* Repository 계층
* DBMS를 통해 수행 되는 CRUD 직업 단위 메소드를 정의
* */
public class MenuRepository {
  public int insertMenu(Connection conn, Menu menu) {
    PreparedStatement pstmt = null;
    Properties properties = new Properties();
    int result = 0;

    try {
      properties.loadFromXML(
          new FileInputStream(
              "src/main/java/hello/jdbc/mapper/MenuMapper.xml"
          )
      );
      String sql = properties.getProperty("insertMenu");
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, menu.getMenuName());
      pstmt.setInt(2, menu.getMenuPrice());
      pstmt.setInt(3, menu.getCategoryCode());
      pstmt.setString(4, menu.getOrderableStatus());

      result = pstmt.executeUpdate();

    } catch (IOException | SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
    }

    return result;
  }

  public int updateMenu(Connection conn, Menu menu) {
    PreparedStatement pstmt = null;
    Properties properties = new Properties();
    int result = 0;

    try {
      properties.loadFromXML(
          new FileInputStream(
              "src/main/java/hello/jdbc/mapper/MenuMapper.xml"
          )
      );
      String sql = properties.getProperty("updateMenu");
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, menu.getMenuName());
      pstmt.setInt(2, menu.getMenuPrice());
      pstmt.setInt(3, menu.getMenuCode());

      result = pstmt.executeUpdate();

    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return result;
  }

  public int deleteMenu(Connection conn, Menu menu) {
    PreparedStatement pstmt = null;
    Properties properties = new Properties();
    int result = 0;

    try {
      properties.loadFromXML(
          new FileInputStream(
              "src/main/java/hello/jdbc/mapper/MenuMapper.xml"
          )
      );
      String sql = properties.getProperty("deleteMenu");
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, menu.getMenuCode());

      result = pstmt.executeUpdate();

    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return result;
  }
}
