package hello.jdbc.crud.update;

import hello.jdbc.crud.insert.Menu;
import hello.jdbc.crud.insert.MenuService;
import java.util.Scanner;

/* 변경할 메뉴 번호를 받아서 이름, 가격을 수정하는 기능
* Service, Repository로 분리해서 기능 구현
* */
public class Application {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("변경할 메뉴 번호 : ");
    int menuCode = sc.nextInt();
    System.out.print("변경할 메뉴 이름 : ");
    sc.nextLine();
    String menuName = sc.nextLine();
    System.out.print("변경할 메뉴 가격 : ");
    int menuPrice = sc.nextInt();

    Menu menu = new Menu(menuCode, menuName, menuPrice);
    MenuService menuService = new MenuService();
    menuService.updateMenu(menu);

  }
}
