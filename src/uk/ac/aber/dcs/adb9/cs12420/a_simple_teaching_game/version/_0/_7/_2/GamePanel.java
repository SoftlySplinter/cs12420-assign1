package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._2;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * The Panel for the main Game
 * @author Alexander Brown
 * @version 0.1.3
 */
@SuppressWarnings("serial")
public class GamePanel
extends JPanel
{

	/**
	 * The Game Frame this is linked to
	 * @uml.property  name="gameFrame"
	 * @uml.associationEnd  
	 */
	private GameFrame gameFrame;
	
	/**
	 * An array of the Word Labels
	 * @uml.property  name="wordLabel"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Word[] words;
	
	/**
	 * The target word
	 * @uml.property  name="targetWord"
	 * @uml.associationEnd  inverse="gamePanel:aSimpleGamev0p7p0.Word"
	 */
	private String targetWord;
	
	/**
	 * Mouse Listener
	 * @uml.property  name="gameMouseListner"
	 * @uml.associationEnd  
	 */
	private GameMouseListener gameMouseListner = new GameMouseListener(this);

	/**
	 * Mouse Position Listener
	 * @uml.property  name="gameMousePositionListener"
	 * @uml.associationEnd  
	 */
	private GameMousePositionListener gameMousePositionListener = new GameMousePositionListener(this);
	
	/**
	 * Dimension for finding the location of words
	 */
	private Dimension d;
	
	
	//Methods Start	
	/**
	 * Constructor
	 * @param g The Game Frame this is linked to
	 * @param target The Target Word
	 * @param w The Array of Words to be passed in
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
	 * Gets the target word
	 * @return The Target Word
	 */
	public String getTarget()
	{
		return targetWord;
	}
	
	/*
	 * Ends the game
	 */
	public void endGame()
	{
		gameFrame.endGame();
	}
	
	/**
	 * Displays all the Strings
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<words.length;i++)
		{
			g.drawString(words[i].getValue(), words[i].getX(), words[i].getY());
		}
	}
	
	/**
	 * Stores the Mouse Location
	 * @param x Location on the X axis
	 * @param y Location on the Y axis
	 */
	public void setMouseLocation(int x, int y)
	{
		d = new Dimension(x,y);
	}
	
	/**
	 * Returns the location of the Mouse
	 * @return The Location of the Mouse as a Dimension
	 */
	public Dimension getMouseLocation()
	{
		return d;
	}
	
	/**
	 * Checks to see in the Mouse in over a Word
	 * @param x Position of the Mouse in the X axis
	 * @param y Position of the Mouse in the Y axis
	 * @return The Word it is over (<tt>null</tt> if there is no Word)
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
	 * <!--"These aren't the Words you're looking for"-->
	 * @param w The Word to check
	 */
	public void checkWord(Word w)
	{
		//if the value equals that of the targetWord
		if(w.getValue().equals(targetWord))
		{
			//end the game
			this.endGame();
		}
		//otherwise
		else
		{
			//pop-up an error
			this.errorPopUp(w.getValue());
		}
	}
	
	/**
	 * Displays the mouse as a hand (as it hovers over a word)
	 */
	public void setMouseClickable()
	{
		this.setCursor(new Cursor(12));
	}
	
	/**
	 * Returns the mouse to it's normal form (as it leaves a word)
	 */
	public void setMousePointer()
	{
		this.setCursor(new Cursor(0));
	}
	
	/**
	 * Pops-up an Error (calls methods above)
	 * @param message The Word which should be included in the message
	 */
	public void errorPopUp(String message)
	{
		gameFrame.errorPopUp(message);
	}
}
