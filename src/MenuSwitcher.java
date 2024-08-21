import java.awt.*;
import javax.swing.*;

public class MenuSwitcher {

  // private JFrame frame;
  private JPanel mainPanel;
  private CardLayout cardLayout;

  public MenuSwitcher(JFrame frame) {
    cardLayout = new CardLayout();
    mainPanel = new JPanel(cardLayout);

    // Create different menu panels
    JPanel menu1 = new JPanel();
    menu1.setBackground(Color.RED);
    menu1.add(new JLabel("Menu 1"));

    JPanel menu2 = new JPanel();
    menu2.setBackground(Color.GREEN);
    menu2.add(new JLabel("Menu 2"));

    // Add menus to the main panel
    mainPanel.add(menu1, "Menu1");
    mainPanel.add(menu2, "Menu2");
  }

  public JPanel getMainPanel() {
    return mainPanel;
  }

  public JPanel getCurrentPanel() {
    // Iterate through the components in mainPanel
    for (Component comp : mainPanel.getComponents()) {
      if (comp.isVisible()) {
        return (JPanel) comp; // Return the visible panel
      }
    }
    return null; // No panel is visible
  }

  public void addMenu(String name, JPanel menuPanel) {
    mainPanel.add(menuPanel, name);
  }

  public void showMenu(String menuName) {
    cardLayout.show(mainPanel, menuName);
  }

  public void showNextMenu() {
    cardLayout.next(mainPanel);
  }
}
