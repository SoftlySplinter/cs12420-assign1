package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Creates and runs games.
 * 
 * @author Alexander Brown
 * @version 1.1.1
 * 
 * @see ApplicationDriver
 * @see GameFrame
 */
public class GameDriver
{
	/**
	 * Array in which all the Words are stored
	 * @see Word
	 */
	private Word[] words;
	
	/**
	 * Number of Words in the array of words
	 * @see Word
	 */
	private int wordCount;
	
	/**
	 * Sets the limit to the number of words.
	 */
	private int limit;
	
	/**
	 * Generates the game window
	 * @see GameFrame
	 */
	private GameFrame gameFrame;
	
	/**
	 * Link back to the application
	 * @see ApplicationDriver
	 */
	private ApplicationDriver applicationDriver;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Loads in a new game
	 * .
	 * @param loadFile The file to load the Game from.
	 * @param a The Application Driver to link back to.
	 * 
	 * @see ApplicationDriver
	 * @see GameFrame
	 */
	public GameDriver(String loadFile,ApplicationDriver a)
	{
		applicationDriver = a;
		
		//try/catch block for loading the game
		//Exceptions should already have been dealt with before being passed in.
		try 
		{
			this.load(loadFile);
		}
		catch (Exception e)
		{
			System.out.println("Error Loading.");
		}
		
		//Gets the target word
		String target = "";
		
		for(int i=0;i<words.length;i++)
		{
			if(words[i].isTarget())
			{
				target = words[i].getValue();
			}
		}
		
		System.out.println("Starting game '"+loadFile+"'");
		
		//Creates the Game Frame
		gameFrame = new GameFrame(this,target,words);
		
		gameFrame.showFrame();
		
		//Debug - prints out all words in the array.
		/*
		for(int i=0;i<limit;i++)
		{
			System.out.println(words[i].toString()+"\n");
		}
		*/
	}
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Used in the Editor Preview.
	 * 
	 * @param a The Application to link back to.
	 */
	public GameDriver(ApplicationDriver a)
	{
		applicationDriver = a;
	}
	
	/**
	 * Load method.
	 * 
	 * @param filename The filename (excluding extension) from which to load from. Typically the value of the target word.
	 * 
	 * @see Word
	 * 
	 * @throws IOException
	 */
	private void load(String filename)
	throws IOException
    {
		//prepares the file reader.
        Scanner load = new Scanner(new InputStreamReader(new FileInputStream(filename)));
        
        //gets the size of the array
        int n = load.nextInt();
        
        //sets the size of the array
        words = new Word[n];
        limit = n;
        load.nextLine();
        
        //loops for the number of words in the array
        for(int i=0;i<limit;i++)
        {
        	//gets all the required information about a word
            String v = load.next();
            int x = load.nextInt();
            load.nextLine();
            int y = load.nextInt();
            load.nextLine();
            boolean t = load.nextBoolean();
            
            //creates the word
            words[i] = new Word(v,x,y,t);
            
            //increments the word count
            wordCount ++;
        }
        
        //closes the file
        load.close();
	}
	
	/**
	 * Ends the game. Hides the Game Frame and shows the main menu.
	 * 
	 * @see ApplicationDriver#showMenu()
	 * @see GameFrame#hideFrame()
	 */
	public void endGame()
	{
		gameFrame.hideFrame();
		applicationDriver.showMenu();
	}
	
	/**
	 * Gets the Value of the Target Word.
	 * 
	 * @return The Value of the Target Word.
	 * 
	 * @see Word#getValue()
	 */
	public String getTargetWordValue()
	{
		return words[0].getValue();
	}

	/**
	 * Hides that pesky Main Menu!
	 */
	public void hideMainMenu()
	{
		applicationDriver.hideMenu();
	}
}
