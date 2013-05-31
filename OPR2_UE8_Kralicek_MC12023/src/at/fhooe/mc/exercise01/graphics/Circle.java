package at.fhooe.mc.exercise01.graphics;

import java.awt.Graphics;
import java.awt.Point;

import at.fhooe.mc.exercise01.GraphicsPrimitive;

public class Circle extends GraphicsPrimitive {

	private Point p1;
	private Point p2;

	/**
	 * Constructor for the circle.
	 * @param p1 the middle-point of the circle
	 * @param p2 on point at the circumference of the circle
	 */
	public Circle(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void move(int dx, int dy) {
		p1.x = (int) (p1.getX() + dx);
		p1.y = (int) (p1.getY() + dy);

		p2.x = (int) (p2.getX() + dx);
		p2.y = (int) (p2.getY() + dy);

	}

	@Override
	public void draw(Graphics g) {
		int radius = (int) p1.distance(p2);

		int py = p1.y - radius;
		int px = p1.x - radius;

		g.drawArc(px, py, radius + radius, radius + radius, 0, 360);

	}

	
	@Override
	public GraphicsPrimitive clone() {

		return new Circle(new Point(p1), new Point(p2));
	}

	@Override
	public Rectangle getBoundingBox() {
		int radius = (int) p1.distance(p2);

		int p1y = p1.y - radius;
		int p1x = p1.x - radius;

		int p2y = p1.y + radius;
		int p2x = p1.x + radius;
		Point p1new = new Point(p1x, p1y);
		Point p2new = new Point(p2x, p2y);

		return new Rectangle(p1new, p2new);
	}

	@Override
	public boolean contains(Point point) {

		return getBoundingBox().contains(point);
	}

	@Override
	public String toString() {
		int radius = (int) p1.distance(p2);

		return "Circle: M=(" + (int) p1.getX() + "," + (int) p1.getY() + " R="
				+ (int) radius;
	}

}
