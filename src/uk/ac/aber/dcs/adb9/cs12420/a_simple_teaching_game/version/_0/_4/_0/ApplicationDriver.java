package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

/**
 * 
 * @author Alexander Brown
 * @version 0.1.3
 */
public class ApplicationDriver
{
	/**
	 * Link to the Game side of the program
	 * @uml.property  name="gameDriver"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private GameDriver gameDriver;
	
	/**
	 * Link to the Editor side of the program
	 * @uml.property  name="editorDriver"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private EditorDriver editorDriver;
	
	/**
	 * @uml.property  name="mainFrame"
	 * @uml.associationEnd  
	 */
	private MainFrame mainFrame = new MainFrame(this);
	
	/**
	 * @uml.property  name="loadDriver"
	 * @uml.associationEnd  
	 */
	private LoadDriver loadDriver;
	
	
	/**
	 * Run the application
	 */
	public ApplicationDriver()
	{
		//Does nothing.
	}
	
	public void runLoader()
	{
		mainFrame.hideFrame();
		loadDriver = new LoadDriver(this);
	}
	
	public void runGame(String file)
	{
		mainFrame.hideFrame();
		gameDriver = new GameDriver(file,this);
	}
	
	public void runEditor()
	{
		editorDriver = new EditorDriver();
	}
	
	public void showMenu()
	{
		mainFrame.showFrame();
	}
	
	public void exit()
	{
		System.exit(0);
	}
}
