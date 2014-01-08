package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._1;

/**
 * Main Driver for the Application. Controls the running of the entire program, as well as acting as the Driver for the Main Frame.
 * 
 * @author Alexander Brown
 * @version 0.1.3
 * 
 * @see Application
 * @see MainFrame
 * @see GameDriver
 * @see EditorDriver
 * @see LoadDriver
 */
public class ApplicationDriver
{
	/**
	 * Link to the Game side of the program.
	 * @see GameDriver
	 * @see         <!--
	 * @uml.property  name="gameDriver"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private GameDriver gameDriver;
	
	/**
	 * Link to the Editor side of the program.
	 * @see EditorDriver
	 * @see         <!--
	 * @uml.property  name="editorDriver"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private EditorDriver editorDriver;
	
	/**
	 * Link to the Main Menu.
	 * @see MainFrame
	 * @see         <!--
	 * @uml.property  name="mainFrame"
	 * @uml.associationEnd  
	 */
	private MainFrame mainFrame = new MainFrame(this);
	
	/**
	 * Link to the Loader.
	 * @see LoadDriver
	 * @see         <!--
	 * @uml.property  name="loadDriver"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private LoadDriver loadDriver;
	
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Does nothing.
	 */
	public ApplicationDriver()
	{
		//Does nothing.
	}
	
	/**
	 * Runs the loader for a game.
	 * @see LoadDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runGameLoader()
	{
		mainFrame.hideFrame();
		loadDriver = new LoadDriver(this,"game");
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
		mainFrame.hideFrame();
		loadDriver = new LoadDriver(this,"editorNew");
	}
	
	/**
	 * Runs the loader for an existing Editor.
	 * @see LoadDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorExistingLoader()
	{
		mainFrame.hideFrame();
		loadDriver = new LoadDriver(this,"editorExisting");
	}
	
	/**
	 * Runs a new Editor.
	 * @param file The file to save to (and load from).
	 * @see EditorDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorNew(String file)
	{
		mainFrame.hideFrame();
		editorDriver = new EditorDriver(file,this,false);
	}
	
	/**
	 * Runs an existing Editor.
	 * @param file The file to load from.
	 * @see EditorDriver
	 * @see SimpleFrame#hideFrame()
	 */
	public void runEditorExisting(String file)
	{
		mainFrame.hideFrame();
		editorDriver = new EditorDriver(file,this,true);
	}
	
	/**
	 * Shows the Main Menu.
	 * @see SimpleFrame#showFrame()
	 */
	public void showMenu()
	{
		mainFrame.showFrame();
	}
	
	/**
	 * Exits the Application.
	 */
	public void exit()
	{
		System.exit(0);
	}
}
