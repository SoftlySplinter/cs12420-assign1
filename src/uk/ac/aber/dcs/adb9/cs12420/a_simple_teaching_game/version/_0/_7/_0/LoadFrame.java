package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._0;

import java.awt.BorderLayout;

/**
 * The main window for Loading (and possibly saving).
 * 
 * @author Alexander Brown
 * @version 0.0.1
 * @see LoadDriver
 * @see LoadPanel
 * @see SimpleFrame
 */
@SuppressWarnings("serial")
public class LoadFrame
extends SimpleFrame
{

	/**
	 * The Load Panel this contains
	 * @see LoadPanel
	 * @see         <!--
	 * @uml.property  name="loadPanel"
	 * @uml.associationEnd  
	 */
	private LoadPanel loadPanel = new LoadPanel(this);
	
	/**
	 * The link back to the Load Driver
	 * @see LoadDriver
	 * @see         <!--
	 * @uml.property  name="loadDriver"
	 * @uml.associationEnd  
	 */
	private LoadDriver loadDriver;
	
	/**
	 * Constructor
	 * 
	 * <br /><br />
	 * 
	 * Sets up the layout of the frame and adds the Load Panel to it.
	 * 
	 * @param l The Load Driver to link back to
	 * 
	 * @see LoadDriver
	 * @see LoadPanel
	 * @see SimpleFrame#formatLayout()
	 * @see SimpleFrame#showFrame()
	 */
	public LoadFrame(LoadDriver l)
	{
		//Link back to the Load Driver
		loadDriver = l;
		
		//Do not allow closing in the normal fashion
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//Add the Load Panel in the center
		this.add(loadPanel,BorderLayout.CENTER);
		
		//And format the layout
		this.formatLayout();
		
		//Show the frame
		this.showFrame();
		
		//Pack it to size
		this.pack();
	}
	
	/**
	 * Passes the load routine upward
	 * @param file The file to load from
	 * @see LoadDriver#loadRoutine(String)
	 */
	public void loadRoutine(String file)
	{
		loadDriver.loadRoutine(file);
	}
	
	/**
	 * Passes the close method upwards
	 * @see LoadDriver#close()
	 */
	public void close()
	{
		loadDriver.close();
	}
}
