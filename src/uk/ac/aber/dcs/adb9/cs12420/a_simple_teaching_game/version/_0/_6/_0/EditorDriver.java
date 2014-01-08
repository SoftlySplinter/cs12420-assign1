package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._6._0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Loads a Game and allows editing of it. <br /><br /> <small><b>Note:</b> A new game is created as a blank(ish) game and then loaded into this.</small>
 * @author  Alexander Brown
 * @version  0.1.1
 */
public class EditorDriver
{
	/**
	 * Link back to the Application.
	 * @see ApplicationDriver
	 * @see       <!--
	 * @uml.property  name="application"
	 * @uml.associationEnd  
	 */
	private ApplicationDriver application;
	
	/**
	 * Link to the Editor Panel
	 * @see EditorPanel
	 * @see       <!--
	 * @uml.property  name="editorFrame"
	 * @uml.associationEnd  
	 */
	private EditorFrame editorFrame;
	
	/**
	 * Scanner to stop repeated definition (note: although it's not actually repeated, I prefer to put it as a instance variable in case it does need to be used more than once).
	 * @deprecated
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Array in which all the Words are created.
	 * @see Word
	 * @see       <!--
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
	 * The file name of where the array of words is saved to.
	 */
	private String loadFile;
	
	/**
	 * Sets the limit to the number of words.
	 * @uml.property  name="limit"
	 */
	private int limit = 4; //will allow modifications later
	
	/**
	 * Constructor for the Editor.
	 * 
	 * <br /><br />
	 * 
	 * Can create a new game (which just takes the Target Word's value and saves as a default file).
	 * 
	 * <br /><br />
	 * 
	 * Always loads the given file into the Editor Frame.
	 * 
	 * @param file The file from which to either load or create a new game from.
	 * @param a The Application this is linked from.
	 * @param b If false creates a new game, otherwise just loads from <b>file</b>.
	 * 
	 * @see EditorFrame
	 * @see ApplicationDriver
	 */
	public EditorDriver(String file,ApplicationDriver a,boolean b)
	{
		//Links back to the Application
		application = a;
		
		//If b is false, creates a new game with the target word set as file (minus .asgf of course)
		if(b==false)
		{
			//Try..Catch block to make sure it words fine
			try
			{
				this.createNew(file);
			}
			catch (IOException e)
			{
				//TODO - Needs more than just the auto-generated block below
				e.printStackTrace();
			}
		}
		
		//Loads from file.
		this.loadExisting(file);
		
		//Creates the Editor Frame
		editorFrame = new EditorFrame(this);
		
		//runs the Editor.
		runEditor();
	}
	
	/**
	 * Shows the Editor Frame.
	 * 
	 * <br /><br />
	 * 
	 * <small>Back in older versions this used to be more complex, however due to the nature of GUIs it does not need to be anymore.</small>
	 */
	public void runEditor()
	{
		editorFrame.showFrame();
	}
	
	/**
	 * Gets the new values of words.
	 * @param ws  The array list to take these words from.
	 * @see  EditorFrame#setWords()
	 * @uml.property  name="words"
	 */
	public void setWords(Word[] ws)
	{
		for(int i=0;i<limit;i++)
		{
			words[i] = ws[i];
		}
	}
	
	/**
	 * Saves every word created and stores it to be read by the Game.
	 * @param filename The name under which to save the file as (excluding the extension in this case).
	 * <br />
	 * Typically the target word.
	 * @throws IOException
	 */
	public void save(String filename)
	throws IOException
    {
		//Add the file extension '.asgf' (A Simple Game File)
		if(filename.contains(".asgf"))
		{
			//do nothing
		}
		else
		{
			filename += ".asgf";
		}
        
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
	 * Loads every word in a file and inputs them into the array.
	 * @param filename The filename from which to load from (with or without the extension, that is added in the method)
	 */
	public void loadExisting(String filename)
	{
		//Makes the extension(.asgf) blank
		filename.replaceFirst(".asgf", "");
		//Then adds it again.
		filename += ".asgf";
		
		int n = 1;
		
		//Try..Catch block to make loading run smoothly.
		try
		{
			//Set up the reader
			Scanner load = new Scanner(new InputStreamReader(new FileInputStream(filename)));

			//Try..Catch block to make sure there is an 'n' (in case of corrupted/incorrect files.
			try
			{
				//Try loading n
				n = load.nextInt();
				limit = n;
			}
			catch(NullPointerException e)
			{
				//if n doesn't exist make n=0
				n = 0;
			}
					
			//If there is some details in the file
			if(n!=0)
			{
				//Set up the array
				words = new Word[n];
				//For every word in the file
				for(int i=0;i<n;i++)
				{
					//Read all the required information
					//Value of the Word
					String v = load.next();
					//X and Y coordinates
					int x = load.nextInt();
					int y = load.nextInt();
					//If it's the target Word
					boolean t = load.nextBoolean();
					//Create the word
					words[i] = new Word(v,x,y,t);
					//Increment the wordCount
					wordCount++;
				}
				System.out.println("Loaded "+filename);
			}
			//if the file is blank.
			else
			{
				System.out.println("Loading Failed");
				//Error Message "File does not contain any details"
			}
			//Close the reader
			load.close();
		}
		
		//Catch Block, just creates a new file
		catch (FileNotFoundException e1)
		{
			//Error "File not found"
		}
	}
	
	/**
	 * Creates and saves a new game. Sets the target word equal to the filename (minus extension) and then inputs default values to the rest of the words.
	 * @param filename
	 * @throws IOException
	 */
	public void createNew(String filename)
	throws IOException
    {
		//Add the file extension '.asgf' (A Simple Game File)
		filename.replaceFirst(".asgf", "");
		filename += ".asgf";

        
        //Ready the saver
        PrintWriter save = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename)));
        
        //Print the number of words
        save.println(limit);
        
        //Removes the extension
        save.println(filename.replaceFirst(".asgf", ""));
        //Default coordinates
        save.println("20");
        save.println("20");
        //This is the target word
        save.println("true");
        
        //Loop for every word
        for(int i=1;i<limit;i++)
        {
        	//Print all the aspects of the file, one per line. (Value,X,Y,if it is the target word
        	save.println("Word"+i);
        	//Sets up coordinates
        	save.println(0);
        	save.println(0);
        	//None of these are the target word
        	save.println(false);
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
	
	public void newEditor()
	{
		application.runEditorNewLoader();
	}
	
	public void loadEditor()
	{
		application.runEditorExistingLoader();
	}
	
	/**
	 * Closes the Editor
	 */
	public void close()
	{
		editorFrame.hideFrame();
		application.showMenu();
	}
	
	/**
	 * Gets a single word
	 * @param i The position in the array of that word
	 * @return The Word
	 * @see Word
	 */
	public Word getWord(int i)
	{
		return words[i];
	}
	
	/**
	 * Gets the limit of the array
	 * @return  The Limit of the array
	 * @uml.property  name="limit"
	 */
	public int getLimit()
	{
		return limit;
	}
}
