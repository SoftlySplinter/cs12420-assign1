package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._1;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A Simple Frame from which all other frames can inherit.
 * @author Alexander Brown
 * @version 1.0.1
 */
@SuppressWarnings("serial")
public abstract class SimpleFrame
extends JFrame
{
	/**
	 * North Panel
	 */
	JPanel n = new JPanel();
	/**
	 * South Panel
	 */
	JPanel s = new JPanel();
	/**
	 * East Panel
	 */
	JPanel e = new JPanel();
	/**
	 * West Panel
	 */
	JPanel w = new JPanel();
	
	//Define fonts
	/**
	 * Defines a small font
	 */
	public static final Font small = new Font("Arial", Font.PLAIN, 10);
	
	/**
	 * Defines a large font
	 */
	public static final Font big = new Font("Arial", Font.BOLD, 14);
	
	/**
	 * Defines the default font
	 */
	public static final Font normal = new Font("Arial", Font.PLAIN, 12);
	
	/**
	 * Empty Constructor for a Simple Frame.
	 */
	public SimpleFrame()
	{
		//Does nothing
	}
	
	/**
	 * Constructor for a Simple Frame.
	 * @param n Title of the frame
	 */
	public SimpleFrame(String n)
	{
		this.setTitle(n);
	}
	
	/**
	 * Formats the layout so every frame is the same
	 */
	public void formatLayout()
	{
		//Add the layout items.
		this.add(n,BorderLayout.NORTH);
		this.add(s,BorderLayout.SOUTH);
		this.add(e,BorderLayout.EAST);
		this.add(w,BorderLayout.WEST);

		//Sets the location
		this.setLocation(250,100);
	}
	
	/**
	 * Shows the Frame
	 */
	public void showFrame()
	{
		this.setVisible(true);
	}
	
	/**
	 * Hides the Frame
	 */
	public void hideFrame()
	{
		this.setVisible(false);
	}
}
