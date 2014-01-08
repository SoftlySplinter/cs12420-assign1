package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._0._0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Loads a Game and allows editing of it
 * 
 *  <br /><br />
 *  
 *  <small><b>Note:</b> A new game is created as a blank(ish) game and then loaded into this.</small>
 *  
 * @author  Alexander Brown
 * @version  0.1.2
 * 
 * @see ApplicationDriver
 * @see EditorFrame
 */
public class EditorDriver
{
	/**
	 * Link back to the Application.
	 * @see ApplicationDriver
	 * @see       <!--
	 * @uml.property  name="application"
	 * @uml.associationEnd 
	 * --> 
	 */
	private ApplicationDriver application;
	
	/**
	 * Link to the Editor Panel
	 * @see EditorPanel
	 * @see       <!--
	 * @uml.property  name="editorFrame"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorFrame editorFrame;
	
	/**
	 * Array in which all the Words are created.
	 * @see Word
	 * @see       <!--
	 * @uml.property  name="words"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 * -->
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
	 * @see ApplicationDriver
	 * @see EditorFrame
	 * @see <br />
	 * @see #createNew(String)
	 * @see #loadExisting(String)
	 * @see #runEditor()
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
		
		loadFile = file;
		
		//Creates the Editor Frame
		editorFrame = new EditorFrame(this);
		
		//runs the Editor.
		this.runEditor();
	}
	
	/**
	 * Shows the Editor Frame.
	 * 
	 * <br /><br />
	 * 
	 * <small>Back in older versions this used to be more complex, however due to the nature of GUIs it does not need to be anymore.</small>
	 * 
	 * @see SimpleFrame#showFrame()
	 */
	public void runEditor()
	{
		editorFrame.showFrame();
	}
	
	/**
	 * Gets the new values of words and sets them.
	 * @param ws  The array list to take these words from.
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
	 * 
	 * @param filename The name under which to save the file as (excluding the extension in this case).
	 * <br />
	 * Typically the target word.
	 * 
	 * @return True if the save can be done/was successful, else false.
	 * 
	 * @throws IOException
	 * 
	 * @see Word
	 * @see <br /> 
	 * @see #testBeforeSaving()
	 */
	public boolean save(String filename)
	throws IOException
    {
        try
        {
			if (testBeforeSaving())
			{
				//Ready the saver
				PrintWriter save = new PrintWriter(new OutputStreamWriter(
						new FileOutputStream(filename)));
				//Print the number of words
				save.println(limit);
				//Loop for every word
				for (int i = 0; i < limit; i++) {
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
				System.out.println("Saved to " + filename);
				return true;
			}
			else
			{
				return false;
			}
		}
        catch(NullPointerException e)
        {
			return false;
		}
	}
	
	/**
	 * Loads every word in a file and inputs them into the array.
	 * 
	 * <br /><br />
	 * 
	 * Exceptions should be caught before the filename is passed into this method.
	 * 
	 * @param filename The filename from which to load from (with the extension).
	 * 
	 * @see Word
	 */
	public void loadExisting(String filename)
	{
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
				//Error Message should have shown before this.
			}
			//Close the reader
			load.close();
		}
		
