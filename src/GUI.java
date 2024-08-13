import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements Runnable {

  JFrame frame;
  MenuScreen currentMenu;

  public GUI() {
    frame = new JFrame();

    this.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
    this.setLayout(new GridLayout(0, 1));
    this.setBackground(Color.BLACK);

    frame.add(this, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Tamagotchi");
    frame.setSize(600, 600);
    frame.setVisible(true);

    // List<Rectangle> defaultRectangles = new List
    currentMenu = new MainMenu(frame, new ArrayList<Rectangle>());

    // Instantiate and register the MouseHandler
    MouseHandler mouseHandler = new MouseHandler(this, currentMenu);
    this.addMouseListener(mouseHandler);
  }

  Thread gameThread;

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  public void run() {
    while (gameThread != null) {
      update();
      repaint(); // calls paint component, a little bit confusing though.
    }
  }

  public void update() {}

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // This is boiler plate for paintComponent method (subclass of JPanel)
    currentMenu.paintMenu(g);
    g.dispose();
  }
}
