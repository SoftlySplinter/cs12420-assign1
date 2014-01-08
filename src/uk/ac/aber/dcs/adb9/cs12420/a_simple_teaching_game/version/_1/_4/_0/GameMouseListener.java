package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse Listener for the Game.
 * 
 * @author Alexander Brown
 * @version 1.1.1
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
	 * Mouse Clicked Event. Does nothing due to the implementation of Drag and Drop.
	 * 
	 * @param e The Event passed in.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		/*Word w;
		Dimension d = gamePanel.getMouseLocation();
		int x = (int) d.getWidth();
		int y = (int) d.getHeight();
		if(gamePanel.checkLocation(x, y)!=null)
		{
			w = gamePanel.checkLocation(x, y);
			//System.out.println("Clicked '"+w.getValue()+"'");
			gamePanel.checkWord(w);
		}*/		
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
		gamePanel.drop(-1);
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
		Word w;
		Dimension d = gamePanel.getMouseLocation();
		int x = (int) d.getWidth();
		int y = (int) d.getHeight();
		if(gamePanel.checkLocation(x, y)!=null)
		{
			w = gamePanel.checkLocation(x, y);
			gamePanel.pickUp(w);
		}
	}

	/**
	 * Mouse Released Event. If the Dragged word is over the target/drop zone runs drop with the win value.
	 * <br />
	 * If the position is empty or it's the original position (within a tolerance) then it drops the word and leaves it there.
	 * <br />
	 * If neither of those can happen drops the word back to it's original place.
	 * <br /><br />
	 * Throwns an error message if it goes out of bounds.
	 * @param e The Event passed in.
	 * 
	 * @see ErrorFrame
	 * @see <br />
	 * @see GamePanel#checkLocation(int, int)
	 * @see GamePanel#drop(int)
	 * @see GamePanel#getDraggedWord
	 * @see Word#getValue()
	 * @see Word#getX()
	 * @see Word#getY()
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{		
		Word w = gamePanel.getDraggedWord();

			int x = (int) w.getX();
			int y = (int) w.getY();
			
			//int x = e.getX();
			//int y = e.getY();
					
			//try
			//{
				Word word = gamePanel.checkLocation(x,y);
				if(word==null || word.getValue().equals(w.getValue()))
				{	
					if((x > 115 && x < 225 && (y > 0 && y < 25)))
					{
						gamePanel.drop(0);
					}
					else
					{
						gamePanel.drop(1);
					}
				}
				else if((x > 115 && x < 225 && (y > 0 && y < 25)))
				{
					gamePanel.drop(0);
				}
				else
				{
					gamePanel.drop(-1);
				}
			/*}	
			catch (Exception e1)
			{
				System.out.println(e1+", "+gamePanel.checkLocation(x, y));
				if(w.usesImage())
				{

					gamePanel.drop(1);
				}
				else
				{
					gamePanel.drop(1);
				}
			}*/
	}
}
