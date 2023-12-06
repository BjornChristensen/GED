package Java2D_Graphics;
import javax.swing.*;
import java.awt.*;

public class GraphicsAppSkeleton extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new GraphicsAppSkeleton();
    frame.setSize(700, 700);
    frame.setTitle("GraphicsAppSkeleton");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public GraphicsAppSkeleton() {
    add(new DrawPanel());
  }

  class DrawPanel extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
    }
  } // class DrawPanel
}