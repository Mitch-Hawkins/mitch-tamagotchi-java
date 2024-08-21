import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements Runnable {

  JFrame frame;
  // MenuScreen currentMenu;
  MenuSwitcher menuSwitcher;
  StatsMenu statsMenu;

  public GUI() {
    frame = new JFrame();

    // this.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
    // this.setLayout(new GridLayout(0, 1));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Tamagotchi");
    frame.setSize(600, 600);

    menuSwitcher = new MenuSwitcher(frame);
    frame.add(menuSwitcher.getMainPanel(), BorderLayout.CENTER);

    frame.setVisible(true);

    statsMenu = new StatsMenu(frame, null);

    menuSwitcher.addMenu("StatsMenu", statsMenu);

    // MainMenu mainMenu = new MainMenu(frame, menuTiles, menuSwitcher);
    // StatsMenu statsMenu = new StatsMenu(frame, menuTiles, menuSwitcher);

    menuSwitcher.showMenu("StatsMenu");
    // Instantiate and register the MouseHandler
    // MouseHandler mouseHandler = new MouseHandler(this, currentMenu);
    // this.addMouseListener(mouseHandler);
  }

  Thread gameThread;

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  public void run() {
    while (gameThread != null) {
      update();
      frame.repaint(); // calls paint component, a little bit confusing though.
    }
  }

  public void update() {}

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // This is boiler plate for paintComponent method (subclass of JPanel)
    // currentMenu.paintMenu(g);
    menuSwitcher.showMenu(menuSwitcher.getCurrentPanel().getName());
    g.dispose();
  }
}
