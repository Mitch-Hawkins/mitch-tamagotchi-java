import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class MenuScreen extends JPanel {

  protected JFrame frame;
  protected List<MenuTile> menuTiles;

  public MenuScreen(JFrame frame, List<MenuTile> menuTiles) {
    this.frame = frame;
    this.menuTiles = menuTiles;
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBackground(Color.BLACK);
  }

  protected JButton addButton(String text, ActionListener action) {
    JButton button = new JButton(text);
    button.addActionListener(action);
    this.add(button);
    return button;
  }

  // Abstract method to be implemented by specific menus
  protected abstract void initializeMenu();

  protected abstract void paintMenu(Graphics g);

  public void showMenu() {
    frame.getContentPane().removeAll();
    frame.add(this);
    frame.revalidate();
    frame.repaint();
  }

  public List<MenuTile> getMenuTiles() {
    return menuTiles;
  }
}
