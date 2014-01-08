package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._2._0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Creates the game. Will later allow editing of previous games
 * @author Alexander Brown
 * @version 0.1.1
 */
public class EditorDriver
{
	/**
	 * Application link
	 * @uml.property  name="application"
	 * @uml.associationEnd  
	 */
	private ApplicationDriver application;
	
	/**
	 * Scanner to stop repeated definition (note: although it's not actually repeated, I prefer to put it as a instance variable in case it does need to be used more than once).
	 */
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Array in which all the Words are created
	 * @see  Word
	 * @uml.property  name="words"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Word[] words;	
	
	/**
	 * Number of Words in the array of words
	 * @see Word
	 */
	private int wordCount = 0;
	
	/**
	 * The file name of where the array of words is saved to
	 */
	private String loadFile;
	
	/**
	 * Sets the limit to the number of words.
	 */
	private int limit = 4; //to allow modifications later
	
	/**
	 * Constructor for the Editor.
	 * <br />
	 * <br />
	 * Creates an array of Words, asks for details on each word and saves it under the value of the target word.
	 */
	public EditorDriver()
	{
		//Sets the size of the array (for future reference this will be to allow modifications)
		words = new Word[limit];
		
		//Asks for details on the target word
		System.out.print("Enter Target: ");
		String target = in.next();
		loadFile = target;
		
		System.out.print("Enter X Location: ");
		int x = in.nextInt();
		in.nextLine();
		
		System.out.print("Enter Y Location: ");
		int y = in.nextInt();
		in.nextLine();
		
		words[0] = new Word(target,x,y,true);
	//Debug - Prints the word out
	/*
		System.out.println(words[0].toString())
	*/
		wordCount ++;
		
		//loops for the rest of the other words
		while(wordCount<limit)
		{
			System.out.print("Enter Other Word: ");
			String temp = in.next();
			
			System.out.print("Enter X Location: ");
			int xTemp = in.nextInt();
			in.nextLine();
			
			System.out.print("Enter Y Location: ");
			int yTemp = in.nextInt();
			in.nextLine();
			
			words[wordCount] = new Word(temp,xTemp,yTemp,false);
			
		//Debug - Prints out the word.	
		/*
			System.out.println(words[wordCount].toString());
		*/
			//Increment wordCount
			wordCount++;
		}
		
		//Saving try/catch block
		try
		{
			this.save(target);
		}
		catch(Exception e)
		{
			System.out.println("Saving failed.");
		}
	}
	
	/**
	 * Saves every word created and stores it to be read by the Game.
	 * @param filename The name under which to save the file as (without the extension as it is added in the method).
	 * <br />
	 * Typically the target word.
	 * @throws IOException
	 */
	private void save(String filename)
	throws IOException
    {
		//Makes the filename lowercase for convenience (personal preference to make them lowercase, but I think they look better that way).
		filename = filename.toLowerCase();
		
		//Add the file extension '.asgf' (A Simple Game File)
        filename += ".asgf";
        
        //Ready the saver
        PrintWriter save = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename)));
        
        //Print the number of words
        save.println(limit);
        
        //Loop for every word
        for(int i=0;i<limit;i++)
        {
        	//Get the word
        	Word w = words[i];
        	
        	//Print all the aspects of the file, one per line. (Value,X,Y,if it is the target word
        	save.println(w.getValue());
        	save.println(w.getX());
        	save.println(w.getY());
        	save.println(w.isTarget());
        }
        
        //Close the file
        save.close();
        
        //Successful save message
        System.out.println("Saved to "+filename);
	}

	/**
	 * Gets the name of the file it will have been saved to (without the extension as it's added in the load method
	 * @return The file name
	 */
	public String getFile()
	{
		return loadFile;
	}
}
