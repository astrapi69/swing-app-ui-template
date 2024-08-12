package io.github.astrapi69;

import lombok.extern.java.Log;

import javax.swing.JFrame;
import java.util.logging.Level;

@Log
public class ApplicationFrameTemplate {

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
