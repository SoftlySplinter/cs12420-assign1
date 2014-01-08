package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._4._0;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JLabel;

/**
 * 
 * @author Alexander Brown
 * @version 0.1.1
 */
@SuppressWarnings("serial")
public class MainFrame
extends SimpleFrame
{

	/**
	 * @uml.property  name="application"
	 * @uml.associationEnd  
	 */
	private ApplicationDriver application;
	


	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  
	 */
	private MainPanel mainPanel = new MainPanel(this);
	
	
	public MainFrame(ApplicationDriver a)
	{
		application = a;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("A Simple Teaching Game");
		
		this.formatLayout();
		this.setSize(400,200);
		
		//Personal Pride
		JLabel sLabel = new JLabel("Created by Alexander Brown, 2010");
		sLabel.setFont(small);
		s.add(sLabel);
		
		//Add the main panel.
		this.add(mainPanel,BorderLayout.CENTER);
	}
	
	public void runGame()
	{
		application.runLoader();
	}
	
	public void runEditor()
	{
		application.runEditor();
	}
	
	public void exit()
	{
		application.exit();
	}
}
