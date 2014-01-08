package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._0;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class EditorMenuBar
extends JMenuBar
{

	/**
	 * Link back to the Editor Panel
	 * @see EditorPanel
	 * @see     <!--
	 * @uml.property  name="editorPanel"
	 * @uml.associationEnd  
	 */
	private EditorFrame editorFrame;

	/**
	 * Link to the Action Listener for the Menu.
	 * @see EditorMenuListener
	 * @see     <!--
	 * @uml.property  name="editorMenuListener"
	 * @uml.associationEnd  
	 */
	private EditorMenuListener editorMenuListener = new EditorMenuListener(this);
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Links back to the Editor Frame, creates several Menus and their respective Items and adds the Editor Menu Listener to them.
	 * 
	 * @param e The Editor Frame to link back to.
	 * 
	 * @see EditorFrame
	 * @see EditorMenuListener
	 * @see JMenu
	 * @see JMenuItem
	 */
	public EditorMenuBar(EditorFrame e)
	{
		//Link back to the Editor Frame
		editorFrame= e;
		
		//Adds the File menu
		JMenu file = new JMenu("File");
		
		JMenuItem newEditor = new JMenuItem("New");
		newEditor.addActionListener(editorMenuListener);
		
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(editorMenuListener);
		
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(editorMenuListener);
		
		JMenuItem close = new JMenuItem("Save and Close");
		close.addActionListener(editorMenuListener);
		
		file.add(newEditor);
		file.add(save);
		file.add(load);
		file.add(close);
		
		this.add(file);
		
		//TODO - View Menu
		/*
		JMenu view = new JMenu("View");
		JMenuItem preview = new JMenuItem("Preview");
		preview.addActionListener(editorMenuListener);
		view.add(preview);
		this.add(view);
		*/

		
		
		//Adds the Help menu
		JMenu help = new JMenu("Help");
		
		JMenuItem helpContents = new JMenuItem("Help Contents");
		helpContents.addActionListener(editorMenuListener);
		JMenuItem about = new JMenuItem("About A Simple Teaching Game");
		about.addActionListener(editorMenuListener);
		
		help.add(helpContents);
		help.add(about);
		
		this.add(help);
	}
	
	/**
	 * Opens a new Editor
	 * @see EditorFrame#newEditor()
	 */
	public void newEditor()
	{
		editorFrame.newEditor();
	}
	
	/**
	 * Saves the current Editor
	 * @see EditorFrame#save()
	 */
	public void save()
	{
		editorFrame.save();
	}
	
	/**
	 * Loads an existing Editor
	 * @see EditorFrame#load()
	 */
	public void load()
	{
		editorFrame.load();
	}
	
	/**
	 * Closes the Editor
	 * @see EditorFrame#close()
	 */
	public void close()
	{
		editorFrame.close();
	}
}
