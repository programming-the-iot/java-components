/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * A simple utility wrapper around the Apache Commons
 * configuration infrastructure.
 * 
 */
public class ConfigUtil
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(ConfigUtil.class.getName());
	
	private static final ConfigUtil _Instance = new ConfigUtil();

	/**
	 * Returns the Singleton instance of this class.
	 * 
	 * @return ConfigUtil
	 */
	public static final ConfigUtil getInstance()
	{
		return _Instance;
	}
	
	
	// private var's
	
	private INIConfiguration sectionProperties = null;
	
	private boolean isLoaded = false;
	private String  configFileName = ConfigConst.DEFAULT_CONFIG_FILE_NAME;
	
	
	// constructors
	
	/**
	 * Default (private).
	 * 
	 * Creates a new instance of {@link HierarchichalINIConfiguration}.
	 */
	private ConfigUtil()
	{
		super();
		
		try {
			String cfgFileName = System.getProperty(ConfigConst.CONFIG_FILE_KEY);
			
			if (cfgFileName != null) {
				this.configFileName = cfgFileName;
			}
		} catch (SecurityException e) {
			_Logger.warning("Security exception reading system property to retrieve config file name. Using default.");
		}
		
		initBackingProperties();
		loadConfig();
	}
	
	
	// public methods
	
	/**
	 * Creates the cloud service configuration section name from
	 * the given parameters.
	 * 
	 * The result will be 'Cloud.GatewayService.{name}',
	 * or simply 'Cloud.GatewayService' is cloudSvcName is invalid.
	 * 
	 * @param cloudSvcName The name to append to the section name.
	 * @return String the cloud service configuration section name.
	 */
	public String getCloudSectionName(String cloudSvcName)
	{
		if (cloudSvcName != null && cloudSvcName.trim().length() > 0) {
			return ConfigConst.CLOUD_GATEWAY_SERVICE + "." + cloudSvcName;
		} else {
			return ConfigConst.CLOUD_GATEWAY_SERVICE;
		}
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @return String The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a String.
	 */
	public synchronized String getProperty(String section, String propName)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getString(propName);
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @param defaultVal The default value if the property doesn't exist.
	 * @return String The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a String.
	 */
	public synchronized String getProperty(String section, String propName, String defaultVal)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getString(propName, defaultVal);
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve the value for 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @return boolean The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a boolean.
	 */
	public synchronized boolean getBoolean(String section, String propName)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getBoolean(propName, false);
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @return int The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a int.
	 */
	public synchronized int getInteger(String section, String propName)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getInt(propName);
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @param defaultVal The default value if the property doesn't exist.
	 * @return int The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a int.
	 */
	public synchronized int getInteger(String section, String propName, int defaultVal)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getInt(propName, defaultVal);
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @return float The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a float.
	 */
	public synchronized float getFloat(String section, String propName)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getFloat(propName);
	}
	
	/**
	 * Returns the requested property from the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @param defaultVal The default value if the property doesn't exist.
	 * @return float The value for 'propName'. If no mapping exists,
	 * a {@link ConversionException will be thrown}.
	 * @Exception ConversionException Thrown if 'propName' does not map to a float.
	 */
	public synchronized float getFloat(String section, String propName, float defaultVal)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return subNodeConfig.getFloat(propName, defaultVal);
	}
	
	/**
	 * Returns true if the requested property exists in the given section.
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created.
	 * @param propName The name of the property to retrieve.
	 * @return boolean True if the property exists; false otherwise.
	 * @Exception ConversionException Thrown if 'propName' does not map to a String.
	 */
	public synchronized boolean hasProperty(String section, String propName)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return (subNodeConfig.getProperty(propName) != null);
	}
	
	/**
	 * Returns true if the requested section exists and / or contains
	 * any properties within the loaded configuration.
	 * <p>
	 * NOTE: The underlying configuration handler will create 'section' if
	 * it doesn't already exist; hence, it can make for large configurations
	 * if this method is called with a different non-existent section name
	 * often, even if they remain empty (which is the default case).
	 * 
	 * @param section The section from which to retrieve 'propName'. If it
	 * doesn't exist, it will be created as an empty section.
	 * @return boolean True on success; false otherwise.
	 * @Exception ConversionException Thrown if 'section' does not map to a String.
	 */
	public synchronized boolean hasSection(String section)
	{
		SubnodeConfiguration subNodeConfig = sectionProperties.getSection(section);
		
		return (subNodeConfig != null);// && subNodeConfig.isEmpty());
	}
	
	/**
	 * Returns the flag indicating if either of the most recently called
	 * {@link #loadConfig()} or {@link #loadConfig(String)} methods was
	 * successful or failed.
	 * 
	 * @return true True if the most recent load invocation was successful;
	 * false otherwise.
	 */
	public boolean isConfigDataLoaded()
	{
		return isLoaded;
	}
	
	/**
	 * Attempts to load a separate configuration 'credential' file comprised
	 * of simple key = value pairs. The assumption with this call is that
	 * the credential file key is the same across all sections, so the
	 * only parameter requires is the section.
	 * 
	 * If the credential file key has an entry (e.g. the file where the
	 * credentials are stored in key = value form), the file will be
	 * loaded if possible, and a Properties object will be returned
	 * to the caller. No internal caching of the data is made, except
	 * within the returned Properties object.
	 * 
	 * NOTE: Be aware that the Properties reference will contain the key / value
	 * pair data referenced by the file name referenced by the configuration
	 * property key named {@see ConfigConst.CRED_FILE_KEY}. It's usually not
	 * a good idea to cache sensitive information (keys, credentials, etc.)
	 * 
	 * @param section
	 * @return Properties The map of properties, or null if non-existent.
	 */
	public Properties getCredentials(String section)
	{
		Properties props = null;
		
		if (hasSection(section)) {
			String credFileName = getProperty(section, ConfigConst.CRED_FILE_KEY);
			File   credFile     = new File(credFileName);
			
			if (credFile.exists()) {
				FileInputStream fis = null;
				
				try {
					props = new Properties();
					fis = new FileInputStream(credFileName);
					props.load(fis);
					
					_Logger.info("Successfully loaded credentials from file: " + credFileName);
				} catch (Exception e) {
					_Logger.log(Level.WARNING, "Failed to load credentials from file: " + credFileName, e);
				} finally {
					try {
						if (fis != null) fis.close();
					} catch (Exception e) {
						_Logger.warning("Failed to close FileInputStream. Resource may remain open.");
					} finally {
						fis = null;
					}
				}
			} else {
				_Logger.warning("Credential file non-existent: " + credFileName + ". Ignoring.");
			}
		}
		
		return props;
	}
	
	
	// private methods
	
	/**
	 * Initializes the backing properties store - this will either create a new
	 * instance (if the current ref is null) or clear the contents from the
	 * existing instance.
	 * 
	 */
	private void initBackingProperties()
	{
		sectionProperties = new INIConfiguration();
	}
	
	/**
	 * Attempts to load the configuration file set by the constructor
	 * (likely set a lookup to the system properties).
	 * 
	 * @return boolean True on success; false otherwise.
	 */
	private synchronized boolean loadConfig()
	{
		return loadConfig(this.configFileName);
	}
	
	/**
	 * Attempts to load the given configuration file. If the load
	 * fails, the default configuration file as specified
	 * by {@link ConfigConst#DEFAULT_CONFIG_FILE_NAME} will be used.
	 * 
	 * @param configFileName The configuration file name.
	 * @return boolean True on success; false otherwise.
	 */
	private synchronized boolean loadConfig(String configFileName)
	{
		File cfgFile = new File(configFileName);
		
		// ensure config file exists
		
		if (! cfgFile.exists()) {
			_Logger.log(
				Level.WARNING,
				"System properties config file '" + cfgFile.getAbsolutePath() + "' doesn't exist. Using default.",
				new Exception());
			
			cfgFile = new File(ConfigConst.DEFAULT_CONFIG_FILE_NAME);
		}
		
		if (cfgFile.exists()) {
			try {
				// init the backing properties, or clear out the existing one
				initBackingProperties();
				
				FileReader fReader = new FileReader(new File(cfgFile.getAbsoluteFile().toString()));
				
				sectionProperties.read(fReader);
				// sectionProperties.setFileName(cfgFile.getAbsoluteFile().toString());
				// sectionProperties.load();
				isLoaded = true;
			} catch (ConfigurationException e) {
				_Logger.log(
					Level.SEVERE,
					"Failed to parse existing config file: {0}. Config not set.",
					cfgFile.getAbsolutePath());
				
				_Logger.log(Level.SEVERE, "Configuration exception thrown loading config file.", e);
			} catch (FileNotFoundException e) {
				_Logger.log(
					Level.SEVERE,
					"Failed to load config file: {0} doesn't exist. Config not set.",
					cfgFile.getAbsolutePath());
				
				_Logger.log(Level.SEVERE, "File exception thrown loading config file.", e);
			} catch (IOException e) {
				_Logger.log(
					Level.SEVERE,
					"Failed to read config file: {0}. Config not set.",
					cfgFile.getAbsolutePath());
				
				_Logger.log(Level.SEVERE, "IO exception thrown loading config file.", e);
			}
		} else {
			_Logger.log(
				Level.WARNING,
				"Default config file {0} doesn't exist. Config not set.",
				cfgFile.getAbsolutePath());
		}
		
		if (! isLoaded) {
			_Logger.log(
				Level.WARNING,
				"System properties config file {0} doesn't exist. Using default.",
				cfgFile.getAbsolutePath());
		}
		
		return isLoaded;
	}
	
}
