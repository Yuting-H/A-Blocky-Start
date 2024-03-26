package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This builder class makes JPanels. 
 * @version 1.0
 * @since March 10, 2024
 * @author Yuting Hou
 * @author Chun Ho Chan (Edward)
 */
public class PanelUI extends JPanel {

	/**
	 * @deprecated
	 * @param bound
	 */
	PanelUI(Rectangle bound) {
		setLayout(null);
		setBounds(bound);
		setVisible(true);
		setBackground(Color.gray);
	}

	/**
	 * Constructor for panel whose location is managed by layout manager.
	 * @param size
	 */
	PanelUI(Dimension size) {
		setLayout(null);
		setSize(size);
		setPreferredSize(size);
		setVisible(true);
		setBackground(Color.gray);
	}

	/**
	 * Constructor for panel whose location is managed by layout manager.
	 * @param size
	 * @param color
	 */
	PanelUI(Dimension size, Color color) {
		setLayout(null);
		setSize(size);
		setPreferredSize(size);
		setVisible(true);
		setBackground(color);
	}
	
	/**
	 * Construct a default JPanel without any LayoutManager.<br>
	 * Used by GameplayView.<br>
	 * @param visibility Visibility
	 * @param dimension Dimension
	 * @param position Position
	 * @param bgColor Background color
	 */
	public PanelUI(boolean visibility, Dimension dimension, Point position, Color bgColor) {
		setLayout(null);
		setVisible(visibility);
		setSize(dimension);
		setLocation(position);
		setBackground(bgColor);
	}

}
