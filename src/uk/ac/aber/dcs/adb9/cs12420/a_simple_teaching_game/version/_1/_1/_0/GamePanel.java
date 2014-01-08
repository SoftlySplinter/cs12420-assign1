package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._0;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Contains the main Game.
 * 
 * @author Alexander Brown
 * @version 0.1.3
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

	/**
	 * The Game Frame this is linked to.
	 * 
	 * @see GameFrame
	 * @see<!--
	 * @uml.property  name="gameFrame"
	 * @uml.associationEnd  
	 * -->
	 */
	private GameFrame gameFrame;
	
	/**
	 * An array of the Word Labels.
	 * 
	 * @see Word
	 * @see <!--
	 * @uml.property  name="wordLabel"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 * -->
	 */
	private Word[] words;
	
	/**
	 * The target Word.
	 * 
	 * @see Word
	 * @see <!--
	 * @uml.property  name="targetWord"
	 * @uml.associationEnd  inverse="gamePanel:aSimpleGamev0p7p0.Word"
	 * -->
	 */
	private String targetWord;
	
	/**
	 * Mouse Listener.
	 * 
	 * @see GameMouseListener
	 * @see<!--
	 * @uml.property  name="gameMouseListner"
	 * @uml.associationEnd  
	 * -->
	 */
	private GameMouseListener gameMouseListner = new GameMouseListener(this);

	/**
	 * Mouse Position Listener.
	 * 
	 * @see GameMousePositionListener
	 * @see <!--
	 * @uml.property  name="gameMousePositionListener"
	 * @uml.associationEnd 
	 * --> 
	 */
	private GameMousePositionListener gameMousePositionListener = new GameMousePositionListener(this);
	
	/**
	 * Dimension for finding the location of words
	 */
	private Dimension d;
	

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
	 * Displays all the Strings.
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
		//Iterates to the array and prints the Word in the proper position
		for(int i=0;i<words.length;i++)
		{
			g.drawString(words[i].getValue(), words[i].getX(), words[i].getY());
		}
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
			//pop-up an error
			this.errorPopUp(w.getValue());
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
}
