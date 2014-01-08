package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	
	private JLabel imageLabel = new JLabel("");
	
	private JButton imageButton = new JButton("");
	
	private JButton removeImageButton = new JButton("Remove Image");
	
	private String imageField;

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
		
		if(w.isTarget())
		{
			this.setBorder(new TitledBorder("Target Word"));
			isTargetWord = true;
		}
		else
		{
			this.setBorder(new TitledBorder("Word"));
			isTargetWord = false;
		}

		
			valueLabel = new JLabel("Value:");
			this.add(valueLabel);
		
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
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,0,0));
		
		panel.add(imageButton);
		imageButton.addActionListener(new WordPanelListener());
		
		
		
		panel.add(removeImageButton);
		removeImageButton.addActionListener(new WordPanelListener());
		
		this.add(panel);
		
		imageField = w.getImageFile();
		
		setImageText();
	}
	
	public void setImageText()
	{
		if(imageField==null || imageField.equals(""))
		{
			imageLabel.setText("No Image");
			imageButton.setText("Add an Image");
			
		}
		else
		{
			imageLabel.setText("Current Image: "+imageField);
			imageButton.setText("Change Image");
		}
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
		
		Word w = new Word(valueField.getText(),x,y,isTargetWord, imageField);
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
	
	public void getImageFile()
	{
		new LoadDriver(this,"image");
	}

	public void setImageFile(String file)
	{
		imageField = file;
		setImageText();
	}
	
	private class WordPanelListener
	implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String a = e.getActionCommand();
			if(a.equals(imageButton.getText()))
			{
				getImageFile();
			}
			else if(a.equals("Remove Image"))
			{
				setImageFile("");
			}
		}
	}
}
