import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseHandler implements MouseListener {

  private GUI gui;

  public MouseHandler(GUI gui) {
    this.gui = gui;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // System.out.println("Mouse clicked at: " + e.getPoint());
    int mouseX = e.getX();
    int mouseY = e.getY();

    List<Rectangle> rectangles = gui.getRectangles();
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
