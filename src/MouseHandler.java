import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseHandler implements MouseListener {

  private GUI gui;
  private MenuScreen menuScreen;

  public MouseHandler(GUI gui, MenuScreen menuScreen) {
    this.gui = gui;
    this.menuScreen = menuScreen;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int mouseX = e.getX();
    int mouseY = e.getY();

    List<Rectangle> rectangles = menuScreen.getRectangles();
    for (Rectangle rectangle : rectangles) {
      if (rectangle.contains(mouseX, mouseY)) {
        rectangle.onClick();
        break;
      }
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed at: " + e.getPoint());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released at: " + e.getPoint());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entered the panel");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println("Mouse exited the panel");
  }
}
