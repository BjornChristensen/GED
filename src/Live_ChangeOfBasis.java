import javax.swing.*;
import java.awt.*;

public class Live_ChangeOfBasis extends JFrame {

  public static void main(String[] args) {
    Live_ChangeOfBasis frame = new Live_ChangeOfBasis();
    frame.setSize(1000, 700);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setTitle("ChangeOfBasis");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public Live_ChangeOfBasis() {
    add(new DrawPanel());
  }

  class DrawPanel extends JPanel {
    S2 S=new S2(50,50, 100,300);
    V2 P=new V2(5,3);
    S2 Sm=new S2(50,50, 100,300);
    V2 Pm=new V2(2*Math.sqrt(2), -Math.sqrt(2));

    DrawPanel(){
      Sm.moveTo(new V2(2,2));
      Sm.rotate(Math.PI/4);
    }

    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      S.drawAxis(g);
      Sm.drawAxis(g);
      S.drawPoint(g, P, Color.BLUE, 8);
      Sm.drawPoint(g, Pm, Color.YELLOW, 4);
    }
  }
}
