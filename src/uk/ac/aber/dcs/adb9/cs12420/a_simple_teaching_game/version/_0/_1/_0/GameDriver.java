package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._1._0;

/**
 * Main run method of A Simple Game.
 * @author Alexander Brown
 * @version 0.1.0
 */
public class GameDriver
{
	/**
	 * Main run method of the application
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create a new editor
		Editor editor;
		editor = new Editor();
		
		//Create a new game from the data set in the editor
		Game game;
		game = new Game(editor.getFile());
		
		//run the game
		game.run();
	}
}
