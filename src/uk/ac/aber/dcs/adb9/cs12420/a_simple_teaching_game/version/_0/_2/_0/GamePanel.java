package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._2._0;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Panel for the main Game
 * @author Alexander Brown
 * @version 0.1.0
 */
@SuppressWarnings("serial")
public class GamePanel
extends JPanel
{

	/**
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
	 * An array of the Word Labels
	 * @uml.property  name="targetWord"
	 * @uml.associationEnd  inverse="gamePanel:aSimpleGamev0p2p0.Word"
	 */
	private String targetWord;
	
	/**
	 * Action Listener for the Game
	 * @uml.property  name="gameListener"
	 * @uml.associationEnd  
	 */
	private GameListener gameListener = new GameListener(this);
	
	public GamePanel(GameFrame g,String target,Word[] w)
	{
		gameFrame = g;
		words = w;
		targetWord = target;
		
		for(int i=0;i<words.length;i++)
		{
			JButton temp = new JButton(words[i].getValue());
			temp.addActionListener(gameListener);
			this.add(temp);
		}
	}
	
	public String getTarget()
	{
		return targetWord;
	}
	
	public void endGame()
	{
		gameFrame.endGame();
	}
}
