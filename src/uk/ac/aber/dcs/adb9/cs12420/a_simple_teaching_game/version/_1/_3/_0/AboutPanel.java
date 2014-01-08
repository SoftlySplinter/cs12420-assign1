package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._3._0;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contents of the About Frame.
 * @author Alexander Brown
 * @version 1.1.0
 * @see AboutFrame
 * @see AboutListener
 */
@SuppressWarnings("serial")
public class AboutPanel
extends SimplePanel
{
	/**
	 * The About Frame to link back to.
	 * @see AboutFrame
	 */
	private AboutFrame aboutFrame;
	
	/**
	 * Panel for formatting.
	 */
	JPanel panel;
	
	/**
	 * The Name of the application.
	 */
	private JLabel nameLabel = new JLabel("A Simple Teaching Game");
	
	/**
	 * URL of the Author's Website.
	 */
	//TODO Look into the URL stuff
	String url = "http://users.aber.ac.uk/adb9";
	
	/**
	 * The Main contents of the about page.
	 */
	private JLabel mainLabel = new JLabel("<html><center>Created by Alexander Brown (adb9).<p>Copyright © 2010 Alexander Brown. All rights reserved.</p><p>Vist: <a href='"+url+"'>"+url+"</a> for more information.</p></center></html>");
	
	/**
	 * Button to close the window.
	 */
	private JButton close = new JButton("Close");
	
	/**
	 * Action Listener for the button.
	 * @see AboutListener
	 */
	private AboutListener aboutListener = new AboutListener(this);

	/**
	 * Constructor.
	 * <br /><br />
	 * Sets up the contents of the Frame.
	 * @param a The About Frame to link back to.
	 * @see AboutFrame
	 * @see AboutListener
	 */
	public AboutPanel(AboutFrame a)
	{
		aboutFrame = a;
		
		this.setLayout(new GridLayout(2,1,0,0));
		
		this.add(formatLayoutBig(nameLabel));
		
		this.add(formatLayoutNormal(mainLabel));
		
		panel = formatLayout(close);
		close.addActionListener(aboutListener);
		aboutFrame.s.add(panel);
	}
	
	
	
	/**
	 * Passes the close method upward
	 * @see AboutFrame#close()
	 */
	public void close()
	{
		aboutFrame.close();
	}
}
