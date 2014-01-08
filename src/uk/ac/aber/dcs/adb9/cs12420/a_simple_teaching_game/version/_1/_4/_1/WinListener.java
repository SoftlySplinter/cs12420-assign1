package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for the Win Frame.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see WinPanel
 */
public class WinListener
implements ActionListener
{

	/**
	 * Link back to the Win Panel
	 * @see WinPanel
	 * @see   <!--
	 * @uml.property   name="winPanel"
	 * @uml.associationEnd   inverse="winListener:aSimpleGamev1p0p0.WinPanel"
	 */
	private WinPanel winPanel;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Adds the link back to the Win Panel.
	 * 
	 * @param w The Win Panel to link back to.
	 * 
	 * @see WinPanel
	 */
	public WinListener(WinPanel w)
	{
		winPanel = w;
	}

	/**
	 * Action Performed event. Closes the Frame.
	 * 
	 * @param e The Action Event passed in.
	 * 
	 * @see WinPanel#close()
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		
		if(s.equals("Continue"))
		{
			winPanel.continueGame();
		}
		else if(s.equals("Stop Playing"))
		{
			System.exit(0);
		}
	}
}
