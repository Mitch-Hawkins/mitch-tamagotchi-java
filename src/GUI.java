import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

  public GUI() {
    JFrame frame = new JFrame();

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
    panel.setLayout(new GridLayout(0, 1));
    panel.setBackground(Color.BLACK);

    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Our GUI");
    frame.pack();
    frame.setVisible(true);

    Thread gameThread;
  }

  public static void main(String[] args) throws Exception {
    new GUI();
  }
}
