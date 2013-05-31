package at.fhooe.mc.exercise01;

import java.awt.Graphics;
import java.awt.Point;

import at.fhooe.mc.exercise01.graphics.Rectangle;

/**
 * @author ralfkralicek
 * 
 */
public abstract class GraphicsPrimitive {

	private boolean selected;

	/**
	 * Method to return true if the shape is selected.
	 * 
	 * @return true if the shape is selected false otherwise.
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Method to set a shape selected.
	 * 
	 * @param selected
	 *            true to select the object false otherwise.
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Method which returns the necessary points of the shape as string.
	 */
	public abstract String toString();

	/**
	 * Method to move shapes.
	 * 
	 * @param dx
	 *            the x-difference to move
	 * @param dy
	 *            the y-difference to move
	 */
	public abstract void move(int dx, int dy);

	/**
	 * Method to draw the Graphics g.
	 * 
	 * @param g
	 *            shape to draw
	 */
	public abstract void draw(Graphics g);

	/**
	 * Method to clone the shape at the same position.
	 */
	public abstract GraphicsPrimitive clone();

	/**
	 * This method returns a encircling rectangle shape for the selected shape
	 * 
	 * @return a encircling rectangle for the selected shape
	 */
	public abstract Rectangle getBoundingBox();

	/**
	 * This method returns true if the point p is in the shape contained
	 * otherwise false;
	 * 
	 * @param point
	 *            the given point p
	 * @return
	 */
	public abstract boolean contains(Point point);

}
