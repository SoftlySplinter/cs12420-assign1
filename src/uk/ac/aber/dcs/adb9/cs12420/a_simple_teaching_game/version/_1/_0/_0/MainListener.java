package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._0._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for the Main Menu.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see MainPanel
 */
public class MainListener
implements ActionListener
{

	/**
	 * Link back to the Main Panel
	 * @see  MainPanel
	 * @see <!--
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private MainPanel mainPanel;
	
	/**
	 * Constructor.
	 *
	 * <br /><br />
	 * 
	 * Sets up the link back to the Main Panel.
	 * 
	 * @see MainPanel
	 *
	 * @param m The Main Panel to link back to.
	 */
	public MainListener(MainPanel m)
	{
		mainPanel = m;
	}

	/**
	 * Action Performed, runs relevant method based on the button pressed.
	 * 
	 * @param e The Action Event to take from.
	 * 
	 * @see MainPanel#exit()
	 * @see MainPanel#runEditorExisting()
	 * @see MainPanel#runEditorNew()
	 * @see MainPanel#runGame()
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String actionPerformed = e.getActionCommand();
		
		if(actionPerformed.equals("Exit"))
		{
			mainPanel.exit();
		}
		else if(actionPerformed.equals("Start a New Game"))
		{
			mainPanel.runGame();
		}
		else if(actionPerformed.equals("Build a New Game"))
		{
			mainPanel.runEditorNew();
		}
		else if(actionPerformed.endsWith("Edit an Existing Game"))
		{
			mainPanel.runEditorExisting();
		}
		else
		{
			//do nothing
		}
	}
}
