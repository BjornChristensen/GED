package Java2D_Graphics;
// Eksempel PolyShapes.java
// Demo af grafiktegning, polymorfi og inner classes
// Bj�rn Christensen, 30/10-2020

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class PolyShapes extends JFrame {
	PaintPanel panel = new PaintPanel();

	PolyShapes() {
		add(panel);
	} // Constructor

	public static void main(String[] args) {
		PolyShapes frame = new PolyShapes();
		frame.setTitle("PolyShapes");
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

	class PaintPanel extends JPanel {
		ArrayList<Shape> list=new ArrayList<Shape>();
		
		PaintPanel() {
			list.add(new Point(200,100));
			list.add(new Line(10,10, 100,150));
			list.add(new Triangle(100,200, 200,200, 200,400));
			list.add(new Square(300,100, 50));
			list.add(new Circle(300,300, 50));
			list.add(new Star(500,100, 50));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Shape s:list)
				s.draw(g);
		}
	} // class PaintPanel
	
	abstract class Shape {
		abstract void draw(Graphics g);
	}
	
	class Point extends Shape {
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
		void draw(Graphics g) {
			g.fillOval(x-1, y-1, 3, 3);
		}
	}
	
	class Line extends Shape {
		int x1,y1;
		int x2,y2;
		Line(int x1, int y1, int x2, int y2){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
		}
		void draw(Graphics g) {
			g.drawLine(x1, y1, x2, y2);
		}
	}

	class Triangle extends Shape {
		int x1,y1;
		int x2,y2;
		int x3,y3;
		Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.x3=x3;
			this.y3=y3;
		}
		void draw(Graphics g) {
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x2, y2, x3, y3);
			g.drawLine(x3, y3, x1, y1);
		}
	}

	class Square extends Shape {
		int x,y;			// Top left corner
		int l;				// Length of all sides
		Square(int x, int y, int l){
			this.x=x;
			this.y=y;
			this.l=l;
		}
		void draw(Graphics g) {
			g.drawRect(x, y, l, l);
		}
	}
	
	class Circle extends Shape {
		int x,y;				// Center
		int r;					// Radius
		Circle(int x, int y, int r){
			this.x=x;
			this.y=y;
			this.r=r;
		}
		void draw(Graphics g) {
			g.fillOval(x, y, 1, 1);
			g.drawOval(x-r, y-r, 2*r, 2*r);
		}
	}
	
	class Star extends Circle {
		Star(int x, int y, int r){
			super(x,y,r);
		}
		void draw(Graphics g) {
//			g.drawOval(x-r, y-r, 2*r, 2*r);
			int x1=(int)(x+r*Math.cos(-Math.PI/2));
			int y1=(int)(y+r*Math.sin(-Math.PI/2));
			int x2=(int)(x+r*Math.cos(2*Math.PI*(1.0/5)-Math.PI/2));
			int y2=(int)(y+r*Math.sin(2*Math.PI*(1.0/5)-Math.PI/2));
			int x3=(int)(x+r*Math.cos(2*Math.PI*(2.0/5)-Math.PI/2));
			int y3=(int)(y+r*Math.sin(2*Math.PI*(2.0/5)-Math.PI/2));
			int x4=(int)(x+r*Math.cos(2*Math.PI*(3.0/5)-Math.PI/2));
			int y4=(int)(y+r*Math.sin(2*Math.PI*(3.0/5)-Math.PI/2));
			int x5=(int)(x+r*Math.cos(2*Math.PI*(4.0/5)-Math.PI/2));
			int y5=(int)(y+r*Math.sin(2*Math.PI*(4.0/5)-Math.PI/2));
			g.drawLine(x1, y1, x3, y3);
			g.drawLine(x3, y3, x5, y5);
			g.drawLine(x5, y5, x2, y2);
			g.drawLine(x2, y2, x4, y4);
			g.drawLine(x4, y4, x1, y1);
		}
	}
	
} // class JFrame