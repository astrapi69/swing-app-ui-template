package io.github.astrapi69;

import java.util.logging.Level;

import javax.swing.JFrame;

import lombok.extern.java.Log;

@Log
public class ApplicationFrameTemplate
{

	public static void main(final String[] args)
	{
		log.setLevel(Level.FINE);
		final JFrame frame = new JFrame("ApplicationFrameTemplate");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(500, 400);

		frame.setLayout(null);

		frame.setVisible(true);
	}
}
