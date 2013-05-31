package at.fhooe.mc.exercise01.graphics;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import at.fhooe.mc.exercise01.GraphicsPrimitive;

public class Polygon extends GraphicsPrimitive {
	private int[] px;
	private int[] py;
	private ArrayList<Point> pointlist;

	public Polygon(ArrayList<Point> pointList) {
		super();
		px = new int[pointList.size()];
		py = new int[pointList.size()];
		this.pointlist = pointList;
		for (int i = 0; i <= pointList.size() - 1; i++) {
			px[i] = pointList.get(i).x;
			py[i] = pointList.get(i).y;
		}
	}

	@Override
	public void move(int dx, int dy) {
		for (int i = 0; i <=px.length - 1; i++) {
			px[i] += dx;
			py[i] += dy;
		}

	}

	@Override
	public void draw(Graphics g) {
		g.drawPolygon(px, py, px.length);

	}

	@Override
	public GraphicsPrimitive clone() {

		return new Polygon(new ArrayList<Point>(pointlist));
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

		Point p1 = new Point(smallestx, smallesty);
		Point p2 = new Point(biggestx, biggesty);

		return new Rectangle(p1, p2);
	}

	@Override
	public boolean contains(Point point) {

		return getBoundingBox().contains(point);
	}

	@Override
	public String toString() {
		StringBuffer text = new StringBuffer();
		text.append("Polygon:");
		for (int i = 0; i < px.length - 1; i++) {

			text.append("(");
			text.append(px[i]);
			text.append(",");
			text.append(py[i]);
			text.append(")");
		}
		return text.toString();
	}

}
