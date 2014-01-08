package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._1._1;

/**
 * Panel containing an interactive editor.
 * @author Alexander Brown
 * @version 1.1.1
 * 
 * @see EditorFrame
 * @see GamePanel
 */
@SuppressWarnings("serial")
public class EditorInteractivePanel
extends GamePanel
{
	String targetWord;
	
	EditorFrame editorFrame;
	
	/**
	 * Constructor taken from the superclass
	 * @param g
	 * @param target
	 * @param words
	 */
	public EditorInteractivePanel(EditorFrame e, GameFrame g, String target, Word[] w)
	{
		super(g, target, w);
		
		editorFrame = e;
		
		targetWord = target;
	}
	
	/**
	 * Checks to see if the word is the word you're looking for.
	 * 
	 * <!--"These aren't the Words you're looking for"-->
	 * 
	 * <br />
	 * 
	 * Does nothing at all.
	 * 
	 * @param w The Word to check.
	 * 
	 * @see GameSound
	 * @see WinFrame
	 * @see <br />
	 * @see #endGame()
	 * @see #errorPopUp(String)
	 * @see <br />
	 * @see GameSound#playSound()
	 * @see SimpleFrame#showFrame()
	 */
	public void checkWord(Word w)
	{
		//if the value equals that of the target Word
		if(w.getValue().equals(targetWord))
		{
			//Do nothing
		}
		//otherwise
		else
		{
			//Do Nothing
		}
	}
	
	/**
	 * Stops the game from ending
	 * 
	 */
	@Override
	public void endGame()
	{
		//Do nothing.
	}
	
	/**
	 * Stops an error pop-up.
	 * @param message The message that would be displayed.
	 */
	@Override
	public void errorPopUp(String message)
	{
		//Do nothing.
	}
	
	/**
	 * Stops closing.
	 */
	@Override
	public void hideMainManu()
	{
		//Do Nothing
	}
	
	@Override
	public void drop(int blank)
	{
		super.drop(blank);
		
		editorFrame.refresh(this);
	}
}
