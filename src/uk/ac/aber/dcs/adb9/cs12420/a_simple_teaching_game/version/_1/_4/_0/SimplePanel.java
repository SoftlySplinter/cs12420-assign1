package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._0;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A Simple Panel for accessing useful methods.
 * @author Alexander Brown
 * @version 1.1.0
 */
@SuppressWarnings("serial")
public abstract class SimplePanel
extends JPanel
{
	
	/**
	 * For a nice formatting of components when using GridLayout.
	 */
	JPanel panel;
	
	/**
	 * Basic formatting of an item so it appears centrally, not the size of the Grid.
	 * @param c The Component to add.
	 * @return A JPanel with the Component centrally in it.
	 */
	JPanel formatLayout(Component c)
	{
		panel = new JPanel();
		panel.add(c,BorderLayout.CENTER);	
		
		return panel;
	}
	
	/**
	 * Makes the text of the Component BIG then runs the normal format layout method.
	 * @param c The Component to add.
	 * @return A JPanel with the Component centrally in it.
	 * @see #formatLayout(Component)
	 * @see SimpleFrame#BIG
	 */
	JPanel formatLayoutBig(Component c)
	{
		c.setFont(SimpleFrame.BIG);
		return formatLayout(c);
	}
	
	/**
	 * Makes the text of the Component NORMAL then runs the normal format layout method.
	 * @param c The Component to add.
	 * @return A JPanel with the Component centrally in it.
	 * @see #formatLayout(Component)
	 * @see SimpleFrame#NORMAL
	 */
	JPanel formatLayoutNormal(Component c)
	{
		c.setFont(SimpleFrame.NORMAL);
		return formatLayout(c);
	}
	
	/**
	 * Makes the text of the Component NORMAL and X align Left then runs the normal format layout method.
	 * @param l The JLabel to format
	 * @return A JPanel with the Component centrally in it.
	 * @see #formatLayout(Component)
	 * @see SimpleFrame#NORMAL
	 */
	JPanel formatLayoutNormalLeft(JLabel l)
	{
		l.setAlignmentX(LEFT_ALIGNMENT);
		l.setFont(SimpleFrame.NORMAL);
		return formatLayout(l);
	}
	
	/**
	 * Makes the text of the Component SMALL then runs the normal format layout method.
	 * @param c The Component to add.
	 * @return A JPanel with the Component centrally in it.
	 * @see #formatLayout(Component)
	 * @see SimpleFrame#SMALL
	 */
	JPanel formatLayoutSmall(Component c)
	{
		c.setFont(SimpleFrame.SMALL);
		return formatLayout(c);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
