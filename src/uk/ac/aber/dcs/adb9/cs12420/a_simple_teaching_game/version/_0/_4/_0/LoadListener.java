package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoadListener
implements ActionListener
{

	/**
	 * @uml.property  name="loadPanel"
	 * @uml.associationEnd  
	 */
	private LoadPanel loadPanel;
	
	public LoadListener(LoadPanel l)
	{
		loadPanel = l;
	}
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String actionPerformed = e.getActionCommand();
		
		if(actionPerformed.equals("Load"))
		{
			loadPanel.loadRoutine();
		}
		else if(actionPerformed.equals("Cancel"));
		{
			loadPanel.close();
		}
	}
}
