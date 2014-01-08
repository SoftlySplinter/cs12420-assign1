package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorHelpListener implements ActionListener
{
	/**
	 * Link back to the Help Panel.
	 * @see EditorHelpPanel
	 */
	EditorHelpPanel editorHelpPanel;
	
	/**
	 * Constructor.
	 * <br /><br />
	 * Sets up the link to the Help Panel.
	 * @param e The Help Panel to link back to.
	 * @see EditorHelpPanel
	 */
	public EditorHelpListener(EditorHelpPanel e)
	{
		editorHelpPanel = e;
	}

	/**
	 * Action Performed Method.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if(s.equals("Close"))
		{
			editorHelpPanel.close();
		}
		else
		{
			editorHelpPanel.checkList();
		}
	}

}
