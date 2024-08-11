import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements Runnable {

  JFrame frame;

  public GUI() {
    frame = new JFrame();

    this.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
    this.setLayout(new GridLayout(0, 1));
    this.setBackground(Color.BLACK);

    frame.add(this, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Our GUI");
    frame.setSize(600, 600);
    frame.setVisible(true);
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
    System.out.println("I drew something");
    super.paintComponent(g); // This is boiler plate for paintComponent method (subclass of JPanel)
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.blue);
    g2.fillRect(100, 100, 100, 100);
    g2.dispose();
  }
}
