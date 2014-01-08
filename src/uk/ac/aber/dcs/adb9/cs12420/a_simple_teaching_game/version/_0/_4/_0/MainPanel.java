package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MainPanel
extends JPanel
{

	/**
	 * @uml.property  name="mainFrame"
	 * @uml.associationEnd  
	 */
	private MainFrame mainFrame;
	
	/**
	 * @uml.property  name="mainListener"
	 * @uml.associationEnd  
	 */
	private MainListener mainListener = new MainListener(this);
	
	
	
	//Buttons
	private JButton play = new JButton("Start a New Game");
	private JButton edit = new JButton("Build a New Game");
	private JButton editExisting = new JButton("Edit an Existing Game");
	private JButton exit = new JButton("Exit");
	
	
	public MainPanel(MainFrame m)
	{
		mainFrame = m;
		
		setLayout(new GridLayout(4,1,5,5)); //Grid with 4 rows and 1 column.
		
		this.add(play);
		play.addActionListener(mainListener);
		this.add(edit);
		edit.addActionListener(mainListener);
		this.add(editExisting);
		editExisting.addActionListener(mainListener);
		this.add(exit);
		exit.addActionListener(mainListener);	
	}

	public void runGame()
	{
		mainFrame.runGame();
	}
	
	public void runEditor()
	{
		mainFrame.runEditor();
	}
	
	public void exit()
	{
		mainFrame.exit();
	}
}
