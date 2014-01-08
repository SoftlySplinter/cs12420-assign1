package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._3._0;

import java.awt.BorderLayout;

/**
 * Shows the winning message.
 * 
 * @author Alexander Brown
 * @Version 0.1.0
 * 
 * @see SimpleFrame
 */
@SuppressWarnings("serial")
public class WinFrame
extends SimpleFrame
{

	/**
	 * Link to the Win Panel.
	 * @see WinPanel
	 * @see   <!--
	 * @uml.property   name="winPanel"
	 * @uml.associationEnd   inverse="winFrame:aSimpleGamev1p0p0.WinPanel"
	 */
	private WinPanel winPanel = new WinPanel(this);
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Sets up the Frame and adds the Win Panel
	 * 
	 * @see WinPanel
	 */
	public WinFrame()
	{
		this.setTitle("Winner");
		
		this.setOnTop();
		
		this.formatLayout();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.add(winPanel,BorderLayout.CENTER);
		
		this.pack();
	}
	
	/**
	 * Closes the Frame
	 * @see SimpleFrame#hideFrame()
	 */
	public void close()
	{
		this.hideFrame();
	}
}

