import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JFrame;

public class MainMenu extends MenuScreen {

  //   private List<Rectangle> rectangles;
  FoodMenu foodMenu;
  StatsMenu statsMenu;

  public MainMenu(
    JFrame frame,
    List<Rectangle> rectangles,
    MenuSwitcher menuSwitcher
  ) {
    super(frame, rectangles);
    // rectangles = new ArrayList<>();
    initializeMenu();
  }

  @Override
  protected void initializeMenu() {
    // foodMenu = new FoodMenu(frame, rectangles);
    // statsMenu = new StatsMenu(frame, rectangles);
    rectangles.add(new Rectangle(100, 100, 100, 100, foodMenu));
    rectangles.add(new Rectangle(250, 100, 100, 100, statsMenu));
  }

  @Override
  protected void paintMenu(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.blue);
    for (Rectangle rectangle : rectangles) {
      g2.fillRect(
        rectangle.getX(),
        rectangle.getY(),
        rectangle.getWidth(),
        rectangle.getHeight()
      );
    }
  }
}
