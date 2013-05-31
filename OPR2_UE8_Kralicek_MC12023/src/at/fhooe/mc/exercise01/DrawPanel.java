package at.fhooe.mc.exercise01;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import at.fhooe.mc.exercise01.graphics.Circle;
import at.fhooe.mc.exercise01.graphics.Line;
import at.fhooe.mc.exercise01.graphics.Polygon;
import at.fhooe.mc.exercise01.graphics.Rectangle;
import at.fhooe.mc.exercise01.graphics.Triangle;

/**
 * @author ralfkralicek
 * 
 */
public class DrawPanel extends Panel implements MouseMotionListener,
		MouseListener {
	private static final long serialVersionUID = 1L;
	public static final int Selection = 0;
	public static final int Rectangle = 1;
	public static final int Line = 2;
	public static final int Triangle = 3;
	public static final int Circle = 4;
	public static final int Polygon = 5;
	public static final int ClearAll = 6;
	private int selectedObject = -1;

	private ArrayList<GraphicsPrimitive> shapeList = new ArrayList<GraphicsPrimitive>(); // list
																							// of
																							// all
																							// shapes
	private ArrayList<Point> pointList = new ArrayList<Point>(); // list of the
																	// set
																	// points
	private DrawWindow drw;

	/**
	 * Getting method for the shapeList
	 * 
	 * @return the shapeList
	 */
	public ArrayList<GraphicsPrimitive> getShapeList() {
		return shapeList;
	}

	/**
	 * Setting method for the shapeList
	 * 
	 * @param arrayList
	 */
	public void setShapeList(ArrayList<GraphicsPrimitive> arrayList) {
		this.shapeList = arrayList;
	}

	/**
	 * Getting method if a shape is selected
	 * 
	 * @return true if an shape is selected
	 */
	public int getSelectedObject() {
		return selectedObject;
	}

	/**
	 * Setting method for a shape to select it
	 * 
	 * @param selectedObject
	 *            the selected Object
	 */
	public void setSelectedObject(int selectedObject) {
		if (this.selectedObject == DrawPanel.Selection
				&& selectedObject != DrawPanel.Selection) {
			for (GraphicsPrimitive gp : shapeList) {
				gp.setSelected(false);
			}
		}
		this.selectedObject = selectedObject;
		pointList.clear();
		repaint();
	}

	/**
	 * Constructor for the DrawPanel
	 * 
	 * @param drw
	 *            the DrawWindow where the DrawPanel is placed.
	 */
	public DrawPanel(DrawWindow drw) {
		addMouseMotionListener(this);
		addMouseListener(this);
		this.drw = drw;
	}

	/**
	 * Method to clear the painted shapes.
	 */
	public void clearAll() {
		this.shapeList.clear();
		this.pointList.clear();

		this.repaint();
	}

	
	/**
	 *Method to paint Graphics g out of the shapeList.
	 */
	public void paint(Graphics g) {
		
		switch (this.selectedObject) {
		case DrawPanel.Selection:
			if (pointList.size() > 0) {
				for (GraphicsPrimitive gp : shapeList) {
					if (gp.contains(pointList.get(pointList.size() - 1))) {
						if (!gp.isSelected()) {
							gp.getBoundingBox().draw(g);

						}
						break;
					}
				}
				Point save = pointList.get(pointList.size() - 1);
				pointList.clear();
				pointList.add(save);
			}
			break;

		default:
			for (Point p : pointList) {
				g.fillArc(p.x, p.y, 4, 4, 0, 360);
			}
		}

		for (GraphicsPrimitive gp : shapeList) {
			if (gp.isSelected()) {
				gp.getBoundingBox().draw(g);
			}
			gp.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		pointList.add(new Point(e.getX(), e.getY()));
		repaint();

		switch (this.selectedObject) {
		case DrawPanel.Selection:
			for (GraphicsPrimitive gp : shapeList) {
				if (gp.contains(pointList.get(pointList.size() - 1))) {
					for (GraphicsPrimitive gp1 : shapeList) {
						gp1.setSelected(false);
					}
					gp.setSelected(true);
					repaint();
					break;
				}
			}
			break;

		case DrawPanel.Line:
			if (pointList.size() == 2) {
				shapeList.add(new Line(pointList.get(0), pointList.get(1)));
				pointList.clear();
				repaint();
			}
			break;
		case DrawPanel.Rectangle:
			if (pointList.size() == 2) {
				shapeList
						.add(new Rectangle(pointList.get(0), pointList.get(1)));
				pointList.clear();
				repaint();
			}

		case DrawPanel.Circle:

			if (pointList.size() == 2) {
				shapeList.add(new Circle(pointList.get(0), pointList.get(1)));
				pointList.clear();
				repaint();
			}
			break;

		case DrawPanel.Triangle:
			if (pointList.size() == 3) {
				shapeList.add(new Triangle(pointList.get(0), pointList.get(1),
						pointList.get(2)));
				pointList.clear();
				repaint();
			}

		case DrawPanel.Polygon:
			if (pointList.size() > 2) {
				if (pointList.get(0).distance(
						pointList.get(pointList.size() - 1)) < 10) {
					shapeList.add(new Polygon(pointList));
					pointList.clear();
					repaint();
				}
			}
		}

	}

	/**
	 * Method to delete the selected object.
	 */
	public void delete() {
		if (this.selectedObject == DrawPanel.Selection) {
			for (GraphicsPrimitive gp : shapeList) {
				if (gp.isSelected()) {
					shapeList.remove(gp);
					repaint();
					break;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pointList.add(new Point(e.getX(), e.getY()));
		drw.updateCoordinates(e.getX(), e.getY(), "");

		if (pointList.size() > 1) {
			for (GraphicsPrimitive gp1 : shapeList) {
				if (gp1.isSelected()) {

					if (gp1.contains(pointList.get(0))) {
						gp1.move(e.getX() - pointList.get(0).x, e.getY()
								- pointList.get(0).y);

						repaint();
						break;
					}
				}
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		boolean isTextupdated = false;

		switch (this.selectedObject) {
		case DrawPanel.Selection:
			pointList.add(new Point(e.getX(), e.getY()));
			for (GraphicsPrimitive gp : shapeList) {

				if (gp.contains(new Point(e.getX(), e.getY()))) {

					isTextupdated = true;
					drw.updateCoordinates(e.getX(), e.getY(),
							": " + gp.toString());

				}
			}
			repaint();
			break;
		}
		if (!isTextupdated) {
			drw.updateCoordinates(e.getX(), e.getY(), "");
		}
	}

}
