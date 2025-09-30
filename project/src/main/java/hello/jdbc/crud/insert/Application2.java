package hello.jdbc.crud.insert;

import java.util.Scanner;

/* 콘솔을 통해 입출력하는 내용 (View) */
public class Application2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("신메뉴명 : ");
    String menuName = sc.nextLine();
    System.out.print("신메뉴 가격 : ");
    int menuPrice = sc.nextInt();
    System.out.print("카테고리 코드 : ");
    int categoryCode = sc.nextInt();
    sc.nextLine();
    System.out.print("판매상태 : ");
    String orderableStatus = sc.nextLine();

    /* View -> Service로 사용자에게 입력 받을 데이터를 전달하려고 할 때
    * Menu 클래스를 별도로 만들어서 묶어서 처리 */
    Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
    MenuService menuService = new MenuService();
    menuService.registMenu(menu);
  }
}
