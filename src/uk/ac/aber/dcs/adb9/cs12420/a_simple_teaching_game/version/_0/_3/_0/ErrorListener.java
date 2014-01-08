package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._3._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for the Error Pop-up
 * @author Alexander Brown
 * @version 0.1.0
 */
public class ErrorListener
implements ActionListener
{
	/**
	 * The Error Panel link.
	 * @uml.property  name="errorPanel"
	 * @uml.associationEnd  
	 */
	private ErrorPanel errorPanel;
	
	/**
	 * Constructor
	 * @param e The Error Panel
	 */
	public ErrorListener(ErrorPanel e)
	{
		errorPanel = e;
	}
	
	/**
	 * Action Performed event.
	 * @param e The Event being passed in
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String actionPerformed = e.getActionCommand();
		
		if(actionPerformed.equals("Close"))
		{
			errorPanel.closeFrame();
		}
	}
}
