package hello.jdbc.crud.delete;

import hello.jdbc.crud.insert.Menu;
import hello.jdbc.crud.insert.MenuService;
import java.util.Scanner;

/* 변경할 메뉴 번호를 삭제하는 기능
 * Service, Repository로 분리해서 기능 구현
 * */
public class Application {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("삭제 메뉴 번호 : ");
    int menuCode = sc.nextInt();

    Menu menu = new Menu(menuCode);
    MenuService menuService = new MenuService();
    menuService.deleteMenu(menu);
  }
}
