package hello.jdbc.crud.insert;

public class Menu {
  private int menuCode;
  private String menuName;
  private int menuPrice;
  private int categoryCode;
  private String orderableStatus;

  public Menu(int menuCode) {
    this.menuCode = menuCode;
  }

  public Menu(int menuCode, String menuName, int menuPrice) {
    this.menuCode = menuCode;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
  }

  public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.categoryCode = categoryCode;
    this.orderableStatus = orderableStatus;
  }

  public int getMenuCode() {return menuCode;}

  public String getOrderableStatus() {
    return orderableStatus;
  }

  public int getMenuPrice() {
    return menuPrice;
  }

  public String getMenuName() {
    return menuName;
  }

  public int getCategoryCode() {
    return categoryCode;
  }
}
