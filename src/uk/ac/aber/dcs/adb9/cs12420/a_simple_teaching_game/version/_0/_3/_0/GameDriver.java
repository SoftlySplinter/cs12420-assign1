package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._3._0;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Creates and runs games.
 * @author Alexander Brown
 * @version 0.1.1
 */
public class GameDriver
{
	/**
	 * Array in which all the Words are stored
	 * @see  Word
	 * @uml.property  name="words"
	 * @uml.associationEnd  multiplicity="(0 -1)"
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
	
	//private Scanner in = new Scanner(System.in);
	
	/**
	 * Generates the game window
	 * @uml.property  name="gameFrame"
	 * @uml.associationEnd  
	 */
	private GameFrame gameFrame;
	
	/**
	 * Link back to the application
	 * @uml.property  name="application"
	 * @uml.associationEnd  
	 */
	private ApplicationDriver application = new ApplicationDriver(this);
	
	/**
	 * Creates a new game.
	 * @param loadFile
	 */
	public GameDriver(String loadFile)
	{
		//try/catch block for loading the game
		try 
		{
			this.load(loadFile);
		}
		catch (Exception e)
		{
			System.out.println("Error Loading.");
		}
		
		gameFrame = new GameFrame(this,loadFile,words);
		
		//Debug - prints out all words in the array.
		for(int i=0;i<limit;i++)
		{
			System.out.println(words[i].toString()+"\n");
		}
	}
	
	/**
	 * Load method.
	 * @param filename The filename (not including extension) from which to load from. Typically the value of the target word.
	 * @throws IOException
	 */
	private void load(String filename)
	throws IOException
    {
		//makes sure the filename is lowercase
		filename = filename.toLowerCase();
		
		//adds the extension
		filename += ".asgf";
		
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
	
	public void endGame()
	{
		System.out.println("You win");
		application.menu();
	}
}
