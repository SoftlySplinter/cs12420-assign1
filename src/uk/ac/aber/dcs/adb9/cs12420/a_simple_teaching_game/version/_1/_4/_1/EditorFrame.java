package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	private EditorInteractivePanel edtiorInteractivePanel;
	
	/**
	 * Link to the Menu Bar
	 * @see EditorMenuBar
	 * @see     <!--
	 * @uml.property  name="editorMenuBar"
	 * @uml.associationEnd  
	 * -->
	 */
	private EditorMenuBar editorMenuBar = new EditorMenuBar(this);
	
	private Word[] words;
	
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
	
	private JTextField nextGameFile;
	
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
		

		
		//Sets the Editor Panel to have a Grid Layout based on Limit
		editorPanel.setLayout(new GridLayout(limit+1,1,5,5));
		
		words = new Word[limit];
		
		//Get the words
		this.getWords();
		
		JPanel nextGamePanel = new JPanel();
		nextGamePanel.setLayout(new GridLayout (1,2,0,0));
		
		nextGameFile = new JTextField(editorDriver.getNextGameFile(),15);
		nextGamePanel.add(new JLabel("Next Game File:"));
		nextGamePanel.add(nextGameFile);
		
		JPanel pane = new JPanel();
		pane.add(nextGamePanel,BorderLayout.CENTER);
		
		editorPanel.add(pane);
		
		//Sets up the target Word Panel
		targetWordPanel = new WordPanel(this,words[0]);
		//And adds it to the Editor Panel
		editorPanel.add(targetWordPanel);
		
		//Sets up the array with a size of Limit
		wordPanels = new WordPanel[limit];
		
		//Iterates through the array, adding each word.
		for(int i=1;i<limit;i++)
		{
			wordPanels[i] = new WordPanel(this,words[i]);
			//and adds them to the Editor Panel
			editorPanel.add(wordPanels[i]);
		}
		
		//Set up the Interactive Panel.
		ApplicationDriver a = new ApplicationDriver();
		GameDriver gD = new GameDriver(a);
		GameFrame gF = new GameFrame(gD, editorDriver.getFile(), words);
		edtiorInteractivePanel = new EditorInteractivePanel(this, gF, targetWordPanel.getValue(), words);
		
		//Adds both editors to a panel and adds the panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,0,0));
		panel.add(edtiorInteractivePanel);
		panel.add(editorPanel);
		this.add(panel,BorderLayout.CENTER);
		
		//Sets up n,e and w blank panels
		this.add(n,BorderLayout.NORTH);
		this.add(e,BorderLayout.EAST);
		this.add(w,BorderLayout.WEST);
		
		this.setLocation(250,100);
		
		//Pack and serve
		this.pack();
		
		this.refresh(this);
	}
	
	private void getWords()
	{
		for(int i = 0;i<limit;i++)
		{
			words[i] = editorDriver.getWord(i);
		}
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
				editorDriver.setNextGameFile(nextGameFile.getText()+"");
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
	
	public void refresh(Object o)
	{
		Word[] w = words;
		//System.out.println(o.getClass());
		if(o.getClass().equals(edtiorInteractivePanel.getClass()))
		{
			words = edtiorInteractivePanel.getWords();
		}
		else
		{
			words[0] = targetWordPanel.getWord();
			for(int i = 1;i<limit;i++)
			{
				words[i] = wordPanels[i].getWord();
			}
		}
		
		this.setWords();
		
		if(editorDriver.testBeforeSaving())
		{	
			//Do nothing, it passed!
		}
		else
		{
			words = w;
			this.setWords();
		}
		
		edtiorInteractivePanel.refreshWords(words);
		targetWordPanel.refresh(words[0]);
		for(int i=1;i<limit;i++)
		{
			wordPanels[i].refresh(words[i]);
			
		}	
	}

	public ApplicationDriver getApp()
	{
		return editorDriver.getApplicationDriver();
	}
}
