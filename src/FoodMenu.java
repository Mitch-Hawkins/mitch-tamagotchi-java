import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;

public class FoodMenu extends MenuScreen {

  public FoodMenu(JFrame frame, List<MenuTile> menuTiles) {
    super(frame, menuTiles);
    initializeMenu();
  }

  @Override
  protected void initializeMenu() {
    addButton("<", e -> cycleLeft());
    addButton(">", e -> cycleRight());
    addButton("Back", e -> backToMainMenu());
  }

  @Override
  protected void paintMenu(Graphics g) {}

  private void backToMainMenu() {
    System.out.println("Back!");
  }

  private void cycleLeft() {
    System.out.println("Left");
  }

  private void cycleRight() {
    System.out.println("Right");
  }
}
