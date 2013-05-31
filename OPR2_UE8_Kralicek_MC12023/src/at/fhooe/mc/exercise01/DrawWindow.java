package at.fhooe.mc.exercise01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author ralfkralicek
 *
 */
public class DrawWindow extends java.awt.Frame implements WindowListener,
		MouseListener {

	private static final long serialVersionUID = 1L;

	static Label MOUSECOORDINATES = new Label(); // label for the
													// mousecoordinates

	private DrawPanel drawPanel = new DrawPanel(this);

	/**
	 * Constructor for the DrawWindow
	 */
	public DrawWindow() {
		Panel m_Buttons = new Panel();
		setSize(800, 1000);
		addWindowListener(this);
		setLayout(new BorderLayout());
		Button m_Selection = new Button("Selection");
		m_Selection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setSelectedObject(DrawPanel.Selection);
			}
		});
		Button m_Rectangle = new Button("Rectangle");
		m_Rectangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setSelectedObject(DrawPanel.Rectangle);
			}
		});
		Button m_Circle = new Button("Circle");
		m_Circle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setSelectedObject(DrawPanel.Circle);

			}
		});
		Button m_Line = new Button("Line");
		m_Line.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setSelectedObject(DrawPanel.Line);
			}
		});
		Button m_Triangle = new Button("Triangle");
		m_Triangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setSelectedObject(DrawPanel.Triangle);
			}
		});
		Button m_Polygon = new Button("Polygon");
		m_Polygon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setSelectedObject(DrawPanel.Polygon);

			}
		});
		Button m_Delete = new Button("Delete");
		m_Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.delete();
			}
		});

		Button m_ClearAll = new Button("Clear All");
		m_ClearAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.clearAll();
			}
		});

		m_Buttons.setLocation(100, 100);
		m_Buttons.setLayout(new FlowLayout());

		m_Buttons.add(m_Selection);
		m_Buttons.add(m_Rectangle);
		m_Buttons.add(m_Circle);
		m_Buttons.add(m_Line);
		m_Buttons.add(m_Triangle);
		m_Buttons.add(m_Polygon);
		m_Buttons.add(m_Delete);
		m_Buttons.add(m_ClearAll);

		drawPanel.setBackground(Color.WHITE);
		add(m_Buttons, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);

		drawPanel.add(MOUSECOORDINATES);

	}

	/**
	 * Method to update the mouse-coordinates.
	 * 
	 * @param x
	 *            the x coordinate of the mouse.
	 * @param y
	 *            the y coordinate of the mouse.
	 * @param text
	 *            optional if the cursor get over an GraphicsPrimitives
	 */
	public void updateCoordinates(int x, int y, String text) {

		MOUSECOORDINATES.setText("(" + x + "," + y + ")" + text);

		validate();
		MOUSECOORDINATES.setLocation(x + 10, y);
		repaint();

	}

	/**
	 * Method to return the DrawWindow
	 * @return the DrawWindow
	 */
	public DrawWindow getDrawWindow() {
		return this;
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowClosed(WindowEvent e) {
		

	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		

	}

	@Override
	public void windowActivated(WindowEvent e) {
		

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}

}
