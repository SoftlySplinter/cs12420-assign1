package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Contains the main Game.
 * 
 * @author Alexander Brown
 * @version 1.1.1
 * 
 * @see GameFrame
 * @see GameListener
 * @see GameMouseListener
 * @see GameMousePositionListener
 * @see Word
 */
@SuppressWarnings("serial")
public class GamePanel
extends JPanel
{
	private final Color TARGET = new Color(200,200,200);

	private final Color TARGET_HOVER_GOOD = new Color(100,200,100);
	
	private final Color TARGET_HOVER_BAD = new Color(200,100,100);
	
	private Color target = TARGET;
	
	/**
	 * The Game Frame this is linked to.
	 * 
	 * @see GameFrame
	 */
	private GameFrame gameFrame;
	
	/**
	 * An array of the Word Labels.
	 * 
	 * @see Word
	 */
	private Word[] words;
	
	/**
	 * The target Word.
	 * 
	 * @see Word
	 */
	private String targetWord;
	
	/**
	 * Mouse Listener.
	 * 
	 * @see GameMouseListener
	 */
	private GameMouseListener gameMouseListner = new GameMouseListener(this);

	/**
	 * Mouse Position Listener.
	 * 
	 * @see GameMousePositionListener
	 */
	private GameMousePositionListener gameMousePositionListener = new GameMousePositionListener(this);
	
	/**
	 * The current location of the Mouse
	 */
	private Dimension d;
	
	
	/**
	 * True if the word is currently picked up.
	 */
	private boolean isPickedUp = false;
	
	private Word draggedWord;
	
	private Word storedWord;

	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Links back to the Game Frame, sets up the entire game, draws the Words and sets Listeners to itself.
	 * 
	 * @param g The Game Frame this is linked to.
	 * @param target The Target Word.
	 * @param w The Array of Words to be passed in.
	 * 
	 * @see GameFrame
	 * @see GameMouseListener
	 * @see GameMousePositionListener
	 * @see Word
	 * @see <br />
	 * @see #paintComponent(Graphics)
	 */
	public GamePanel(GameFrame g,String target,Word[] w)
	{
		this.setPreferredSize(new Dimension(350,300));
		
		gameFrame = g;
		words = w;
		targetWord = target;
		
		//Adds listeners
		this.addMouseListener(gameMouseListner);
		this.addMouseMotionListener(gameMousePositionListener);
		
		//Paints everything
		repaint();
	}
	
	/**
	 * Gets the target word.
	 * @return The Target Word.
	 */
	public String getTarget()
	{
		return targetWord;
	}
	
	/**
	 * Passes the method upward
	 * 
	 * @see GameFrame#endGame()
	 */
	public void endGame()
	{
		gameFrame.endGame();
	}
	
	/**
	 * Displays all the Strings. Also displays the target/drop zone.
	 * 
	 * @param g The Graphics to be passed in.
	 * 
	 * @see Word#getValue()
	 * @see Word#getX()
	 * @see Word#getY()
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		//Calls the super method
		super.paintComponent(g);
		
		
		g.setColor(target);
		g.fillRect(125, 0, 100, 20);
		
		g.setColor(new Color(000,000,000));
		g.drawRect(125,0,100,20);
		
		//Iterates to the array and prints the Word in the proper position
		for(int i=0;i<words.length;i++)
		{
			g.drawString(words[i].getValue(), words[i].getX(), words[i].getY());
		}
		
		this.hideMainManu();
	}
	
	public void hideMainManu()
	{
		gameFrame.hideMainManu();
	}

	/**
	 * Stores the Mouse Location.
	 * 
	 * @param x Location on the X axis.
	 * @param y Location on the Y axis.
	 */
	public void setMouseLocation(int x, int y)
	{
		d = new Dimension(x,y);
	}
	
	/**
	 * Returns the location of the Mouse.
	 * @return The Location of the Mouse as a Dimension.
	 */
	public Dimension getMouseLocation()
	{
		return d;
	}
	
	/**
	 * Checks to see in the Mouse in over a Word.
	 * 
	 * @param x Position of the Mouse in the X axis.
	 * @param y Position of the Mouse in the Y axis.
	 * 
	 * @return The Word it is over (null if there is no Word.)
	 * 
	 * @see Word#getValue()
	 * @see Word#getX()
	 * @see Word#getY()
	 */
	public Word checkLocation(int x,int y)
	{
		//Looks through all words
		for(int i=0;i<words.length;i++)
		{
			//Gets the value
			String s = words[i].getValue();
			
			//Gets the length (used to define the tolerance)
			int l = s.length();
			
			//Gets where the String is
			int pX = words[i].getX();
			int pY = words[i].getY();
			
			//Checks to see if the Mouse's current location is within the tolerance of the position of the String
			if((x > pX-(4) && x < pX+((l*l)+l+10)) && (y > pY-11 && y < pY+4)) //Tolerance = x: -4 to ((length of the word^2)+length of the word+10) because it fits well.  y: -11 to +4 (10pt = 13px). 13+2 to give a little lee way.
			{
				//if it is returns that Word
				return words[i];
			}
		}
		//Otherwise returns null
		return null;
	}
	
	/**
	 * Checks to see if the word is the word you're looking for.
	 * 
	 * <!--"These aren't the Words you're looking for"-->
	 * 
	 * @param w The Word to check.
	 * 
	 * @see GameSound
	 * @see WinFrame
	 * @see <br />
	 * @see #endGame()
	 * @see #errorPopUp(String)
	 * @see <br />
	 * @see GameSound#playSound()
	 * @see SimpleFrame#showFrame()
	 */
	public void checkWord(Word w)
	{
		GameSound s;
		//if the value equals that of the target Word
		if(w.getValue().equals(targetWord))
		{
			s = new GameSound("good.wav");
			s.playSound();
			WinFrame wf = new WinFrame();
			wf.showFrame();
			
			this.endGame();
		}
		//otherwise
		else
		{
			s = new GameSound("bad.wav");
			s.playSound();
			
			target = TARGET;
			repaint();
			
			//pop-up an error
			this.errorPopUp(w.getValue());
		}
	}
	
	/**
	 * Sets the colour of the target/drop zone. Green if the target word is hovering over it, red if another word is hovering over it, grey if not.
	 * @param w The Word being dragged.
	 */
	public void setTargetColor(Word w)
	{
		int x = w.getX();
		int y = w.getY();
		
		if((x > 115 && x < 225 && (y > 0 && y < 25)))
		{
			if (w.getValue().equals(targetWord))
			{
				target = TARGET_HOVER_GOOD;
			} else
			{
				target = TARGET_HOVER_BAD;
			}
		}
		else
		{
			target = TARGET;
		}
	}
	
	/**
	 * Displays the mouse as a hand (as it hovers over a word).
	 */
	public void setMouseClickable()
	{
		this.setCursor(new Cursor(12));
	}
	
	/**
	 * Returns the mouse to it's normal form (as it leaves a word).
	 */
	public void setMousePointer()
	{
		this.setCursor(new Cursor(0));
	}
	
	/**
	 * Pops-up an Error (passes method upward).
	 * 
	 * @param message The Word which should be included in the message.
	 * 
	 * @see GameFrame#errorPopUp(String)
	 */
	public void errorPopUp(String message)
	{
		gameFrame.errorPopUp(message);
	}
	
	/**
	 * Picks up a word for Drag and Drop purposes
	 * @param w The Word to pick up.
	 * @see Word
	 */
	public void pickUp(Word w)
	{
		draggedWord = w;
		isPickedUp = true;
		
		for(int i=0;i<words.length;i++)
		{
			if(draggedWord.getValue().equals(words[i].getValue()))
			{
				storedWord = new Word(words[i].getValue(),(int)words[i].getX(),(int)words[i].getY(),words[i].isTarget());
				System.out.println("Stored: "+storedWord);
			}
		}
		
		System.out.println(draggedWord.getValue()+" picked up");
	}
	
	/**
	 * Drop routine.
	 * @param blank 1 if position is drop-able, -1 if outside frame or word is already there, 0 if it's in the winning spot.
	 */
	public void drop(int blank)
	{
		if (isPickedUp)
		{
			if (blank == 1)
			{
			
				for(int i=0;i<words.length;i++)
				{
					if(draggedWord.getValue().equals(words[i].getValue()))
					{
						words[i] = draggedWord;
					}
				}
				isPickedUp = false;
				//System.out.println("Dropped "+draggedWord);
			}
			else if(blank == -1)
			{
				for(int i=0;i<words.length;i++)
				{
					if(draggedWord.getValue().equals(words[i].getValue()))
					{
						words[i] = storedWord;
					}
				}
				isPickedUp = false;
				//System.out.println("Dropped "+draggedWord);
			}
			else if(blank == 0)
			{
				checkWord(draggedWord);
			}
		}
		
		repaint();
	}

	/**
	 * Drag Routine.
	 * @param x X position dragged to.
	 * @param y Y position dragged to.
	 */
	public void setDragLocation(int x, int y)
	{
		if(isPickedUp)
		{
			draggedWord.setX(x);
			draggedWord.setY(y);
			
			this.setTargetColor(draggedWord);
			
			repaint();
		}
	}

	/**
	 * Returns the dragged Word.
	 * @return The dragged Word.
	 */
	public Word getDraggedWord()
	{
		return draggedWord;
	}
	
	
	/**
	 * Returns all the Words
	 * @return all Words
	 */
	public Word[] getWords()
	{
		return words;
	}
	
	/**
	 * Refreshes all the Words
	 * @param w Words to refresh with.
	 */
	public void refreshWords(Word[] w)
	{
		words = w;
		
		repaint();
	}
}
