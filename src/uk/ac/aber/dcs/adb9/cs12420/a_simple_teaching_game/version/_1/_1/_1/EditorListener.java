package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the editor.
 * @author Alexander Brown
 * @version 0.0.1
 * @see ActionListener
 * @see EdtiroPanel
 */
public class EditorListener
implements ActionListener
{

	/**
	 * Link back to the Editor Panel
	 * @see EditorPanel
	 * @see         <!--
	 * @uml.property  name="editorPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorPanel editorPanel;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Adds the link back to the Editor Panel.
	 * @see EditorPanel
	 * 
	 * @param e The Editor Panel to link back to.
	 */
	public EditorListener(EditorPanel e)
	{
		editorPanel = e;
	}

	/**
	 * Action Performed event
	 * 
	 * <br /><br />
	 * 
	 * Runs the save and close method when the button is pressed
	 * 
	 * @param e The Action Event performed
	 * 
	 * @see EditorPanel#close()
	 * @see EditorPanel#save()
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String a = e.getActionCommand();
		
		if(a.equals("Save and Close"))
		{
			if(editorPanel.save())
			{
				editorPanel.close();
			}
		}
		if(a.equals("Refresh"))	
		{
			editorPanel.refresh();
		}
	}

}
