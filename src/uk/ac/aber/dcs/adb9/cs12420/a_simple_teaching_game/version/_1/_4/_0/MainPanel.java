package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The contents of the Main Menu.
 * 
 * @author Alexander Brown
 * @version 0.0.1
 * @see MainFrame
 * @see MainListener
 */
@SuppressWarnings("serial")
public class MainPanel
extends JPanel
{

	/**
	 * The link back to the Main Frame
	 * @see MainFrame
	 * @see         <!--
	 * @uml.property  name="mainFrame"
	 * @uml.associationEnd  
	 * -->
	 */
	private MainFrame mainFrame;
	
	/**
	 * The link to the Action Listener
	 * @see MainListener
	 * @see         <!--
	 * @uml.property  name="mainListener"
	 * @uml.associationEnd 
	 * --> 
	 */
	private MainListener mainListener = new MainListener(this);
	
	/**
	 * Start a new Game Button
	 */
	private JButton play = new JButton("Start a New Game");
	
	/**
	 * Build a new game button
	 */
	private JButton edit = new JButton("Build a New Game");
	
	/**
	 * Edit existing button
	 */
	private JButton editExisting = new JButton("Edit an Existing Game");
	
	/**
	 * Exit button
	 */
	private JButton exit = new JButton("Exit");
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the link back to the Frame, formats the layout of the buttons and adds Action Listeners to them.
	 * 
	 * @see MainFrame
	 * @see MainListener
	 */
	public MainPanel(MainFrame m)
	{
		//Link back to the Frame
		mainFrame = m;
		
		//Setup the layout
		setLayout(new GridLayout(4,1,5,5)); //Grid with 4 rows and 1 column.
		
		//add buttons and action listeners to the buttons
		this.add(play);
		play.addActionListener(mainListener);
		this.add(edit);
		edit.addActionListener(mainListener);
		this.add(editExisting);
		editExisting.addActionListener(mainListener);
		this.add(exit);
		exit.addActionListener(mainListener);	
	}

	/**
	 * Passes the run Game method upwards.
	 * @see MainFrame#runGame()
	 */
	public void runGame()
	{
		mainFrame.runGame();
	}
	
	/**
	 * Passes the run new Editor method upwards.
	 * @see MainFrame#runEditorNew()
	 */
	public void runEditorNew()
	{
		mainFrame.runEditorNew();
	}
	
	/**
	 * Passes the run existing Editor method upwards.
	 * @see MainFrame#runEditorExisting()
	 */
	public void runEditorExisting()
	{
		mainFrame.runEditorExisting();
	}
	
	/**
	 * Passes the exit method upwards
	 * @see MainFrame#exit()
	 */
	public void exit()
	{
		mainFrame.exit();
	}
}
