import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

  private GUI gui;

  public MouseHandler(GUI gui) {
    this.gui = gui;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked at: " + e.getPoint());
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
