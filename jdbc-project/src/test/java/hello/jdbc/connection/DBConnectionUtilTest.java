package hello.jdbc.connection;

import static org.assertj.core.api.Assertions.*;

import hello.jdbc.connetion.DBConnectionUtil;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

public class DBConnectionUtilTest {

  @Test
  void connection() {
    Connection connection = DBConnectionUtil.getConnection();
    assertThat(connection).isNotNull();
  }
}
