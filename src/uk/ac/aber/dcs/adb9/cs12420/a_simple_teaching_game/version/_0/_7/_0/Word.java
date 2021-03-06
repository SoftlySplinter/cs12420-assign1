package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._0._7._0;

import java.awt.Dimension;

/**
 * Stores information about a Word
 * @author  Alexander Brown
 * @version  0.1.1
 */
public class Word
{
	//General Variables
	/**
	 * The value of the Word ("Cat" for example)
	 * @uml.property  name="value"
	 */
	private String value;
	
	/**
	 * The position of the word as a Dimension
	 */
	private Dimension position;
	
	/**
	 * True if the Word is the target
	 * @uml.property  name="isTarget"
	 */
	private boolean isTarget;
	
	/**
	 * Constructor for a Word
	 * @param v The value of the Word
	 * @param x The X coordinate of the Word
	 * @param y The Y coordinate of the Word
	 * @param target True if the word is the target
	 */
	public Word(String v, int x, int y, boolean target)
	{
		value = v;
		position = new Dimension(x,y);
		isTarget = target;
	}
	
	/**
	 * Simple to String
	 * @return Basic information on a Word
	 */
	@Override
	public String toString()
	{
		String s = value+"\n"+position.getWidth()+"\n"+position.getHeight()+"\n"+isTarget;
		return s;
	}
	
	/**
	 * Gets the value of the Word
	 * @return  The value of the Word
	 * @uml.property  name="value"
	 */
	public String getValue()
	{
		return value;
	}
	
	/**
	 * Gets the X coordinate
	 * @see getPosition
	 * @return The X coordinate
	 */
	public int getX()
	{
		return (int) position.getWidth();
	}
	
	/**
	 * Gets the Y coordinate
	 * @see getPosition
	 * @return The Y coordinate
	 */
	public int getY()
	{
		return (int) position.getHeight();
	}
	
	/**
	 * Gets whether or not the Word is the target Word
	 * @return  True if the Word is the target Word, else returns false
	 * @uml.property  name="isTarget"
	 */
	public boolean isTarget()
	{
		return isTarget;
	}
}
