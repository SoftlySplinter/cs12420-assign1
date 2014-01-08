package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._3;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contains the contents of the Error Window.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see ErrorFrame
 * @see ErrorListener
 */
@SuppressWarnings("serial")
public class ErrorPanel
extends JPanel
{

	/**
	 * Link back to the Error Frame.
	 * @see ErrorFrame
	 * 
	 * @see <!--
	 * @uml.property  name="errorFrame"
	 * @uml.associationEnd  
	 * -->
	 */
	private ErrorFrame errorFrame;
	
	/**
	 * JLabel with the error message.
	 */
	private JLabel errorContentLabel;
	
	/**
	 * Button to close the window
	 */
	private JButton okButton = new JButton("Close");

	/**
	 * Error Listener link.
	 * 
	 * @see ErrorListener
	 * @see <!--
	 * @uml.property  name="errorListener"
	 * @uml.associationEnd 
	 * --> 
	 */
	private ErrorListener errorListener = new ErrorListener(this);
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Links back to the Error Frame, adds and formats the contents of an Error Message. Also adds an Error Listener to any buttons.
	 * 
	 * @param e The Error Frame it is attached to.
	 * @param message The Error message to be passed in.
	 * 
	 * @see ErrorFrame
	 * @see ErrorListener
	 */
	public ErrorPanel(ErrorFrame e, String message)
	{
		errorFrame = e;
		//Grid Layout for two things one under the other.
		this.setLayout(new GridLayout(2,1,5,5));
		
		//Adding elements in panels so they're centred and don't take up the entire space.
		JPanel panel1 = new JPanel();
		errorContentLabel = new JLabel(message);
		errorContentLabel.setFont(ErrorFrame.normal);
		panel1.add(errorContentLabel,BorderLayout.CENTER);
		this.add(panel1);
		
		//As with above
		JPanel panel2 = new JPanel();
		//okButton.setFont(ErrorFrame.normal);
		panel2.add(okButton,BorderLayout.CENTER);
		okButton.addActionListener(errorListener);
		this.add(panel2);
	}

	/**
	 * Passes the method upwards.
	 * @see ErrorFrame#closeFrame()
	 */
	public void closeFrame()
	{
		errorFrame.closeFrame();
	}
}
