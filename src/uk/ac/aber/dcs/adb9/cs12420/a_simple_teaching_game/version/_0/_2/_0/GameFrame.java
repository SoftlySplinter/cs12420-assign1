package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._2._0;

import java.awt.BorderLayout;

import javax.swing.JLabel;

/**
 * The window for the Game.
 * @see GameDriver
 * @author Alexander Brown
 * @version 0.1.0
 */
@SuppressWarnings("serial")
public class GameFrame
extends SimpleFrame
{

	/**
	 * The game this is connected to
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
	
	public GameFrame(GameDriver g,String target,Word[] words)
	{
		//General purpose
		super("A Simple Teaching Game");
		gamePanel = new GamePanel(this,target,words);
		
		game = g;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
	public void endGame()
	{
		game.endGame();
	}
}
