package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._6._0;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Mouse Position Listener
 * @author Alexander Brown
 * @version 0.1.0
 */
public class GameMousePositionListener
implements MouseMotionListener
{
	/**
	 * The Game Panel Link
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  
	 */
	private GamePanel gamePanel;
	
	/**
	 * Constructor
	 * @param g The Game Panel it is linked to
	 */
	public GameMousePositionListener(GamePanel g)
	{
		gamePanel = g;
	}

	/**
	 * Mouse Dragged Event
	 * <br />
	 * <small><b>Note:</b> Does nothing.</small>
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		// Does nothing
	}

	/**
	 * Mouse Moved Event, also sets the cursor.
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
