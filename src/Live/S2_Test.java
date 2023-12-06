package Live;

import javax.swing.*;
import java.awt.*;

public class S2_Test extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new S2_Test();
    frame.setSize(700, 700);
    frame.setTitle("GraphicsApp");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public S2_Test() {
    add(new DrawPanel());
  }

  class DrawPanel extends JPanel {
    S2 S=new S2(50,50, 100,300);
	
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      S.drawAxis(g);
      S.drawString(g, "Hej Hej", new V2(5,0));
      S.drawLine(g, new V2(0,0), new V2(1,1));
    }
  } // class DrawPanel

} // GraphicsApp
