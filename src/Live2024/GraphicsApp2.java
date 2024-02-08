package Live2024;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GraphicsApp2 extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new GraphicsApp2();
        frame.setSize(700, 700);
        frame.setTitle("GraphicsApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    public GraphicsApp2() {
        add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        S2 S=new S2(50,50, 120,300);
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(170-5, 200-5, 10, 10);
            S.drawLine(g, new V2(0,0), new V2(1,2));
            S.drawAxis(g);
        }
    } // class DrawPanel

} // GraphicsApp
