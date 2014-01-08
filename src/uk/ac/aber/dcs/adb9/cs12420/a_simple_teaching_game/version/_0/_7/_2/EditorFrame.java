package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

/**
 * Main Window for the Editor GUI
 * @author  Alexander Brown
 * @version  0.1.0
 * @see  SimpleFrame
 */
@SuppressWarnings("serial")
public class EditorFrame
extends SimpleFrame
{
	/**
	 * The Limit of the array of words
	 * @uml.property  name="limit"
	 */
	private int limit;

	/**
	 * Link back to the driver
	 * @see EditorDriver
	 * @see         <!--
	 * @uml.property  name="editorDriver"
	 * @uml.associationEnd  
	 */
	private EditorDriver editorDriver;

	/**
	 * Link to the Editor Panel
	 * @see EditorPanel
	 * @see         <!--
	 * @uml.property  name="editorPanel"
	 * @uml.associationEnd  
	 */
	private EditorPanel editorPanel = new EditorPanel(this);	
	
	/**
	 * Link to the Menu Bar
	 * @see EditorMenuBar
	 * @see     <!--
	 * @uml.property  name="editorMenuBar"
	 * @uml.associationEnd  
	 */
	private EditorMenuBar editorMenuBar = new EditorMenuBar(this);
	
	/**
	 * Word Panel for the target Word.
	 * @see WordPanel
	 * @see         <!--
	 * @uml.property  name="targetWordPanel"
	 * @uml.associationEnd  
	 */
	private WordPanel targetWordPanel;

	/**
	 * Word Panels for the rest of the Words.
	 * @see WordPanel
	 * @see         <!--
	 * @uml.property  name="wordPanels"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private WordPanel[] wordPanels;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the window including initialising all the panels and adding them.
	 * 
	 * @see SimpleFrame
	 * @see EditorDriver
	 * @see EditorPanel
	 * @see WordPanel
	 * 
	 * @param e The Editor Panel to link back to.
	 */
	public EditorFrame(EditorDriver ed)
	{
		//Runs the super method for simplicity
		super("A Simple Game - Editor");
		
		//Does nothing on close - one must physically click a button to close.
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//Sets up the link back
		editorDriver = ed;
		
		//Gets the limit value
		limit = editorDriver.getLimit();
		
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
		
		//Pack and serve
		this.pack();
	}
	
	/**
	 * Saves every word, passing up to the save method in Editor Driver
	 * @see EdtiorDriver
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
	 * @see EditorFrame
	 */
	public void close()
	{
		editorDriver.close();
	}

	/**
	 * Gets the Word in position <b>i</b> of the array in Editor Driver.
	 * @param i The position of the Word to get.
	 * @return The Word at position <b>i</b>.
	 * @see EditorDriver
	 */
	public Word getWord(int i)
	{
		return editorDriver.getWord(i);
	}
	
	/**
	 * Resets the words of Editor Driver to the new ones
	 * @see EditorDriver#setWords(Word[])
	 * @see WordPanel#getWord()
	 */
	public boolean setWords()
	{
		try
		{
			Word[] words = new Word[limit];
			
			words[0] = targetWordPanel.getWord();
			
			for(int i = 1;i<limit;i++)
			{
				words[i] = wordPanels[i].getWord();
			}
			
			editorDriver.setWords(words);
			
			return true;
		}
		catch (NullPointerException e)
		{
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	/**
	 * Creates a new Editor.
	 */
	public void newEditor()
	{
		editorDriver.newEditor();
	}
	
	/**
	 * Loads an Editor.
	 */
	public void load()
	{
		editorDriver.loadEditor();
	}
	
	/**
	 * Gets the limit from Editor Driver.
	 * @return  The Limit of the array.
	 * @see  EdtiorDriver
	 * @uml.property  name="limit"
	 */
	public int getLimit()
	{
		return editorDriver.getLimit();
	}
}
