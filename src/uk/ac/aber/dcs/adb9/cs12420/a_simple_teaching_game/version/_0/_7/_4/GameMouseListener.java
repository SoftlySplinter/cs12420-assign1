package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._4;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse Listener for the Game.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see GamePanel
 */
public class GameMouseListener
implements MouseListener
{
	/**
	 * Link back to the Game Panel
	 * 
	 * @see GamePanel
	 * @see <!--
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd 
	 * --> 
	 */
	private GamePanel gamePanel;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Links back to the Game Panel.
	 * 
	 * @param g The Game Panel this is linked to.
	 * 
	 * @see GamePanel
	 */
	public GameMouseListener(GamePanel g)
	{
		gamePanel=g;
	}
	
	/**
	 * Mouse Clicked Event
	 * 
	 * @param e The Event passed in.
	 * 
	 * @see GamePanel#checkLocation(int, int)
	 * @see GamePanel#checkWord(Word)
	 * @see Word
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
			//System.out.println("Clicked '"+w.getValue()+"'");
			gamePanel.checkWord(w);
		}		
	}

	/**
	 * Mouse Entered Event.
	 * <br />
	 * <small><b>Note:</b> Does Nothing.</small>
	 * @param e The Event passed in.
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
		//Does nothing
	}

	/**
	 * Mouse Exited Event.
	 * <br />
	 * <small><b>Note:</b> Does Nothing.</small>
	 * @param e The Event passed in.
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		//Does nothing
	}

	/**
	 * Mouse Pressed Event.
	 * <br />
	 * <small><b>Note:</b> Does Nothing.</small>
	 * @param e The Event passed in.
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		//Does nothing
	}

	/**
	 * Mouse Released Event.
	 * <br />
	 * <small><b>Note:</b> Does Nothing.</small>
	 * @param e The Event passed in.
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		//Does nothing
	}
}
