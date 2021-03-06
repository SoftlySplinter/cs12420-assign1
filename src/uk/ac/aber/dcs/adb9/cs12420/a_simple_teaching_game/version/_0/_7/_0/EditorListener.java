package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the editor.
 * @author Alexander Brown
 * @version 0.0.1
 * @see ActionListener
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
	 */
	private EditorPanel editorPanel;
	
	/**
	 * Constructor
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
	 * @see ActionListener
	 * @see ActionEvent
	 * @see EditorPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String a = e.getActionCommand();
		
		if(a.equals("Save and Close"))
		{
			editorPanel.save();
			editorPanel.close();
		}
	}

}
