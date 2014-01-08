package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Contents of the Help Frame for the Editor
 * @author Alexander Brown
 * @version 1.1.0
 * 
 * @see EditorHelpFrame
 * @see EditorHelpListener
 */
@SuppressWarnings("serial")
public class EditorHelpPanel extends SimplePanel
{
	
	private final String MAIN = new String("<html>			<p>&nbsp;</p>	<p>Welcome to the A Simple Game Help.</p>	<p>&nbsp;</p>	<p>Please select an option from the list to the left to view more detailed help</p>		</html>");

	private final String TARGET_WORD = new String("<html>	<p>&nbsp;</p>	<p>This is the Word the player has to click on to win the game.</p>	<p>&nbsp;</p>	<p><b>Value:</b> The Text of the Word</p>	<p><b>X Position:</b> Ho far in the X (horizontal) axis the target word will appear.</p>	<p><b>Y Position:</b> Ho far in the Y (vertical) axis the target word will appear.</p>	<p><b>Image:</b> The Image file to be displayed. See Image.</p>	</html>");
	
	private final String OTHER_WORD = new String("<html>	<p>&nbsp;</p>	<p>These are the other Words the player must avoid. Will show a bad message when clicked on.</p>	<p>&nbsp;</p>	<p><b>Value:</b> The Text of the Word</p>	<p><b>X Position:</b> Ho far in the X (horizontal) axis the target word will appear.</p>	<p><b>Y Position:</b> Ho far in the Y (vertical) axis the target word will appear.</p>	<p><b>Image:</b> The Image file to be displayed. See Image.</p></html>");
	
	private final String IMAGES = new String("<html>		<p>&nbsp;</p>	<p>To use an image you must first copy it into the 'src' folder.</p>	<p>Once it is in this folder you may then use the <u>exact</u> filename (including extension; '.jpg', '.png', etc.) to show it. Refresh to see how it will appear in-game.</p></html>");
	
	/**
	 * Link back to the Help Frame.
	 * @see EditorHelpFrame
	 */
	private EditorHelpFrame editorHelpFrame;
	
	/**
	 * Link to the ACtion Listener
	 */
	private EditorHelpListener editorHelpListener = new EditorHelpListener(this);
	
	/**
	 * Link to the Mouse Listener
	 */
	private EdtiorHelpMouseListener editorHelpMouseListener = new EdtiorHelpMouseListener(this);
	
	private JLabel contents = new JLabel(MAIN);
	
	private String[] helpItems = {"Main","Target Word","Other Words","Images"};
	
	private JList helpList = new JList(helpItems);
	
	private JButton close = new JButton("Close");

	/**
	 * Constructor.
	 * <br /><br />
	 * Sets up the contents of the Frame.
	 * @param e The Help Frame to link back to.
	 * @see EditorHelpFrame
	 * @see EditorHelpListener
	 */
	public EditorHelpPanel(EditorHelpFrame e)
	{
		editorHelpFrame = e;
		
		this.setLayout(new BorderLayout());
		
		helpList.setSelectedValue("Main", true);
		
		

		this.add(helpList,BorderLayout.WEST);
		helpList.addMouseListener(editorHelpMouseListener);
		
		JPanel panelG = new JPanel();
		panelG.setLayout(new GridLayout(1,1,0,0));
		panelG.add(contents);
		this.add(panelG,BorderLayout.CENTER);
		contents.setFont(SimpleFrame.NORMAL);
		contents.setAlignmentX(LEFT_ALIGNMENT);
		contents.setAlignmentY(TOP_ALIGNMENT);
		panelG.setAlignmentY(TOP_ALIGNMENT);
		
		
		//TODO put in SimplePanel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		panel.add(p,BorderLayout.CENTER);
		panel.add(formatLayout(close),BorderLayout.SOUTH);
		this.add(panel,BorderLayout.EAST);
	
		close.addActionListener(editorHelpListener);
		
		repaint();
	}
	
	/**
	 * paint Component method
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	

	public void checkList()
	{
		String s = (String) helpList.getSelectedValue();
		if(s.equals(helpItems[0]))
		{
			//contents.setName(MAIN);
			contents.setText(MAIN);
		}
		else if(s.equals(helpItems[1]))
		{
			contents.setText(TARGET_WORD);
		}
		else if(s.equals(helpItems[2]))
		{
			contents.setText(OTHER_WORD);
		}
		else if(s.equals(helpItems[3]))
		{
			contents.setText(IMAGES);
		}
		
		this.repaint();
	}
	
	/**
	 * Passes the close method upward
	 * @see EditorHelpFrame#close()
	 */
	public void close()
	{
		editorHelpFrame.close();
	}
}
