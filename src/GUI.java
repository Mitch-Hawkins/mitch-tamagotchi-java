import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements Runnable {

  JFrame frame;

  private List<Rectangle> rectangles;

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

    rectangles = new ArrayList<>();

    rectangles.add(new Rectangle(100, 100, 100, 100));

    // Instantiate and register the MouseHandler
    MouseHandler mouseHandler = new MouseHandler(this);
    this.addMouseListener(mouseHandler);
  }

  Thread gameThread;

  //Making a getter function for the rectangles list to be used in the MouseHandler
  public List<Rectangle> getRectangles() {
    return rectangles;
  }

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

  Rectangle rect;

  public void paintComponent(Graphics g) {
    rect = new Rectangle(100, 100, 100, 100);
    super.paintComponent(g); // This is boiler plate for paintComponent method (subclass of JPanel)
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
    g2.dispose();
  }
}
