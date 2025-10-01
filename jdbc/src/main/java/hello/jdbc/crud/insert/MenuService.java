package hello.jdbc.crud.insert;

import static hello.jdbc.template.JDBCTemplate.close;
import static hello.jdbc.template.JDBCTemplate.commit;
import static hello.jdbc.template.JDBCTemplate.getConnection;
import static hello.jdbc.template.JDBCTemplate.rollback;

import java.sql.Connection;

/* Service 계층 : 비즈니스 로직을 구현하는 계층
* 기능의 수행 결과에 따라 commit, rollback 처리 
* */
public class MenuService {

  public void registMenu(Menu menu) {
    Connection conn = getConnection();
    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.insertMenu(conn, menu);

    if (result > 0) {
      commit(conn);
    } else {
      rollback(conn);
    }

    close(conn);
  }

  public void updateMenu(Menu menu) {
    Connection conn = getConnection();
    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.updateMenu(conn, menu);

    if (result > 0) {
      commit(conn);
    } else {
      rollback(conn);
    }

    close(conn);
  }

  public void deleteMenu(Menu menu) {
    Connection conn = getConnection();
    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.deleteMenu(conn, menu);

    if (result > 0) {
      commit(conn);
    } else {
      rollback(conn);
    }

    close(conn);
  }
}
