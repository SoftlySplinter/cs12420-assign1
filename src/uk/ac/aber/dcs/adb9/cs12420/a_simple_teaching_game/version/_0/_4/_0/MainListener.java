package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainListener
implements ActionListener
{

	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  
	 */
	private MainPanel mainPanel;
	
	public MainListener(MainPanel m)
	{
		mainPanel = m;
	}

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
			mainPanel.runEditor();
		}
		else
		{
			//do nothing
		}
	}

}
