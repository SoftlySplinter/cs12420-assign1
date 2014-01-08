package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._1;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The contents of the Error Window.
 * @author Alexander Brown
 * @version 0.1.0
 */
@SuppressWarnings("serial")
public class ErrorPanel
extends JPanel
{

	/**
	 * Error Frame link
	 * @uml.property  name="errorFrame"
	 * @uml.associationEnd  
	 */
	private ErrorFrame errorFrame;
	
	/**
	 * JLabel with the error message
	 */
	private JLabel errorContentLabel;
	
	/**
	 * Button to close the window
	 */
	private JButton okButton = new JButton("Close");

	/**
	 * Listener link
	 * @uml.property  name="errorListener"
	 * @uml.associationEnd  
	 */
	private ErrorListener errorListener = new ErrorListener(this);
	
	/**
	 * Constructor
	 * @param e The Error Frame it is attached to
	 * @param message The Error message to be passed in
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
	 * Closes the frame by passing the method upwards
	 */
	public void closeFrame()
	{
		errorFrame.closeFrame();
	}
}
