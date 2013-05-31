package at.fhooe.mc.exercise01.graphics;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import at.fhooe.mc.exercise01.GraphicsPrimitive;

public class Rectangle extends GraphicsPrimitive {
	private Point p1;
	private Point p2;

	public Rectangle(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	@Override
	public void move(int dx, int dy) {
		p1.x += dx;
		p1.y += dy;

		p2.x += dx;
		p2.y += dy;

	}

	@Override
	public void draw(Graphics g) {
		int width = 0;
		int height = 0;
		int py = 0;
		int px = 0;

		if (p1.x < p2.x) {
			width = p2.x - p1.x;
			px = p1.x;
		} else {
			width = p1.x - p2.x;
			px = p2.x;
		}

		if (p1.y < p2.y) {
			height = p2.y - p1.y;
			py = p1.y;
		} else {
			height = p1.y - p2.y;
			py = p2.y;
		}

		g.drawRect(px, py, width, height);

	}

	@Override
	public GraphicsPrimitive clone() {

		return new Rectangle(new Point(p1), new Point(p2));
	}

	@Override
	public Rectangle getBoundingBox() {
		int width = 0;
		int height = 0;
		int py = 0;
		int px = 0;

		if (p1.x < p2.x) {
			width = p2.x - p1.x;
			px = p1.x;
		} else {
			width = p1.x - p2.x;
			px = p2.x;
		}

		if (p1.y < p2.y) {
			height = p2.y - p1.y;
			py = p1.y;
		} else {
			height = p1.y - p2.y;
			py = p2.y;
		}
		py -= 1;
		px -= 1;
		width += 2;
		height += 2;
		return new Rectangle(new Point(px, py), new Point(px + width, py
				+ height));

	}

	@Override
	public boolean contains(Point point) {
		int width = 0;
		int height = 0;
		int py = 0;
		int px = 0;

		if (p1.x < p2.x) {
			width = p2.x - p1.x;
			px = p1.x;
		} else {
			width = p1.x - p2.x;
			px = p2.x;
		}

		if (p1.y < p2.y) {
			height = p2.y - p1.y;
			py = p1.y;
		} else {
			height = p1.y - p2.y;
			py = p2.y;
		}

		return new Rectangle2D.Double(px, py, width, height).contains(point.x,
				point.y);
	}

	@Override
	public String toString() {
		int width = 0;
		int height = 0;
		int py = 0;
		int px = 0;

		if (p1.x < p2.x) {
			width = p2.x - p1.x;
			px = p1.x;
		} else {
			width = p1.x - p2.x;
			px = p2.x;
		}

		if (p1.y < p2.y) {
			height = p2.y - p1.y;
			py = p1.y;
		} else {
			height = p1.y - p2.y;
			py = p2.y;
		}
		return "Rectangle: X=" + px + " Y=" + py + " W=" + width + " H="
				+ height;
	}

}
