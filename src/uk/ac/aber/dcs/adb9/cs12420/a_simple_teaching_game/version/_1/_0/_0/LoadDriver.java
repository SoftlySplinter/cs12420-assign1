package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._0._0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * The Driver for the Load GUI.
 * 
 * @author Alexander Brown
 * @version 0.0.1
 * 
 * @see ApplicationDriver
 * @see LoadFrame
 */
public class LoadDriver
{

	/**
	 * The link back to the Application
	 * @see ApplicationDriver
	 * @see         <!--
	 * @uml.property  name="applicationDriver"
	 * @uml.associationEnd  
	 * -->
	 */
	private ApplicationDriver applicationDriver;
	
	/**
	 * The Window for the Loader.
	 * 
	 * @see LoadFrame
	 * @see         <!--
	 * @uml.property  name="loadFrame"
	 * @uml.associationEnd  
	 * -->
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
	 * @param t The type to take (currently: "game", "editorNew" and "editorExisting").
	 * 
	 * @see ApplicationDriver
	 * @see LoadFrame
	 */
	public LoadDriver(ApplicationDriver a,String t)
	{
		applicationDriver = a;
		type = t;
		loadFrame = new LoadFrame(this);
	}
	
	/**
	 * Main load routine.
	 * 
	 * @see LoadFrame
	 * @see <br />
	 * @see #testFileDoesNotExist(String)
	 * @see #testFileIsLoadable(String)
	 * @see <br />
	 * @see ApplicationDriver#runEditorExisting(String)
	 * @see ApplicationDriver#runEditorNew(String)
	 * @see ApplicationDriver#runGame(String)
	 * @see SimpleFrame#hideFrame()
	 * 
	 * @param file The file to load from.
	 */
	public void loadRoutine(String file)
	{
		//If it's a game to load in
		if (type.equals("game"))
		{
			if(this.testFileIsLoadable(file))
			{
				applicationDriver.runGame(file);
			}
		}
		//If it's a new editor to create
		else if (type.equals("editorNew"))
		{
			if(this.testFileIsCreatable(file))
			{
				applicationDriver.runEditorNew(file);
			}
		}
		//If it's an existing editor to load
		else if (type.equals("editorExisting"))
		{
			if(this.testFileIsLoadable(file))
			{
				applicationDriver.runEditorExisting(file);
			}
		}
		//get rid of the Load Frame
		loadFrame.hideFrame();
	}

	/**
	 * Tests to see if a file is load-able.
	 * 
	 * <br /><br />
	 * 
	 * Runs several checks to make sure it is, each test has their own error messages.
	 * 
	 * @param file The file to check.
	 * @return True if the file can be loaded.
	 * 
	 * @see #testFileExists(String)
	 * @see #testFileExtension(String)
	 */
	public boolean testFileIsLoadable(String file)
	{
		//if it passes all tests return true
		if(testFileExtension(file) && testFileExists(file))
		{
			return true;
		}
		//else return false
		else
		{
			return false;
		}
	}
	
	/**
	 * Tests that the file is create-able (i.e. does not exist already).
	 * 
	 * <br /><br />
	 * 
	 * Calls other test methods each with their own error messages.
	 * 
	 * @param file The file to test.
	 * @return True if the file can be created, false if not.
	 * 
	 * @see #testFileDoesNotExist(String)
	 * @see #testFileExtension(String)
	 */
	public boolean testFileIsCreatable(String file)
	{
		//If it passes all tests return true
		if(testFileExtension(file) && testFileDoesNotExist(file))
		{
			return true;
		}
		//Otherwise return false
		else
		{
			return false;
		}
	}
	
