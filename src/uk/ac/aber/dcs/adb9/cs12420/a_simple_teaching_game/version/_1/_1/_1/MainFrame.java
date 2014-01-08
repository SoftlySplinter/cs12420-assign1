package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._1;

import java.awt.BorderLayout;

import javax.swing.JLabel;

/**
 * The Main Menu of the Application.
 * 
 * @author Alexander Brown
 * @version 0.1.1
 * 
 * @see ApplicationDriver
 * @see MainPanel
 * @see SimpleFrame
 */
@SuppressWarnings("serial")
public class MainFrame
extends SimpleFrame
{

	/**
	 * Link back to the Application.
	 * @see ApplicationDriver
	 * @see         <!--
	 * @uml.property  name="application"
	 * @uml.associationEnd  
	 * -->
	 */
	private ApplicationDriver application;
	
	/**
	 * Link to the Main Panel.
	 * @see MainPanel
	 * @see         <!--
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private MainPanel mainPanel = new MainPanel(this);
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the layout of the Frame and adds the Main Panel.
	 * 
	 * @param a The Application to link back to.
	 * 
	 * @see ApplicationDriver
	 * @see MainPanel
	 * @see <br />
	 * @see SimpleFrame#formatLayout()
	 */
	public MainFrame(ApplicationDriver a)
	{
		//Link back to the Application
		application = a;
		
		//Normal Exit Operation
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Set the title of the window
		this.setTitle("A Simple Teaching Game");
		
		//Formats the Layout of the Frame
		this.formatLayout();
		this.setSize(400,200);
		
		//Personal Pride
		JLabel sLabel = new JLabel("Created by Alexander Brown, 2010");
		sLabel.setFont(SMALL);
		s.add(sLabel);
		
		//Add the main panel to the centre
		this.add(mainPanel,BorderLayout.CENTER);
	}
	
	/**
	 * Passes the run Game method upward.
	 * @see ApplicationDriver#runGameLoader()
	 */
	public void runGame()
	{
		application.runGameLoader();
	}
	
	/**
	 * Passes the run new Editor method upward.
	 * @see ApplicationDriver#runEditorNewLoader()
	 */
	public void runEditorNew()
	{
		application.runEditorNewLoader();
	}
	
	/**
	 * Passes the run existing Editor method upwards.
	 * @see ApplicationDriver#runEditorExistingLoader()
	 */
	public void runEditorExisting()
	{
		application.runEditorExistingLoader();
	}
	
	/**
	 * Passes the exit method upwards.
	 * @see ApplicationDriver#exit()
	 */
	public void exit()
	{
		application.exit();
	}
	
	public void hideFrame()
	{
		this.setVisible(false);
	}
}
