import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class MainMenu extends MenuScreen {

  //   private List<Rectangle> rectangles;
  FoodMenu foodMenu;

  public MainMenu(JFrame frame, List<Rectangle> rectangles) {
    super(frame, rectangles);
    rectangles = new ArrayList<>();
    foodMenu = new FoodMenu(frame, rectangles);
    initializeMenu();
    // MouseHandler mouseHandler = new MouseHandler(this);
    // this.addMouseListener(mouseHandler);
  }

  @Override
  protected void initializeMenu() {
    rectangles.add(new Rectangle(100, 100, 100, 100, foodMenu));
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
