package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for an Error Message.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see ErrorPanel
 */
public class ErrorListener
implements ActionListener
{
	/**
	 * The Error Panel link.
	 * 
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
	 * Links back to the Error Panel
	 * 
	 * @param e The Error Panel to link back to
	 * 
	 * @see ErrorPanel
	 */
	public ErrorListener(ErrorPanel e)
	{
		errorPanel = e;
	}
	
	/**
	 * Action Performed event.
	 * @param e The Event being passed in
	 * 
	 * @see ErrorPanel#closeFrame()
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//get the action performed
		String actionPerformed = e.getActionCommand();
		
		if(actionPerformed.equals("Close"))
		{
			errorPanel.closeFrame();
		}
	}
}
