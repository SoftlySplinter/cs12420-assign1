package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

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
		Application a = new Application();
		//Creates a new Application Driver
		ApplicationDriver app = new ApplicationDriver(a);
		//Shows the Main Menu
		app.showMenu();
	}
	
	
}
