package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._5._0;

import java.awt.BorderLayout;

/**
 * Error Window
 * @author Alexander Brown
 * @version 0.1.0
 */
@SuppressWarnings("serial")
public class ErrorFrame
extends SimpleFrame
{
	/**
	 * The Game Frame the Error can be attached to
	 * @uml.property  name="gameFrame"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private GameFrame gameFrame;

	/**
	 * The Error Panel link
	 * @uml.property  name="errorPanel"
	 * @uml.associationEnd  
	 */
	private ErrorPanel errorPanel;
	
	/**
	 * Constructor for the Game Error messages
	 * @param g The Game Frame it comes from
	 * @param message The Error Message to be displayed
	 */
	public ErrorFrame(GameFrame g,String message)
	{
		errorPanel = new ErrorPanel(this,message);
		gameFrame = g;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("A Simple Game - Error");
		
		this.add(errorPanel,BorderLayout.CENTER);
		this.formatLayout();
		
		this.pack();
	}
	
	/**
	 * Closes the frame.
	 * <br />
	 * <small><b>Note:</b> this does dispose of the frame rather than hide it and is intentional.</small>
	 */
	public void closeFrame()
	{
		this.dispose();
	}
}
