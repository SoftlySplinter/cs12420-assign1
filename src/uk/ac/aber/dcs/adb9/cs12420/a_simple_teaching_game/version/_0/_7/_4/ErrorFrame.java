package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._4;

import java.awt.BorderLayout;

/**
 * Defines an Error Window.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see ErrorPanel
 * @see SimpleFrame
 */
@SuppressWarnings("serial")
public class ErrorFrame
extends SimpleFrame
{
	/**
	 * The Error Panel link
	 * @see ErrorPanel
	 * @see <!--
	 * @uml.property  name="errorPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private ErrorPanel errorPanel;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Formats the layout of the Frame and adds the Error Panel to it. Also passes in the error message.
	 * 
	 * @param message The Error Message to be displayed.
	 * 
	 * @see ErrorPanel
	 */
	public ErrorFrame(String message)
	{
		//Sets up the Error Panel
		errorPanel = new ErrorPanel(this,message);
		
		//General Frame work
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("A Simple Game - Error");
		
		this.setOnTop();
		
		//Add the Error Panel
		this.add(errorPanel,BorderLayout.CENTER);
		
		//Format the layout
		this.formatLayout();
		
		//pack
		this.pack();
	}
	
	/**
	 * Closes the frame.
	 * 
	 * @see SimpleFrame#hideFrame()
	 */
	public void closeFrame()
	{
		this.hideFrame();
	}
}
