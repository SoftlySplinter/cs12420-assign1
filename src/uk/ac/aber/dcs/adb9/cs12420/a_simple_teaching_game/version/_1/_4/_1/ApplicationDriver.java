package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

/**
 * Main Driver for the Application. Controls the running of the entire program, as well as acting as the Driver for the Main Frame.
 * 
 * @author Alexander Brown
 * @version 0.1.3
 * 
 * @see Application
 * @see EditorDriver
 * @see GameDriver
 * @see LoadDriver
 * @see MainFrame
 */
public class ApplicationDriver
{
	/**
	 * Link to the Game side of the program.
	 * @see GameDriver
	 * @see         <!--
	 * @uml.property  name="gameDriver"
	 * @uml.associationEnd  
	 * 
	 */
	@SuppressWarnings("unused")
	private GameDriver gameDriver;
	
	/**
	 * Link to the Editor side of the program.
	 * @see EditorDriver
	 * @see         <!--
	 * @uml.property  name="editorDriver"
	 * @uml.associationEnd  
	 * -->
	 */
	@SuppressWarnings("unused")
	private EditorDriver editorDriver;
	
	/**
	 * Link to the Main Menu.
	 * @see MainFrame
	 * @see         <!--
	 * @uml.property  name="mainFrame"
	 * @uml.associationEnd  
	 * -->
	 */
	private MainFrame mainFrame;
	
	/**
	 * Link to the Loader.
	 * @see LoadDriver
	 * @see         <!--
	 * @uml.property  name="loadDriver"
	 * @uml.associationEnd  
	 * -->
	 */
	@SuppressWarnings("unused")
	private LoadDriver loadDriver;
	
	public ApplicationDriver()
	{
		//does nothing
	}
	
	public ApplicationDriver(Application a)
	{
		mainFrame = new MainFrame(this);
	}
	
	/**
	 * Runs the loader for a game.
	 * @see LoadDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runGameLoader()
	{
		loadDriver = new LoadDriver(this,"game");
		mainFrame.hideFrame();
	}
	
	/**
	 * Runs the game.
	 * @param file The file to load a game from.
	 * @see GameDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runGame(String file)
	{
		mainFrame.hideFrame();
		gameDriver = new GameDriver(file,this);
	}
	
	/**
	 * Runs the loader for a new Editor.
	 * @see LoadDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorNewLoader()
	{
		loadDriver = new LoadDriver(this,"editorNew");
		mainFrame.hideFrame();
	}
	
	/**
	 * Runs the loader for an existing Editor.
	 * @see LoadDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorExistingLoader()
	{
		loadDriver = new LoadDriver(this,"editorExisting");
		mainFrame.hideFrame();
	}
	
	/**
	 * Runs a new Editor.
	 * @param file The file to save to (and load from).
	 * @see EditorDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorNew(String file)
	{
		editorDriver = new EditorDriver(file,this,false);
		mainFrame.hideFrame();
	}
	
	/**
	 * Runs an existing Editor.
	 * @param file The file to load from.
	 * @see EditorDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorExisting(String file)
	{
		editorDriver = new EditorDriver(file,this,true);
		mainFrame.hideFrame();
	}
	
	/**
	 * Shows the Main Menu.
	 * @see SimpleFrame#showFrame()
	 */
	public void showMenu()
	{
		mainFrame.showFrame();
		mainFrame.repaint();
	}
	
	/**
	 * Hides the Main Menu
	 */
	public void hideMenu()
	{
		mainFrame.hideFrame();
	}
	
	/**
	 * Exits the Application.
	 */
	public void exit()
	{
		System.exit(0);
	}
}
