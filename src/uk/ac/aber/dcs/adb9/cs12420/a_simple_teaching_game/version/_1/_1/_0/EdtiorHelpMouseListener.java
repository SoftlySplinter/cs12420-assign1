package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._0;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EdtiorHelpMouseListener
implements MouseListener
{
	EditorHelpPanel editorHelpPanel;
	
	public EdtiorHelpMouseListener(EditorHelpPanel e)
	{
		editorHelpPanel = e;
		System.out.println("Mouse Listener Added");
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		//System.out.println("Mouse Clicked");
		editorHelpPanel.checkList();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		//System.out.println("Mouse Entered");
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		//System.out.println("Mouse Exited");
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		//System.out.println("Mouse Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		//System.out.println("Mouse Released");
	}

}
