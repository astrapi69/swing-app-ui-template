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
package io.github.astrapi69.swing.app;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;

import org.slf4j.bridge.SLF4JBridgeHandler;

import io.github.astrapi69.file.system.SystemPropertiesExtensions;

/**
 * The class {@link LoggingConfiguration} setups the logging for the application
 */
public final class LoggingConfiguration
{

	/**
	 * Private constructor to prevent instantiation
	 */
	private LoggingConfiguration()
	{
	}

	/**
	 * Sets up all for logging
	 */
	public static void setup()
	{
		// Remove existing handlers attached to the root logger
		LogManager.getLogManager().reset();
		loadLoggingFile();
		setupJavaUtilLoggingToSlf4jBridge();
	}

	/**
	 * Sets default system properties for PF4J configuration, such as mode and plugin directory
	 * <p>
	 * The default settings include:
	 * <ul>
	 * <li>{@code pf4j.mode} - set to {@code development}</li>
	 * <li>{@code pf4j.pluginsDir} - specifies the plugins directory, set to {@code plugins}</li>
	 * <li>{@code pf4j.plugins.debug} - enables plugin debugging, set to {@code true}</li>
	 * </ul>
	 * The method calls {@link SystemPropertiesExtensions#setSystemProperties(Properties)} to apply
	 * these default settings
	 */
	public static void setDefaultSystemProperties()
	{
		Properties properties = new Properties();
		/* if the swing app is for deployment, here is the place to set */
		properties.setProperty("pf4j.mode", "development");
		// properties.setProperty("pf4j.mode", "deployment");
		properties.setProperty("pf4j.pluginsDir", "plugins");
		properties.setProperty("pf4j.plugins.debug", "true");
		properties.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
		SystemPropertiesExtensions.setSystemProperties(properties);
	}

	/**
	 * Sets up the SLF4J bridge handler to capture JUL logs. It removes the default JUL loggers and
	 * installs the SLF4J bridge handler to capture JUL logs
	 */
	public static void setupJavaUtilLoggingToSlf4jBridge()
	{
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
	}

	/**
	 * Load the logging properties file to the {@link LogManager}
	 */
	public static void loadLoggingFile()
	{
		try
		{
			LogManager.getLogManager().readConfiguration(LoggingConfiguration.class.getClassLoader()
				.getResourceAsStream("logging.properties"));
		}
		catch (IOException e)
		{
			System.err.println("Could not load logging properties file");
		}
	}

}
