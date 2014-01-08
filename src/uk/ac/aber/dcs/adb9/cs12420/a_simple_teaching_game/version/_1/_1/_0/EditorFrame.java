package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._0;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

/**
 * Main Window for the Editor GUI
 * @author  Alexander Brown
 * @version  0.1.0
 * 
 * @see EditorDriver
 * @see EditorMenuBar
 * @see EditorPanel
 * @see  SimpleFrame
 * @see WordPanel
 */
@SuppressWarnings("serial")
public class EditorFrame
extends SimpleFrame
{
	/**
	 * The Limit of the array of words
	 */
	private int limit;

	/**
	 * Link back to the driver
	 * @see EditorDriver
	 * @see         <!--
	 * @uml.property  name="editorDriver"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorDriver editorDriver;

	/**
	 * Link to the Editor Panel
	 * @see EditorPanel
	 * @see         <!--
	 * @uml.property  name="editorPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorPanel editorPanel = new EditorPanel(this);	
	
	/**
	 * Link to the Menu Bar
	 * @see EditorMenuBar
	 * @see     <!--
	 * @uml.property  name="editorMenuBar"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorMenuBar editorMenuBar = new EditorMenuBar(this);
	
	/**
	 * Word Panel for the target Word.
	 * @see WordPanel
	 * @see         <!--
	 * @uml.property  name="targetWordPanel"
	 * @uml.associationEnd  
	 * -->
	 */
	private WordPanel targetWordPanel;

	/**
	 * Word Panels for the rest of the Words.
	 * @see WordPanel
	 * @see         <!--
	 * @uml.property  name="wordPanels"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 * -->
	 */
	private WordPanel[] wordPanels;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the window including initialising all the panels and adding them.
	 * 
	 * @see EditorDriver
	 * @see EditorMenuBar
	 * @see EditorPanel
	 * @see WordPanel
	 * @see SimpleFrame
	 * 
	 * @param e The Editor Panel to link back to.
	 */
	public EditorFrame(EditorDriver ed)
	{
		//Set the Title
		this.setTitle("A Simple Game - Editor");
		
		//Does nothing on close - one must physically click a button to close.
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//Sets up the link back
		editorDriver = ed;
		
		//Gets the limit value
		limit = editorDriver.getLimit();
		
		this.setOnTop();
		
		//Adds the Menu
		this.setJMenuBar(editorMenuBar);
		
		//Adds the Editor Panel Centrally
		this.add(editorPanel,BorderLayout.CENTER);
		
		//Sets the Editor Panel to have a Grid Layout based on Limit
		editorPanel.setLayout(new GridLayout(limit,1,5,5));
		
		//Sets up the target Word Panel
		targetWordPanel = new WordPanel(this,editorDriver.getWord(0));
		//And adds it to the Editor Panel
		editorPanel.add(targetWordPanel);
		
		//Sets up the array with a size of Limit
		wordPanels = new WordPanel[limit];
		
		//Iterates through the array, adding each word.
		for(int i=1;i<limit;i++)
		{
			wordPanels[i] = new WordPanel(this,editorDriver.getWord(i));
			//and adds them to the Editor Panel
			editorPanel.add(wordPanels[i]);
		}
		
		//Sets up n,e and w blank panels
		this.add(n,BorderLayout.NORTH);
		this.add(e,BorderLayout.EAST);
		this.add(w,BorderLayout.WEST);
		
		this.setLocation(250,100);
		
		//Pack and serve
		this.pack();
	}
	
	/**
	 * Saves every word, passing up to the save method in Editor Driver
	 * @see EdtiorDriver
	 * @see ErrorFrame
	 * @see <br />
	 * @see #setWords()
	 */
	public boolean save()
	{
		if(this.setWords())
		{
			//Try..Catch Block to stop Exceptions while saving
			try
			{
				//Try saving
				if(editorDriver.save(editorDriver.getFile()))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch (IOException e)
			{
				//Prints out errors
				ErrorFrame errorFrame = new ErrorFrame("An Error Occured Whilst Saving");
				errorFrame.showFrame();
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Closes the frame
	 * @see EditorDriver#close()
	 */
	public void close()
	{
		editorDriver.close();
	}

	/**
	 * Gets the Word in position <b>i</b> of the array in Editor Driver.
	 * 
	 * @param i The position of the Word to get.
	 * 
	 * @return The Word at position <b>i</b>.
	 * 
	 * @see EditorDriver#getWord(int)
	 */
	public Word getWord(int i)
	{
		return editorDriver.getWord(i);
	}
	
	/**
	 * Resets the words of Editor Driver to the new ones
	 * 
	 * @return True if there are no exceptions thrown, false if not.
	 * 
	 * @see EditorDriver#setWords(Word[])
	 * @see WordPanel#getWord()
	 */
	public boolean setWords()
	{
		try
		{
			//Set up the array
			Word[] words = new Word[limit];
			
			//Get the target word
			words[0] = targetWordPanel.getWord();
			
			//Iterate through the array, adding each word
			for(int i = 1;i<limit;i++)
			{
				words[i] = wordPanels[i].getWord();
			}
			
			//Set these words in Editor Driver
			editorDriver.setWords(words);
			
			//Return true if that goes without a hitch
			return true;
		}
		//Catch any null pointers and return false
		catch (NullPointerException e)
		{
			return false;
		}
		//catch any other exceptions and return false
		//TODO could do with a printout of details to an error file
		catch(Exception e)
		{
			return false;
		}
	}
	
	/**
	 * Passes the method upward.
	 * 
	 * @see EditorDriver#newEditor()
	 */
	public void newEditor()
	{
		editorDriver.newEditor();
	}
	
	/**
	 * Passes the method upward.
	 * 
	 * @see EditorDriver#loadEditor()
	 */
	public void load()
	{
		editorDriver.loadEditor();
	}
	
	/**
	 * Gets the limit from Editor Driver.
	 * @return  The Limit of the array.
	 * @see  EditorDriver#getLimit()
	 */
	public int getLimit()
	{
		return editorDriver.getLimit();
	}

	public void preview()
	{
		editorDriver.preview();
	}
}
