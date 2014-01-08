package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The contents of the Win Frame.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 * 
 * @see WinFrame
 * @see WinListener
 */
@SuppressWarnings("serial")
public class WinPanel
extends JPanel
{
	
	/**
	 * Link back to the Win Frame.
	 * @see WinFrame
	 * @see   <!--
	 * @uml.property   name="winFrame"
	 * @uml.associationEnd   inverse="winPanel1:aSimpleGamev1p0p0.WinFrame"
	 */
	private WinFrame winFrame;

	/**
	 * Link to the Win Listener.
	 * @see WinListener
	 * @see   <!--
	 * @uml.property   name="winListener"
	 * @uml.associationEnd   inverse="winPanel:aSimpleGamev1p0p0.WinListener"
	 */
	private WinListener winListener = new WinListener(this);
	
	/**
	 * The Win message Label.
	 */
	private JLabel winLabel = new JLabel("You won");
	
	/**
	 * The continue Button.
	 */
	private JButton winContinue = new JButton("Continue");
	
	private JButton quit = new JButton("Stop Playing");

	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Adds a link back to the Win Frame, adds all the components to the frame and adds Action Listeners to those which need it.
	 * 
	 * @param w The Win Frame to link back to.
	 * 
	 * @see WinFrame
	 * @see WinListener
	 */
	public WinPanel(WinFrame w)
	{
		winFrame = w;
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1,5,5));
		
		
		
		JPanel panel2 = new JPanel();
		panel2.add(winLabel);
		
		JPanel panel3 = new JPanel();
		panel3.add(winContinue);
		winContinue.addActionListener(winListener);
		panel3.add(quit);
		quit.addActionListener(winListener);
		panel1.add(panel2);
		panel1.add(panel3);
		
		this.add(panel1);
	}
	
	/**
	 * Passes the continue Game method upward
	 * 
	 * @see WinFrame#close()
	 */
	public void continueGame()
	{
		winFrame.continueGame();
	}
}