		//Catch Block, just creates a new file
		catch (FileNotFoundException e1)
		{
			//Error should have been called before this
		}
	}
	
	/**
	 * Creates and saves a new game. Sets the target word equal to the filename (minus extension) and then inputs default values to the rest of the words.
	 * 
	 * <br /><br />
	 * 
	 * Exceptions should be caught before the filename is passed into this method.
	 * 
	 * @param filename The filename to create to.
	 * 
	 * @throws IOException
	 */
	public void createNew(String filename)
	throws IOException
    {
		//Ready the saver
        PrintWriter save = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename)));
        
        //Print the number of words
        save.println(limit);
        
        //Removes the extension
        save.println(filename.replaceFirst(".asgf", ""));
        //Default coordinates
        save.println("10");
        save.println("10");
        //This is the target word
        save.println("true");
        
        //Loop for every word
        for(int i=1;i<limit;i++)
        {
        	//Print all the aspects of the file, one per line. (Value,X,Y,if it is the target word
        	save.println("Word"+i);
        	//Sets up coordinates
        	save.println(20*i);
        	save.println(20*i);
        	//None of these are the target word
        	save.println(false);
        }
        
        //Close the file
        save.close();
        
        //Successful save message
        System.out.println("Saved to "+filename);
	}

	/**
	 * Gets the name of the file it will have been saved to (without the extension as it's added in the load method.
	 * 
	 * @return The file name
	 */
	public String getFile()
	{
		return loadFile;
	}
	
	/**
	 * Passes the method upward.
	 * @see ApplicationDriver#runEditorNewLoader()
	 */
	public void newEditor()
	{
		application.runEditorNewLoader();
	}
	
	/**
	 * Passes the method upward
	 * @see ApplicationDriver#runEditorExistingLoader()
	 */
	public void loadEditor()
	{
		application.runEditorExistingLoader();
	}
	
	/**
	 * Closes the Editor
	 * @see ApplicationDriver#showMenu()
	 * @see SimpleFrame#hideFrame()
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
	 */
	public int getLimit()
	{
		return limit;
	}
	
	/**
	 * Tests that the save value is valid before saving.
	 * 
	 * @return True if it passes all test, false if not
	 * 
	 * @see #testPositions()
	 * @see #testValues()
	 */
	public boolean testBeforeSaving()
	{
		if(testValues() && testPositions())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Tests to make sure that values are not equal or null. Displays the relevant Error Message if there's an error.
	 * 
	 * @return True if the above is correct, false if not.
	 * 
	 * @see ErrorFrame
	 * @see <br />
	 * @see Word#getValue()
	 */
	public boolean testValues()
	{
		ErrorFrame errorFrame;
		boolean b = false;
		
		//Iterate through the array
		for(int i = 0;i<limit;i++)
		{
			//get the value of Word i
			String v1 = words[i].getValue();
			
			//Iterate through the array again
			for(int j = 0;j<limit;j++)
			{
				//get the value of Word j
				String v2 = words[j].getValue();
				
				//if the words are the same ignore them.
				if(i==j)
				{
					//do nothing
				}
				else
				{
					//If there's a null
					if(v2.equals(null) || v2.equals(""))
					{
						errorFrame = new ErrorFrame("Error 08 - Words cannot be null.");
						errorFrame.showFrame();
						b = false;
						return false;
					}
					//If they're equal set b to false just in case and return false
					else if(v2.equals(v1))
					{
						errorFrame = new ErrorFrame("Error 09 - Words cannot be equal.");
						errorFrame.showFrame();
						b = false;
						return false;
					}
					//else they're not equal and b = true
					else
					{
						b = true;
					}
				}
			}
		}
		//return b (should be true if it reaches this stage).
		return b;
	}
	
	/**
	 * Tests to makes sure the positions aren't too close
	 * 
	 * @return True if the above is true, false if not.
	 * 
	 * @see ErrorFrame
	 * @see Word
	 */
	public boolean testPositions()
	{
		boolean b = false;
		//set up the Error Message
		ErrorFrame errorFrame;
		
		//Iterate through the array
		for(int i=0;i<limit;i++)
		{
			//Get the position of Word i
			int x1 = words[i].getX();
			int y1 = words[i].getY();
			
			//Iterate through the array again
			for(int j=0;j<limit;j++)
			{
				//Get the length (in characters) of the value (used in the tolerance) and the position of Word j
				int l = (words[j].getValue()).length();
				int x2 = words[j].getX();
				int y2 = words[j].getY();
				
				//If they're equal do nothing as they are already equal
				if(i==j)
				{
					//do nothing
				}
				//If the position is within a tolerance of another words position
				else if( (x1 > (x2-4) && x1 < (x2+((l*l)+l+10)) ) && ( y1 > (y2-11) && y1 < (y2+4) ) )
				{
					errorFrame = new ErrorFrame("Error 10 - Words "+words[i].getValue()+" and "+words[j].getValue()+" cannot be that close");
					errorFrame.showFrame();
					b = false;
					return false;
				}
				//Otherwise b = true.
				else
				{
					b = true;
				}
			}
		}
		//return b (should be true if it reaches this stage).
		return b;
	}
}
