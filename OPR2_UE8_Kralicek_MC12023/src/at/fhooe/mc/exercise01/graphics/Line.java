package at.fhooe.mc.exercise01.graphics;

import java.awt.Graphics;
import java.awt.Point;
import at.fhooe.mc.exercise01.GraphicsPrimitive;

public class Line extends GraphicsPrimitive {

	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2) {
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
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	@Override
	public GraphicsPrimitive clone() {
		return new Line(new Point(p1), new Point(p1));
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.p1, this.p2);
	}

	@Override
	public boolean contains(Point point) {
		return getBoundingBox().contains(point);
	}

	@Override
	public String toString() {

		return "Line: P1=(" + (int) p1.getX() + "," + (int) p1.getY()
				+ ") P2=(" + (int) p2.getX() + "," + (int) p2.getY() + ")";
	}

}
