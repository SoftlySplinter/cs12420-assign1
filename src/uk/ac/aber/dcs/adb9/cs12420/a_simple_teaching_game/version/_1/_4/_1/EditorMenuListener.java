package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the Editor Menu.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see EditorMenuBar
 */
public class EditorMenuListener
implements ActionListener
{

	/**
	 * Link back to the Editor Menu Bar,
	 * @see EditorMenuBar
	 * @see     <!--
	 * @uml.property  name="editorMenu"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorMenuBar editorMenuBar;

	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Adds the link back to the Editor Menu Bar.
	 * 
	 * @param e The Editor Menu Bar to link back to.
	 * @see EditorMenuBar
	 */
	public EditorMenuListener(EditorMenuBar e)
	{
		editorMenuBar = e;
	}

	/**
	 * Action Performed Event.
	 * 
	 * <br /><br />
	 * 
	 * Determines what happens when a menu item is pressed.
	 * 
	 * @param e The Action Event to take from
	 * 
	 * @see EditorMenuBar#close()
	 * @see EditorMenuBar#load()
	 * @see EditorMenuBar#newEditor()
	 * @see EditorMenuBar#save()
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String a = e.getActionCommand();
		
		if(a.equals("New"))
		{
			//TODO - Should have an error message.
			if(editorMenuBar.save())
			{
				editorMenuBar.close();
				editorMenuBar.newEditor();
			}
		}
		//Saves
		else if(a.equals("Save"))
		{
			editorMenuBar.save();
		}
		//Saves the current editor, closes it and loads a new one.
		else if(a.equals("Load"))
		{
			//TODO - should have a pop up window asking if the user is sure they want to save and close the current editor and load a new one.
			if(editorMenuBar.save())
			{
				editorMenuBar.close();
				editorMenuBar.load();
			}
		}
		//Saves and Closes
		else if(a.equals("Save and Close"))
		{
			//TODO - should have a pop up window asking if the user is sure they want to save and exit.
			if(editorMenuBar.save())
			{
				editorMenuBar.close();
			}
		}
		//Displays help
		else if(a.equals("Help Contents"))
		{
			EditorHelpFrame eF = new EditorHelpFrame();
			eF.showFrame();
		}
		//Displays information about the game.
		else if(a.equals("About A Simple Teaching Game"))
		{
			AboutFrame aF = new AboutFrame();
			aF.showFrame();
		}
	}
}
