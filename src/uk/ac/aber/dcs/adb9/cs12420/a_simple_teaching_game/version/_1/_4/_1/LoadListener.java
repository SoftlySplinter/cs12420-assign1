package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for the Loader.
 * 
 * @author Alexander Brown
 * @version 0.0.1
 * 
 * @see LoadPanel
 * @see ActionListener
 */
public class LoadListener
implements ActionListener
{

	/**
	 * The Load Panel to link back to.
	 * @see LoadPanel
	 * @see         <!--
	 * @uml.property  name="loadPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private LoadPanel loadPanel;
	
	/**
	 * Sets up the link back to the Load Panel.
	 * @see LoadPanel
	 * @param l The Load Panel to link back to.
	 */
	public LoadListener(LoadPanel l)
	{
		loadPanel = l;
	}
	
	/**
	 * Action Performed Event.
	 * 
	 * <br /><br />
	 * 
	 * Runs specified actions when buttons are pressed
	 * 
	 * @param e The Action Event to take from
	 * 
	 * @see ActionEvent
	 * @see ActionListener
	 * @see <br />
	 * @see LoadPanel#loadRoutine()
	 * @see LoadPanel#close()
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Gets the name of the button
		String actionPerformed = e.getActionCommand();
		
		//If it was OK
		if(actionPerformed.equals("OK"))
		{
			//Pass the load method upward
			loadPanel.loadRoutine();
		}
		//If it was cancel
		else if(actionPerformed.equals("Cancel"));
		{
			//Pass the close method upward
			loadPanel.close();
		}
	}
}
