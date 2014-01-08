package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Mouse Position Listener for the Game.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see GamePanel
 */
public class GameMousePositionListener
implements MouseMotionListener
{
	/**
	 * Link back to the Game Panel.
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
	 * Adds the link back to the Game Panel.
	 * 
	 * @param g The Game Panel it is linked to.
	 * 
	 * @see GamePanel
	 */
	public GameMousePositionListener(GamePanel g)
	{
		gamePanel = g;
	}

	/**
	 * Mouse Dragged Event.
	 * <br />
	 * <small><b>Note:</b> Does nothing.</small>
	 * 
	 * @param e The Mouse Event to be used.
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		// Does nothing
	}

	/**
	 * Mouse Moved Event, also sets the cursor icon depending on whether it moves in or out.
	 * 
	 * @param e The Mouse Event to pass in.
	 * 
	 * @see GamePanel#checkLocation(int, int)
	 * @see GamePanel#setMouseClickable()
	 * @see GamePanel#setMouseLocation(int, int)
	 * @see GamePanel#setMousePointer()
	 */
	@Override
	public void mouseMoved(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		gamePanel.setMouseLocation(x, y);
		
		if(gamePanel.checkLocation(x, y)!=null)
		{
			gamePanel.setMouseClickable();
		}
		else
		{
			gamePanel.setMousePointer();
		}
	}
}
