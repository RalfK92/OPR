package at.fhooe.mc.exercise01.graphics;

import java.awt.Graphics;
import java.awt.Point;

import at.fhooe.mc.exercise01.GraphicsPrimitive;

public class Triangle extends GraphicsPrimitive {

	private Point p1;
	private Point p2;
	private int[] px = new int[3];
	private int[] py = new int[3];

	public Triangle(Point p1, Point p2, Point p3) {
		super();
		this.px[0] = p1.x;
		this.px[1] = p2.x;
		this.px[2] = p3.x;

		this.py[0] = p1.y;
		this.py[1] = p2.y;
		this.py[2] = p3.y;

	}

	@Override
	public void move(int dx, int dy) {
		this.px[0] += dx;
		this.px[1] += dx;
		this.px[2] += dx;

		this.py[0] += dy;
		this.py[1] += dy;
		this.py[2] += dy;
	}

	@Override
	public void draw(Graphics g) {
		g.drawPolygon(px, py, px.length);

	}

	@Override
	public GraphicsPrimitive clone() {

		return new Triangle(new Point(px[0], py[0]), new Point(px[1], py[1]),
				new Point(px[2], py[2]));
	}

	@Override
	public Rectangle getBoundingBox() {
		int smallestx = Integer.MAX_VALUE;
		int smallesty = Integer.MAX_VALUE;
		int biggesty = Integer.MIN_VALUE;
		int biggestx = Integer.MIN_VALUE;
		for (int i = 0; i <= px.length - 1; i++) {
			if (px[i] < smallestx) {
				smallestx = px[i];
			}
		}
		for (int i = 0; i <= py.length - 1; i++) {
			if (py[i] < smallesty) {
				smallesty = py[i];
			}
		}
		for (int i = 0; i <= px.length - 1; i++) {
			if (px[i] > biggestx) {
				biggestx = px[i];
			}
		}
		for (int i = 0; i <= py.length - 1; i++) {
			if (py[i] > biggesty) {
				biggesty = py[i];
			}
		}

		p1 = new Point(smallestx, smallesty);
		p2 = new Point(biggestx, biggesty);

		return new Rectangle(p1, p2);
	}

	@Override
	public boolean contains(Point point) {
		return getBoundingBox().contains(point);
	}

	@Override
	public String toString() {

		String text = "Triangle: P1(" + px[0] + "," + py[0] + ") P2(" + px[1]
				+ "," + py[1] + ") P3(" + px[2] + "," + py[2] + ")";

		return text;
	}

}
