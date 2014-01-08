package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._6._0;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A Panel which holds a single word.
 * @author Alexander Brown
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class WordPanel extends JPanel
{
	/**
	 * True if the word is the target word
	 */
	private boolean isTargetWord;
	
	/**
	 * Label for the type of value the word has (can either be "Target Word:" or "Word:").
	 */
	private JLabel valueLabel;
	
	/**
	 * The value of the word in a Text Field.
	 */
	private JTextField valueField;
	
	
	/**
	 * Label for the X position (will be merged with the Y).
	 */
	private JLabel xLabel = new JLabel("X Position:");
	/**
	 * The X position of the word in a Text Field.
	 */
	private JTextField xField;
	
	/**
	 * Label for the Y position (will be merged with the X).
	 */
	private JLabel yLabel = new JLabel("Y Position:");
	/**
	 * The Y position of the word in a Text Field
	 */
	private JTextField yField;

	/**
	 * The Editor Frame this is linked to.
	 * @see EditorFrame
	 * @see       <!--
	 * @uml.property  name="editorFrame"
	 * @uml.associationEnd  
	 */
	@SuppressWarnings("unused")
	private EditorFrame editorFrame;

	/**
	 * Constructor for the Word Frame.
	 * 
	 * <br /><br />
	 * 
	 * Takes the data from the Word <b>w</b> and inputs it into the relevant fields.
	 * 
	 * @param e The Editor Frame this is linked to
	 * @param w The Word from which is to be displayed.
	 * @see EditorFrame
	 * @see Word
	 */
	public WordPanel(EditorFrame e, Word w)
	{
		//Link back to the editor frame
		editorFrame = e;
		
		//Set to Grid Layout
		this.setLayout(new GridLayout(3,2,5,5));

		//If w is the target word, make the Value Label "Target Word:"
		if(w.isTarget())
		{
			valueLabel = new JLabel("Target Word:");
			this.add(valueLabel);
			isTargetWord = true;
		}
		//Else just set the Value Label to be "Word:"
		else
		{
			valueLabel = new JLabel("Word:");
			this.add(valueLabel);
			isTargetWord = false;
		}
		
		//Inputs the value from w into the Text Field
		valueField = new JTextField(w.getValue(), 10);
		this.add(valueField);
		
		//Adds the X Position Label
		this.add(xLabel);
		
		//Inputs the X position from w into the Text Field
		xField = new JTextField(w.getX()+"",5);
		this.add(xField);
		
		//Adds the Y Position Label
		this.add(yLabel);
		
		//Inputs the Y position from w into the Text Field
		yField = new JTextField(w.getY()+"",5);
		this.add(yField);
		
		//Debugging command - Prints out w in the console.
		System.out.println(w.toString());
	}
	
	public String getValue()
	{
		return valueField.getText();
	}
	
	public Word getWord()
	{
		int x = (int)(Double.valueOf(xField.getText())).doubleValue();
		int y = (int)(Double.valueOf(yField.getText())).doubleValue();
		Word w = new Word(valueField.getText(),x,y,isTargetWord);
		return w;
	}
}
