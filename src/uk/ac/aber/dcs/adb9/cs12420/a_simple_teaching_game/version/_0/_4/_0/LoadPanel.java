package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoadPanel
extends JPanel
{

	/**
	 * @uml.property  name="loadFrame"
	 * @uml.associationEnd  
	 */
	private LoadFrame loadFrame;
	
	/**
	 * @uml.property  name="loadListener"
	 * @uml.associationEnd  
	 */
	private LoadListener loadListener = new LoadListener(this);
	
	
	private JTextField filenameField = new JTextField(15);
	private JButton browseButton = new JButton("...");
	
	private JButton loadButton = new JButton("Load");
	private JButton cancelButton = new JButton("Cancel");

	public LoadPanel(LoadFrame l)
	{
		loadFrame = l;
		
		this.setLayout(new GridLayout(2,1,5,5));
		JPanel panel1 = new JPanel();
		panel1.add(filenameField);
		panel1.add(browseButton);
		browseButton.addActionListener(loadListener);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2,0,5));
		JPanel panel3 = new JPanel();
		panel3.add(loadButton);
		loadButton.addActionListener(loadListener);
		panel2.add(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.add(cancelButton);
		cancelButton.addActionListener(loadListener);
		panel2.add(panel4);
		this.add(panel2);
	}
	
	public void loadRoutine()
	{
		loadFrame.loadRoutine(filenameField.getText());
	}
	
	public void close()
	{
		loadFrame.close();
	}
}
