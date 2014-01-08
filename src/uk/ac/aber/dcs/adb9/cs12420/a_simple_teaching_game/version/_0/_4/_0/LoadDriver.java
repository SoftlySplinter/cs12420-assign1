package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;


public class LoadDriver {

	/**
	 * @uml.property  name="applicationDriver"
	 * @uml.associationEnd  
	 */
	private ApplicationDriver applicationDriver;
	
	/**
	 * @uml.property  name="loadFrame"
	 * @uml.associationEnd  
	 */
	private LoadFrame loadFrame;
	
	public LoadDriver(ApplicationDriver a)
	{
		applicationDriver = a;
		loadFrame = new LoadFrame(this);
	}
	
	public void loadRoutine(String file)
	{
		applicationDriver.runGame(file);
		loadFrame.dispose();
	}
	
	public void close()
	{
		loadFrame.dispose();
		applicationDriver.showMenu();
	}
}
