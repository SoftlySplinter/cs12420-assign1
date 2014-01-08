package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for the Game
 * @author Alexander Brown
 * @version 0.1.0
 */
public class GameListener
implements ActionListener
{
	/**
	 * The linked Game Panel, used to pass methods back up
	 * @uml.property  name="gamePanel"
	 * @uml.associationEnd  
	 */
	private GamePanel gamePanel;
	
	/**
	 * Constructor for Game Listener
	 * @param g The Game Panel
	 * @see GamePanel
	 */
	public GameListener(GamePanel g)
	{
		gamePanel = g;
	}
		
	/**
	 * Performs an action when an item is pressed.
	 * @param e The Action Exent
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Get the name of the item
		String actionCommand = e.getActionCommand();
		
		//if the item pressed matches the target word
		if(actionCommand.equals(gamePanel.getTarget()))
		{
			//TODO
			//Plays a good sound 
			//Returns to main menu
			gamePanel.endGame();
		}
		else
		{
			//TODO
			//Plays a bad sound
			//Game Continues
		}
		
	}
}
