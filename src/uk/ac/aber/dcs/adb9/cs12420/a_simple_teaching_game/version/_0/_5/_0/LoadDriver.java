package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._5._0;

/**
 * The Driver for the Load GUI.
 * 
 * @author Alexander Brown
 * @version 0.0.1
 * @see ApplicationDriver
 * @see LoadFrame
 */
public class LoadDriver {

	/**
	 * The link back to the Application
	 * @see ApplicationDriver
	 * @see       <!--
	 * @uml.property  name="applicationDriver"
	 * @uml.associationEnd  
	 */
	private ApplicationDriver applicationDriver;
	
	/**
	 * The Window for the Loader.
	 * @see LoadFrame
	 * @see       <!--
	 * @uml.property  name="loadFrame"
	 * @uml.associationEnd  
	 */
	private LoadFrame loadFrame;
	
	/**
	 * Decides which operation will happen when loading.
	 */
	private String type;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the link back to the Application, takes what the loader is taking and creates the Load Frame.
	 * 
	 * @param a The Application to link back to.
	 * @param t The type to take (currently: "game", "editorNew" and "editorExisting"
	 * 
	 * @see ApplicationDriver
	 * @see loadFrame
	 */
	public LoadDriver(ApplicationDriver a,String t)
	{
		applicationDriver = a;
		type = t;
		loadFrame = new LoadFrame(this);
	}
	
	/**
	 * Main load routine.
	 * @see ApplicationDriver#runEditorExisting(String)
	 * @see ApplicationDriver#runEditorNew(String)
	 * @see ApplicationDriver#runGame(String)
	 * @see LoadFrame
	 * 
	 * @param file The file to load from.
	 */
	public void loadRoutine(String file)
	{
		//If it's a game to load in
		if(type.equals("game"))
		{
			applicationDriver.runGame(file);
		}
		//If it's a new editor to create
		else if(type.equals("editorNew"))
		{
			applicationDriver.runEditorNew(file);
		}
		//If it's an existing editor to load
		else if(type.equals("editorExisting"))
		{
			applicationDriver.runEditorExisting(file);
		}
		//get rid of the Load Frame
		loadFrame.dispose();
	}
	
	/**
	 * Closes the Loader
	 * @see LoadFrame
	 * @see ApplicationDriver#showMenu()
	 */
	public void close()
	{
		loadFrame.dispose();
		applicationDriver.showMenu();
	}
}
