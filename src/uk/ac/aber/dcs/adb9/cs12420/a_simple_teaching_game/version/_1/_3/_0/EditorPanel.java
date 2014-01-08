package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._3._0;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Defines the Editor Panel.
 * 
 * <br /><br />
 * 
 * Unlike most other panels this is only a holder for another set of Panels (Word Panels to be specific). It does, however, define the buttons which appear in the South panel in the Editor Frame.
 * 
 * @author Alexander Brown
 * @version 0.0.2
 * 
 * @see EditorFrame
 * @see EditorListener
 * @see SimpleFrame
 */
@SuppressWarnings("serial")
public class EditorPanel
extends JPanel
{

	/**
	 * Link back to the Editor Frame.
	 * @see EditorFrame
	 * @see         <!--
	 * @uml.property  name="editorFrame"
	 * @uml.associationEnd 
	 * --> 
	 */
	private EditorFrame editorFrame;

	/**
	 * Action Listener for the Panel.
	 * @see EditorListener
	 * @see         <!--
	 * @uml.property  name="editorListener"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorListener editorListener = new EditorListener(this);
	
	private JButton refresh = new JButton("Refresh");
	
	/**
	 * Button for saving and closing.
	 */
	private JButton saveAndCloseButton = new JButton("Save and Close");
	
	/**
	 * Constructor
	 * 
	 * Sets up the Panel and adds button to the bottom of the Editor Frame.
	 * 
	 * <br /><br />
	 * 
	 * Also adds action listeners to all those components which need it.
	 * 
	 * @see EditorFrame
	 * @see EditorListener
	 * 
	 * @param e The Editor Frame this is linked to
	 */
	public EditorPanel(EditorFrame e)
	{
		//Links back to the Editor Frame
		editorFrame = e;
		
		//Adds the panel which will go at the bottom of the frame
		JPanel bottomPanel = new JPanel();
		//Adds buttons to this
		bottomPanel.add(refresh);
		refresh.addActionListener(editorListener);
		
		bottomPanel.add(saveAndCloseButton);
		//Adds Editor Listener to these buttons
		saveAndCloseButton.addActionListener(editorListener);
		
		
		//Adds the bottom panel to the south section of the Editor Frame
		editorFrame.add(bottomPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * Passes the save method up to the Editor Frame.
	 * 
	 * @return True if it can be saved, false otherwise.
	 * 
	 * @see EditorFrame#save()
	 */
	public boolean save()
	{
		if(editorFrame.save())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void refresh()
	{
		editorFrame.refresh("");
	}
	
	/**
	 * Passes the close method up to the Editor Frame
	 * @see EditorFrame#close()
	 */
	public void close()
	{
		editorFrame.close();
	}
}
