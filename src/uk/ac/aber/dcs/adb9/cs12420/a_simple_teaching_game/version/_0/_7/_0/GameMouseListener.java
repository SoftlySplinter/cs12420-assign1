package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._0;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse Listener
 * @author Alexander Brown
 * @version 0.1.0
 */
public class GameMouseListener
implements MouseListener
{
	/**
	 * Game Panel link
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  
	 */
	private GamePanel gamePanel;
	
	/**
	 * Constructor
	 * @param g The Game Panel this is linked to
	 */
	public GameMouseListener(GamePanel g)
	{
		gamePanel=g;
	}
	
	/**
	 * Mouse Clicked Event
	 * @param e The Event passed in
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		Word w;
		Dimension d = gamePanel.getMouseLocation();
		int x = (int) d.getWidth();
		int y = (int) d.getHeight();
		if(gamePanel.checkLocation(x, y)!=null)
		{
			w = gamePanel.checkLocation(x, y);
			System.out.println("Clicked '"+w.getValue()+"'");
			gamePanel.checkWord(w);
		}		
	}

	/**
	 * Mouse Entered Event
	 * <br />
	 * <small><b>Note:</b> Does Nothing</small>
	 * @param The Event passed in
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	/**
	 * Mouse Exited Event
	 * <br />
	 * <small><b>Note:</b> Does Nothing</small>
	 * @param The Event passed in
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	/**
	 * Mouse Pressed Event
	 * <br />
	 * <small><b>Note:</b> Does Nothing</small>
	 * @param The Event passed in
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
}
