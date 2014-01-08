package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._1._0;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Creates and runs games.
 * @author Alexander Brown
 * @version 0.1.0
 */
public class Game
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
	
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Creates a new game.
	 * @param loadFile
	 */
	public Game(String loadFile)
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
        for(int i=0;i<n;i++)
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
	 * Runs the game
	 */
	public void run()
	{
		String target = "";
		
		//Prints the word to find
		System.out.print("Word to find: ");
		for(int i=0;i<limit;i++)
		{
			if(words[i].isTarget())
			{
				target = words[i].getValue();
			}
		}
		//Could be words[0] the way I have set it up, but just to make sure
		
		System.out.println(target);
		
		//loop starts here
		boolean continueGame = true;
		String answer;
		while(continueGame)
		{
			//Prints out all words (TODO - in their locations)
			for(int i=0;i<limit;i++)
			{
				System.out.println(words[i].getValue());
			}
			System.out.println("______________________________________________");
			//User picks a word
			System.out.print("Enter the word you are looking for: ");
			answer = in.next();
			
			//if(it's right)
			if(answer.equals(target))
			{
				System.out.print("Correct word :)");
				continueGame = false;
			}
			//else
			else
			{
				System.out.println("Incorrect word");
				System.out.println("You are looking for the word: "+target);
			}
		}
	}
}
