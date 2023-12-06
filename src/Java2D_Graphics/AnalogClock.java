package Java2D_Graphics;
// L�sning til opgave 10.3_4 i "Objektorienteret programmering i JAVA" 6.udg
// Bj�rn Christensen 18/3 2020

import java.awt.event.*;
import java.time.LocalTime;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.*;

public class AnalogClock extends JFrame {
	PaintPanel panel = new PaintPanel();

	AnalogClock() {
		add(panel);
	} // Constructor

	public static void main(String[] args) {
		AnalogClock frame = new AnalogClock();
		frame.setTitle("Analog Clock");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

	class PaintPanel extends JPanel {
		Timer myTimer = new Timer(100, new TimerListener());

		PaintPanel() {
			myTimer.start();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w=getWidth();						// Henter vinduets aktuelle st�rrelse
			int h=getHeight();
			int cx=w/2;									// Find centrum af vinduet
			int cy=h/2;
			int r=(int)(Math.min(w, h)/2*0.8);	// Radius af urskiven
			
			LocalTime now=LocalTime.now();
			g.drawString("Time: "+now, 10, 20);		

			// Tegn urskiven
			g.drawOval(cx-r, cy-r, 2*r, 2*r);		
			for (int i=1; i<=12; i++) {
				double deg=2*Math.PI*(i/12.0);
				deg+=Math.PI/2;										// Vinkel 0 er lodret
				int x1=(int)(cx-Math.cos(deg)*0.9*r);
				int y1=(int)(cy-Math.sin(deg)*0.9*r);		
				int x2=(int)(cx-Math.cos(deg)*1.0*r);
				int y2=(int)(cy-Math.sin(deg)*1.0*r);		
				int x3=(int)(cx-Math.cos(deg)*1.15*r);
				int y3=(int)(cy-Math.sin(deg)*1.15*r);		
				g.drawLine(x1, y1, x2, y2);				// Ticks
				g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
				String str=i+"";
				FontMetrics metrics=g.getFontMetrics();
				int fh=metrics.getHeight();
				int fw=metrics.charsWidth(str.toCharArray(), 0, str.length());
				g.drawString(str, x3-fw/2, y3+fh/3);				// Tal
			}
			
			// Sekundviser
			double deg=2*Math.PI*(now.getSecond()/60.0);
			deg+=Math.PI/2;										// Vinkel 0 er lodret
			int x=(int)(cx-Math.cos(deg)*r);
			int y=(int)(cy-Math.sin(deg)*r);
			g.drawLine(cx, cy, x, y);
			
			// Minutviser
			deg=2*Math.PI*(now.getMinute()/60.0);
			deg+=2*Math.PI*(now.getSecond()/(60.0*60.0)); // Lad minutviser bev�ge sig en lille smule sammen med sekundviseren
			deg+=Math.PI/2;
			x=(int)(cx-Math.cos(deg)*r*0.75);
			y=(int)(cy-Math.sin(deg)*r*0.75);
			g.drawLine(cx, cy, x, y);

			// Timeviser
			deg=2*Math.PI*(now.getHour()/12.0);
			deg+=2*Math.PI*(now.getMinute()/(60.0*12.0)); // Lad timeviser bev�ge sig en lille smule sammen med minutviseren
			deg+=Math.PI/2;
			x=(int)(cx-Math.cos(deg)*r*0.5);
			y=(int)(cy-Math.sin(deg)*r*0.5);
			g.drawLine(cx, cy, x, y);
		}

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		}
	} // class PaintPanel

} // class JFrame