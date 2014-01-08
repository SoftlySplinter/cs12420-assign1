package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._4;

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
		//Previews
		else if(a.equals("Preview"))
		{
			//TODO
		}
		//Displays help
		else if(a.equals("Help Contents"))
		{
			//TODO - Should be contained within a Frame, not in the console.
			System.out.println("Target Word: The Word which the player will need to find.");
			System.out.println("Word: The other Word(s) which will appear in the Game.");
			System.out.println("X Position: How far along the X axis (Horizontal) the Word will appear (in Pixels from the left).");
			System.out.println("Y Position: How far along the Y axis (Vertical) the Word will appear (in Pixels from the top).");
		}
		//Displays information about the game.
		else if(a.equals("About A Simple Teaching Game"))
		{
			//TODO - Should be contained within a Frame, not in the console.
			System.out.println("A Simple Teaching Game.");
			System.out.println("Made By Alexander Brown (adb9).");
			System.out.println("March 2010.");
			System.out.println("Copyright Alexander Brown, 2010. All rights reserver.");
			System.out.println("Vist http://users.aber.ac.uk/adb9 for more information");
		}
	}
}
