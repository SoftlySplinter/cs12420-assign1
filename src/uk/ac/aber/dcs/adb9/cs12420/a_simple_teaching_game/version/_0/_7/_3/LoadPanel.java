package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._3;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Defines the main contents of the Loading Frame.
 * 
 * @author Alexander Brown
 * @version 0.0.1
 * 
 * @see LoadFrame
 * @see LoadListener
 */
@SuppressWarnings("serial")
public class LoadPanel
extends JPanel
{

	/**
	 * Link back to the Load Frame
	 * @see LoadFrame
	 * @see         <!--
	 * @uml.property  name="loadFrame"
	 * @uml.associationEnd  
	 * -->
	 */
	private LoadFrame loadFrame;
	
	/**
	 * Link to the Load Listener
	 * @see LoadListener
	 * @see         <!--
	 * @uml.property  name="loadListener"
	 * @uml.associationEnd  
	 * -->
	 */
	private LoadListener loadListener = new LoadListener(this);
	
	/**
	 * Text Field for entering in a filename.
	 * @see JTextField
	 */
	private JTextField filenameField = new JTextField(15);
	/**
	 * Browse Button, allows searching of file system for a file.
	 * 
	 * <br /><br />
	 * 
	 * <!--TODO-->Does nothing yet.
	 */
	private JButton browseButton = new JButton("...");
	
	/**
	 * Okay button, when pressed loads the specified file.
	 */
	private JButton loadButton = new JButton("OK");
	/**
	 * Cancel Buttons, returns to the main menu without loading.
	 */
	private JButton cancelButton = new JButton("Cancel");

	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the Panel and adds Listeners to buttons.
	 * 
	 * @param l The Load Frame to link back to.
	 * @see LoadFrame
	 * @see LoadListener
	 */
	public LoadPanel(LoadFrame l)
	{
		//Link back to the Load Frame
		loadFrame = l;
		
		//Sets the Grid Layout
		this.setLayout(new GridLayout(2,1,5,5));
		
		//Top part of the Panel held within another JPanel
		JPanel panel1 = new JPanel();
		//Adds the Field and Browse button to this panel
		panel1.add(filenameField);
		panel1.add(browseButton);
		//Set up the Listener on the button
		browseButton.addActionListener(loadListener);
		//Adds the panel
		this.add(panel1);
		
		//Same principle for the second half of the panel
		JPanel panel2 = new JPanel();
		//Sets this one to have a grid layout
		panel2.setLayout(new GridLayout(1,2,0,5));
		
		//Another panel to stop bad resizing of the contained button
		JPanel panel3 = new JPanel();
		//Add the Okay Button to this frame
		panel3.add(loadButton);
		//and a Listener to the button
		loadButton.addActionListener(loadListener);
		//Then the panel this button's in to the other panel
		panel2.add(panel3);
		
		//Repeat with the Cancel button
		JPanel panel4 = new JPanel();
		panel4.add(cancelButton);
		cancelButton.addActionListener(loadListener);
		panel2.add(panel4);
		this.add(panel2);
		
		//Notes: Yes it's a bit of a dodgy way around, but it looks much nices
	}
	
	/**
	 * Passes the value of the text field up to the Frame.
	 * @see LoadFrame#loadRoutine(String)
	 */
	public void loadRoutine()
	{
		loadFrame.loadRoutine(filenameField.getText());
	}
	
	/**
	 * Passes the close method up.
	 * @see LoadFrame#close()
	 */
	public void close()
	{
		loadFrame.close();
	}
}
