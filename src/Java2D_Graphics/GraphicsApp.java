package Java2D_Graphics;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class GraphicsApp extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new GraphicsApp();
    frame.setSize(700, 700);
    frame.setTitle("GraphicsApp");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public GraphicsApp() {
    add(new DrawPanel());
  }

  class DrawPanel extends JPanel {
	Random gen=new Random();
	int n=0;
	
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
//      g.drawLine(0, 0, 100, 100);
      int x1=gen.nextInt(500);
      int y1=gen.nextInt(500);
      int x2=gen.nextInt(500);
      int y2=gen.nextInt(500);
      g.drawLine(x1, y1, x2, y2);
      n++;
      g.drawString("n="+n, 10, 10);
    }
  } // class DrawPanel

} // GraphicsApp
