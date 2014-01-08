package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.BorderLayout;

/**
 * Help Frame for the Editor
 * @author Alexander Brown
 * @version 1.1.0
 * @see EditorHelpPanel
 */
@SuppressWarnings("serial")
public class EditorHelpFrame
extends SimpleFrame
{
	/**
	 * Link to the Contents.
	 * @see EditorHelpPanel
	 */
	private EditorHelpPanel editorHelpPanel = new EditorHelpPanel(this);
	
	public EditorHelpFrame()
	{
		super("Help Contents");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLocation(250,100);
		
		this.setSize(500,500);
		
		this.setOnTop();
		
		this.add (editorHelpPanel,BorderLayout.CENTER);
	}
	
	public void close()
	{
		this.hideFrame();
	}
}
