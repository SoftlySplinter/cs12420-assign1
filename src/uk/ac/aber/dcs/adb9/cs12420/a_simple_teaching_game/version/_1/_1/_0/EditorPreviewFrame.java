package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditorPreviewFrame
extends GameFrame
{
	private JButton close = new JButton("Close");
	
	String targetWord;
	
	/**
	 * Constructor taken from the superclass
	 * @param g
	 * @param target
	 * @param words
	 */
	public EditorPreviewFrame(GameDriver g, String target, Word[] words)
	{
		super(g, target, words);
		
		targetWord = target;
		
		s.add(close);
		close.addActionListener(new EditorPreviewListener());
	}
	
	@Override
	public void endGame()
	{
		//Do nothing.
	}
	
	@Override
	public void errorPopUp(String message)
	{
		message = "Incorrect, you clicked on: "+message+". The target word is: "+ targetWord;
		ErrorFrame errorFrame = new ErrorFrame(message);
		errorFrame.showFrame();
	}
	
	public void close()
	{
		this.hideFrame();
	}
	
	private class EditorPreviewListener
	implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			hideFrame();			
		}
		
	}
}
