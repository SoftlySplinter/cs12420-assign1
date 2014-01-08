package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._0;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 * Defines the MenuBar in the Edtior Frame
 * 
 * @author Alexander Brown
 * @version 1.1.0
 * 
 * @see EditorFrame
 * @see EditorMenuListener
 *
 */
@SuppressWarnings("serial")
public class EditorMenuBar
extends JMenuBar
{

	/**
	 * Link back to the Editor Panel
	 * @see EditorPanel
	 */
	private EditorFrame editorFrame;

	/**
	 * Link to the Action Listener for the Menu.
	 * @see EditorMenuListener
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
		
		file.add(new JSeparator());
		
		file.add(save);
		file.add(load);
		
		file.add(new JSeparator());
		
		file.add(close);
		
		this.add(file);
		
		//View Menu
		JMenu view = new JMenu("View");
		JMenuItem preview = new JMenuItem("Preview");
		preview.addActionListener(editorMenuListener);
		view.add(preview);
		this.add(view);

		//Adds the Help menu
		JMenu help = new JMenu("Help");
		
		JMenuItem helpContents = new JMenuItem("Help Contents");
		helpContents.addActionListener(editorMenuListener);
		JMenuItem about = new JMenuItem("About A Simple Teaching Game");
		about.addActionListener(editorMenuListener);
		
		help.add(helpContents);
		
		help.add(new JSeparator());
		
		help.add(about);
		
		this.add(help);
	}
	
	/**
	 * Passes the method upward.
	 * @see EditorFrame#newEditor()
	 */
	public void newEditor()
	{
		editorFrame.newEditor();
	}
	
	/**
	 * Passes the method upward.
	 * @see EditorFrame#save()
	 */
	public boolean save()
	{
		return editorFrame.save();
	}
	
	/**
	 * Passes the method upward.
	 * @see EditorFrame#load()
	 */
	public void load()
	{
		editorFrame.load();
	}
	
	/**
	 * Passes the method upward.
	 * @see EditorFrame#close()
	 */
	public void close()
	{
		editorFrame.close();
	}

	public void preview()
	{
		editorFrame.preview();		
	}
}