	/**
	 * Tests to make sure the file extension is correct (.asgf).
	 * 
	 * @param file The file to check.
	 * @return True if the file does have the correct extension, false if not.
	 * 
	 * @see ErrorFrame
	 */
	public boolean testFileExtension(String file)
	{
		//Ready the Error Frame
		ErrorFrame errorFrame;
		
		//If the file has the correct extension return true
		if(file.endsWith(".asgf"))
		{
			return true;
		}
		//If the filename contains an sort of extension (if it contains a ".") show the relevant error message and return false.
		else if(file.contains("."))
		{
			errorFrame = new ErrorFrame("Error 01 - '"+file+"' uses an incorrect file extension.");
			errorFrame.showFrame();
			return false;
		}
		//Else show the relevant error message and return false.
		else
		{
			errorFrame = new ErrorFrame("Error 02 - '"+file+"' does not have a file extension.");
			errorFrame.showFrame();
			return false;
		}
	}
	
	/**
	 * Tests that the file exists.
	 * 
	 * @param file The file to test.
	 * @return True if it does exist, false if not.
	 * 
	 * @see ErrorFrame
	 */
	public boolean testFileExists(String file)
	{
		//Set up the Error Frame
		ErrorFrame errorFrame;
		try
		{
			//Set up the scanner
			Scanner load = new Scanner(new InputStreamReader(new FileInputStream(file)));
			//Check it's something like the right format
			int i = load.nextInt();
			//If all appears fine return true
			if(i > 0)
			{
				return true;
			}
			//If that int is wrong for some reason it's likely formatted incorrectly/corrupted.
			else
			{
				errorFrame = new ErrorFrame("Error 03 - '"+file+"' is formatted incorrectly.");
				errorFrame.showFrame();
				return false;
			}
		}
		//Catch if it doesn't exist and print the relevant error message
		catch(FileNotFoundException f)
		{
			errorFrame = new ErrorFrame("Error 04 - '"+file+"' does not exist.");
			errorFrame.showFrame();
			return false;
		}
		//Catch any other exception, just in case of a disaster. Not expected to be thrown, but better safe than sorry.
		catch(Exception e)
		{
			errorFrame = new ErrorFrame("Error 05 - Unknown exception whilst loading '"+file+"'");
			errorFrame.showFrame();
			return false;
		}
	}
	
	/**
	 * Checks if the file does not already exist.
	 * 
	 * @param file The file to test.
	 * @return True if it doesn't exist, false if it does or there is an unexpected error.
	 * 
	 * @see ErrorFrame
	 */
	public boolean testFileDoesNotExist(String file)
	{
		//Set up the Error Frame
		ErrorFrame errorFrame;
		
		//Try..Catch block for loading the file, unusual in the sense that the catch part is the one being aimed for
		try
		{
			//Try to load in the file
			Scanner load = new Scanner(new InputStreamReader(new FileInputStream(file)));
			//And load the first int
			int i = load.nextInt();
			//if it's greater than 0 there's a good chance it's the correct file type
			if(i > 0)
			{
				//Create an Error Message to say the file exists
				errorFrame = new ErrorFrame("Error 06 - '"+file+"' already exists.");
				errorFrame.showFrame();
				//return false
				return false;
			}
			else
			{
				//TODO needs a different style of error to potentially allow overwriting.
				errorFrame = new ErrorFrame("Error 07 - '"+file+"' already exists, but is formatted incorrectly");
				errorFrame.showFrame();
				//return false?
				return false;
			}
		}
		//Catch if it's not found and return true (means the file does not exist
		catch(FileNotFoundException f)
		{
			return true;
		}
		//Catch any other exception, just in case of a disaster. Not expected to be thrown, but better safe than sorry.
		//Duplication necessary unfortunately
		catch(Exception e)
		{
			errorFrame = new ErrorFrame("Error 05 - Unknown exception whilst loading '"+file+"'");
			errorFrame.showFrame();
			return false;
		}
	}
	
	/**
	 * Closes the Loader.
	 * @see ApplicationDriver#showMenu()
	 * @see SimpleFrame#hideFrame()
	 */
	public void close()
	{
		loadFrame.hideFrame();
		applicationDriver.showMenu();
	}
}
