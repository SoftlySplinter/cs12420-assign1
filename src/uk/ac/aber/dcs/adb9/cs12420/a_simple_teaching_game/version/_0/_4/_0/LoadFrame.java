package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class LoadFrame
extends SimpleFrame
{

	/**
	 * @uml.property  name="loadPanel"
	 * @uml.associationEnd  
	 */
	private LoadPanel loadPanel = new LoadPanel(this);
	/**
	 * @uml.property  name="loadDriver"
	 * @uml.associationEnd  
	 */
	private LoadDriver loadDriver;
	
	public LoadFrame(LoadDriver l)
	{
		loadDriver = l;
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.add(loadPanel,BorderLayout.CENTER);
		
		this.formatLayout();
		
		this.showFrame();
		
		this.pack();
	}
	
	public void loadRoutine(String file)
	{
		loadDriver.loadRoutine(file);
	}
	
	public void close()
	{
		loadDriver.close();
	}
}
