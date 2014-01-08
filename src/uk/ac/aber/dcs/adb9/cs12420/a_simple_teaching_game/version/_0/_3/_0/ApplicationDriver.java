package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._3._0;

/**
 * 
 * @author Alexander Brown
 * @version 0.1.0
 */
public class ApplicationDriver
{
	/**
	 * Link to the Game side of the program
	 * @uml.property  name="gameDriver"
	 * @uml.associationEnd  
	 */
	private GameDriver gameDriver;
	
	/**
	 * Link to the Editor side of the program
	 * @uml.property  name="editorDriver"
	 * @uml.associationEnd  
	 */
	private EditorDriver editorDriver;
	
	/**
	 * Run the application
	 */
	public ApplicationDriver()
	{
		//Does nothing
	}
	
	public ApplicationDriver(GameDriver g)
	{
		gameDriver = g;
	}
	
	public void run()
	{
		gameDriver = new GameDriver("Test");
	}
	
	/**
	 * Shows the main menu
	 */
	public void menu()
	{
		//TODO
		//Exits for now
		System.exit(0);
	}
}
