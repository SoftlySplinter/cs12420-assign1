package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._1;

/**
 * Main run method of A Simple Game.
 * 
 * @author Alexander Brown
 * @version 0.3.0
 * 
 * @see ApplicationDriver
 */
public class Application
{
	
	/**
	 * Main run method of the application.
	 * @see ApplicationDriver
	 * @see ApplicationDriver#showMenu()
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Creates a new Application Driver
		ApplicationDriver app = new ApplicationDriver();
		//Shows the Main Menu
		app.showMenu();
	}
	
	
}
