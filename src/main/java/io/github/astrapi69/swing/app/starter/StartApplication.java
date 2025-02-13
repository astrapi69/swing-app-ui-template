/**
 * The MIT License
 *
 * Copyright (C) 2024 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.app.starter;

import io.github.astrapi69.awt.screen.ScreenSizeExtensions;
import io.github.astrapi69.swing.app.configuration.ApplicationLoggingConfiguration;
import io.github.astrapi69.swing.app.frame.TemplateApplicationFrame;
import io.github.astrapisixtynine.easy.logger.LoggingConfiguration;
import lombok.extern.java.Log;

/**
 * The class {@link StartApplication} starts the application
 */
@Log
public class StartApplication
{

	/**
	 * The main method that starts the application
	 *
	 * @param args
	 *            the arguments passed to the application
	 */
	public static void main(final String[] args)
	{
		ApplicationLoggingConfiguration.setDefaultSystemProperties();
		LoggingConfiguration.setup();
		log.info("JUL logs are now routed to SLF4J.");
		TemplateApplicationFrame frame = new TemplateApplicationFrame();
		while (!frame.isVisible())
		{
			ScreenSizeExtensions.showFrame(frame);
		}
	}

}
