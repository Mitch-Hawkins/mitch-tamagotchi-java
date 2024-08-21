public class MenuTile implements Clickable {

  private int x;
  private int y;
  private int width;
  private int height;
  private MenuScreen menuScreen;

  public MenuTile(int x, int y, int width, int height, MenuScreen menuScreen) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.menuScreen = menuScreen;
  }

  // Getter methods
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public MenuScreen getMenuScreen() {
    return menuScreen;
  }

  // Method to check if a point is inside the menuTile
  public boolean contains(int mouseX, int mouseY) {
    return (
      mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height
    );
  }

  public void onClick() {
    System.out.println("Menu Tile Clicked!");
    menuScreen.showMenu();
  }
}
