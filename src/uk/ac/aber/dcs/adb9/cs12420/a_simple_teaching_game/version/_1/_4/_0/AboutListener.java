package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the About Panel.
 * @author Alexander Brown
 * @version 1.1.0
 * @see AboutPanel
 */
public class AboutListener
implements ActionListener
{
	/**
	 * Link back to the About Panel.
	 * @see AboutPanel
	 */
	private AboutPanel aboutPanel;

	/**
	 * Constructor.
	 * <br />
	 * <br />
	 * Links back to the About Panel.
	 * @param a The About Panel to link back to.
	 * @see AboutPanel
	 */
	public AboutListener(AboutPanel a)
	{
		aboutPanel = a;
	}

	/**
	 * Action Performed Event.
	 * @param e The Action Event passed in.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		aboutPanel.close();
	}
}
