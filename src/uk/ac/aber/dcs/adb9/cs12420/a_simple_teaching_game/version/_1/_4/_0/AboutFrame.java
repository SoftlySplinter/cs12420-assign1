package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

/**
 * Holds details about the Game.
 * @author Alexander Brown
 * @version 1.1.0
 *
 * @see SimpleFrame
 */
@SuppressWarnings("serial")
public class AboutFrame
extends SimpleFrame
{
	private AboutPanel aboutPanel = new AboutPanel(this);
	
	
	
	public AboutFrame()
	{
		super("A Simple Game - About");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setOnTop();
		
		this.add(aboutPanel);
		
		this.formatLayout();
		
		this.pack();
	}

	public void close()
	{
		this.hideFrame();
	}
}
