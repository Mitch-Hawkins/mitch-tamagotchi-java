import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JFrame;

public class MainMenu extends MenuScreen {

  //   private List<MenuTile> menuTiles;
  FoodMenu foodMenu;
  StatsMenu statsMenu;

  public MainMenu(
    JFrame frame,
    List<MenuTile> menuTiles,
    MenuSwitcher menuSwitcher
  ) {
    super(frame, menuTiles);
    // menuTiles = new ArrayList<>();
    initializeMenu();
  }

  @Override
  protected void initializeMenu() {
    // foodMenu = new FoodMenu(frame, menuTile);
    // statsMenu = new StatsMenu(frame, menuTile);
    menuTiles.add(new MenuTile(100, 100, 100, 100, foodMenu));
    menuTiles.add(new MenuTile(250, 100, 100, 100, statsMenu));
  }

  @Override
  protected void paintMenu(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.blue);
    for (MenuTile menuTile : menuTiles) {
      g2.fillRect(
        menuTile.getX(),
        menuTile.getY(),
        menuTile.getWidth(),
        menuTile.getHeight()
      );
    }
  }
}
