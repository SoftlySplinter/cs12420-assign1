package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.BorderLayout;

import javax.swing.JLabel;

/**
 * The window for the Game.
 * @see GameDriver
 * @author Alexander Brown
 * @version 0.1.1
 */
@SuppressWarnings("serial")
public class GameFrame
extends SimpleFrame
{

	/**
	 * The game this is connected to
	 * @see  GameDriver
	 * @uml.property  name="game"
	 * @uml.associationEnd  
	 */
	private GameDriver game;
	
	/**
	 * The Panel for the Game
	 * @see  GamePanel
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  
	 */
	private GamePanel gamePanel;
	
	/**
	 * The Error Frame associated with this
	 * @see  ErrorFrame
	 * @uml.property  name="errorFrame"
	 * @uml.associationEnd  
	 */
	private ErrorFrame errorFrame;
	
	
	/**
	 * Constructor
	 * @param g The Game Driver this is linked with
	 * @param target The Target Word
	 * @param words The Array of possible Words
	 */
	public GameFrame(GameDriver g,String target,Word[] words)
	{
		//General purpose
		super("A Simple Teaching Game");
		gamePanel = new GamePanel(this,target,words);
		
		game = g;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(400,200);
		
		//Adds the target word
		JLabel targetWordLabel = new JLabel(target);
		targetWordLabel.setFont(big);
		n.add(targetWordLabel);
		
		//Adds the GamePanel
		this.add(gamePanel,BorderLayout.CENTER);
		
		//Format the layout
		this.formatLayout();
		
		this.showFrame();
	}
	
	/**
	 * Ends the Game
	 */
	public void endGame()
	{
		game.endGame();
	}
	
	/**
	 * Pops-up an Error
	 * @param message The message to be displayed.
	 */
	public void errorPopUp(String message)
	{
		message = "Oops, you clicked on: "+message;
		errorFrame = new ErrorFrame(this,message);
		errorFrame.showFrame();
	}
}
