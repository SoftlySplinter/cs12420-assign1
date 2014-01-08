package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._0;

import java.awt.BorderLayout;

import javax.swing.JLabel;

/**
 * The window for the Game.
 * 
 * @see GameDriver
 * @see GamePanel
 * @see SimpleFrame
 * 
 * @author Alexander Brown
 * @version 0.1.1
 */
@SuppressWarnings("serial")
public class GameFrame
extends SimpleFrame
{

	/**
	 * The game this is connected to
	 * 
	 * @see  GameDriver
	 * @see <!--
	 * @uml.property  name="game"
	 * @uml.associationEnd  
	 * -->
	 */
	private GameDriver game;
	
	/**
	 * The Panel for the Game
	 * 
	 * @see  GamePanel
	 * @see<!--
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private GamePanel gamePanel;
	
	
	/**
	 * Constructor
	 * 
	 * <br /><br />
	 * 
	 * Links back to the Game Driver, formats the layout and adds the Game Panel.
	 * 
	 * @param g The Game Driver this is linked with
	 * @param target The Target Word
	 * @param words The Array of possible Words
	 * 
	 * @see GameDriver
	 * @see GamePanel
	 * @see SimpleFrame
	 * @see WordPanel
	 */
	public GameFrame(GameDriver g,String target,Word[] words)
	{
		//General purpose
		super("A Simple Teaching Game");
		gamePanel = new GamePanel(this,target,words);
		
		this.setOnTop();
		
		game = g;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(400,200);
		
		//Adds the target Word label
		JLabel targetWordLabel = new JLabel("Target Word is: '"+target+"'");
		targetWordLabel.setFont(BIG);
		n.add(targetWordLabel);
		
		//Adds the Game Panel
		this.add(gamePanel,BorderLayout.CENTER);
		
		//Format the layout
		this.formatLayout();
	}
	
	/**
	 * Passes the method upwards
	 * @see GameDriver#endGame()
	 */
	public void endGame()
	{
		game.endGame();
	}
	
	/**
	 * Pops-up an Error
	 * 
	 * @param message The message to be displayed.
	 * 
	 * @see ErrorFrame
	 */
	public void errorPopUp(String message)
	{
		message = "Incorrect, you clicked on: "+message+". The target word is: "+ game.getTargetWordValue();
		ErrorFrame errorFrame = new ErrorFrame(message);
		errorFrame.showFrame();
	}
}
