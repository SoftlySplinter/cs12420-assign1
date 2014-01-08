package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._3._0;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A Panel which holds a single word.
 * 
 * @author Alexander Brown
 * @version 1.1.1
 * 
 * @see EditorFrame
 */
@SuppressWarnings("serial")
public class WordPanel
extends JPanel
{
	/**
	 * True if the word is the target word.
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
	
	private JLabel imageLabel = new JLabel("Image file to be displayed");
	
	private JTextField imageField;

	/**
	 * The Editor Frame this is linked to.
	 * @see EditorFrame
	 */
	@SuppressWarnings("unused")
	private EditorFrame editorFrame;

	/**
	 * Constructor.
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
		this.setLayout(new GridLayout(4,2,5,5));

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
		
		this.add(imageLabel);
		
		imageField = new JTextField(w.getImageFile());
		this.add(imageField);
	}
	
	/**
	 * Returns the Text in the Value Field.
	 * @return The String in the Value Field.
	 */
	public String getValue()
	{
		return valueField.getText();
	}
	
	/**
	 * Gets all the information from the Text Fields, puts it into a simple Word and returns it. Deals with Number Error Messages.
	 * @return The Word with information from the Text Fields.
	 * 
	 * @see Word
	 * @see ErrorFrame
	 */
	public Word getWord()
	{
		ErrorFrame errorFrame;
		
		int x;
		int y;
		
		try
		{
			x = (int)(Double.valueOf(xField.getText())).doubleValue();
			y = (int)(Double.valueOf(yField.getText())).doubleValue();
		}
		catch (NumberFormatException e)
		{
			errorFrame = new ErrorFrame("Error 11 - Position must be a number.");
			errorFrame.showFrame();
			return null;
		}
		catch (NullPointerException e)
		{
			errorFrame = new ErrorFrame("Error 12 - Position cannot be null.");
			errorFrame.showFrame();
			return null;
		}
		catch (Exception e)
		{
			errorFrame = new ErrorFrame("Error 05 - Unknown Error");
			errorFrame.showFrame();
			return null;
		}
		
		Word w = new Word(valueField.getText(),x,y,isTargetWord, imageField.getText());
		return w;
	}

	public void setX(int x)
	{
		xField.setText(x+"");
	}
	
	public void setY(int y)
	{
		yField.setText(y+"");
	}

	public void refresh(Word word)
	{
		this.setX(word.getX());
		this.setY(word.getY());
	}
}
