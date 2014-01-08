package uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._0._0;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Handels sound in the game.
 * 
 * @author Alexander Brown
 * @version 0.1.0
 *
 */
public class GameSound
{
	//Initialise the Clip
	private Clip audioClip = null;

	/**
	 * Loads a sound.
	 * 
	 * <br /><br />
	 * 
	 * Influenced, but not copied from, <a href="http://privatepaste.com/d543d03d8d">this</a>.
	 * 
	 * @param the filename of the Audio File.
	 */
	public GameSound(String filename)
	{
		//Set up an Error Frame
		ErrorFrame errorFrame;
		
		//Get the File
		File file = new File(filename);
		
		//Try to get the Clip
		try
		{
			audioClip = AudioSystem.getClip();
		}
		//Show an error if something goes wrong
		catch (LineUnavailableException e)
		{
			errorFrame = new ErrorFrame("Error 13 - Could not load Sound.");
			errorFrame.showFrame();
		}
		
		//Initialise the AudioInputStream
		AudioInputStream a = null;
		
		//Try to load the file into this
		try
		{
			a = AudioSystem.getAudioInputStream(file);
		}
		//Show an error message if it's unsupported
		catch (UnsupportedAudioFileException e)
		{
			errorFrame = new ErrorFrame("Error 14 - Unsupported File Type.");
			errorFrame.showFrame();
		}
		//Show an error message if there's a more general error
		catch (IOException e)
		{
			errorFrame = new ErrorFrame("Error 15 - Error whilst loading Input Stream");
			errorFrame.showFrame();
		}
		
		//Try to open the Clip
		try
		{
			audioClip.open(a);
		}
		//Show an error message if it fails
		catch (LineUnavailableException e)
		{
			errorFrame = new ErrorFrame("Error 13 - Could not load Sound");
			errorFrame.showFrame();
		}
		//Show an error message if a more general error occurs
		catch (IOException e)
		{
			errorFrame = new ErrorFrame("Error 13 - Could not load Sound");
			errorFrame.showFrame();
		}
	}
	
	/**
	 * Play the sound.
	 */
	public void playSound()
	{
		audioClip.start();
	}
}

