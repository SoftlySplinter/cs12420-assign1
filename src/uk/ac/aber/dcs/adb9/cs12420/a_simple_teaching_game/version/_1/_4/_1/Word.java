package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * Stores information about a Word.
 * 
 * @author  Alexander Brown
 * @version  0.1.1
 * 
 */
public class Word
{
	//General Variables
	/**
	 * The value of the Word ("Cat" for example).
	 */
	private String value;
	
	/**
	 * The position of the word as a Dimension.
	 */
	private Dimension position;
	
	/**
	 * True if the Word is the target.
	 */
	private boolean isTarget;
	
	private String imageFile;
	
	private Image image;

	private boolean usesImage = false;
	
	public int imageHeight = 0;
	
	public int imageWidth = 0;
	
	/**
	 * Constructor.
	 * 
	 * <br /><br />
	 * 
	 * Defines all the attributes of a Word.
	 * 
	 * @param v The value of the Word.
	 * @param x The X coordinate of the Word.
	 * @param y The Y coordinate of the Word.
	 * @param target True if the word is the target.
	 */
	public Word(String v, int x, int y, boolean target, String i)
	{
		value = v;
		position = new Dimension(x,y);
		isTarget = target;
		imageFile = i;
		if(imageFile.equals("")||imageFile.equals(null))
		{
			//Do nothing
		}
		else
		{
			try
			{
				image = Toolkit.getDefaultToolkit().getImage(imageFile);
			}
			catch(Exception e)
			{
				new ErrorFrame("Error loading Image").showFrame();
			}
		}
	}
	
	/**
	 * Simple to String.
	 * 
	 * @return Basic information on a Word.
	 */
	@Override
	public String toString()
	{
		String s = value+"\n"+position.getWidth()+"\n"+position.getHeight()+"\n"+isTarget;
		return s;
	}
	
	/**
	 * Gets the value of the Word.
	 * @return  The value of the Word.
	 */
	public String getValue()
	{
		return value;
	}
	
	/**
	 * Gets the X coordinate.
	 * 
	 * @return The X coordinate.
	 */
	public int getX()
	{
		return (int) position.getWidth();
	}
	
	/**
	 * Gets the Y coordinate.
	 * 
	 * @return The Y coordinate.
	 */
	public int getY()
	{
		return (int) position.getHeight();
	}
	
	public int getImageHeight()
	{
		return imageHeight;
	}
	
	public void setImageHeight(int i)
	{
		imageHeight = i;
	}
	
	public int getImageWidth()
	{
		return imageWidth;
	}
	
	public void setImageWidth(int i)
	{
		imageWidth = i;
	}
	
	/**
	 * Gets whether or not the Word is the target Word.
	 * @return  True if the Word is the target Word, else returns false.
	 */
	public boolean isTarget()
	{
		return isTarget;
	}

	public void setX(int x)
	{
		int y = getY();
		position = new Dimension(x,y);
	}
	
	public void setY(int y)
	{
		int x = getX();
		position = new Dimension(x,y);
	}
	
	public String getImageFile()
	{
		return imageFile;
	}
	
	public Image getImage()
	{
		return image;
	}

	public boolean usesImage()
	{
		if(imageFile.equals(""))
		{
			return false;
		}
		else
		{
			return usesImage;
		}
	}

	public void doesUseImage()
	{
		usesImage = true;
	}
}
