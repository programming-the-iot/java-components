/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part01.unit.common;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.common.*;

/**
 * This test case class contains very basic unit tests for
 * ConfigUtil. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class ConfigUtilTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(ConfigUtilTest.class.getName());
	
	public static final String DIR_PREFIX = "./src/test/java/programmingtheiot/part01/unit/common/";
	public static final String TEST_VALID_CFG_FILE   = DIR_PREFIX + "ValidTestConfig.props";
	public static final String TEST_EMPTY_CFG_FILE   = DIR_PREFIX + "EmptyTestConfig.props";
	public static final String TEST_INVALID_CFG_FILE = DIR_PREFIX + "InvalidTestConfig.props";
	public static final String TEST_MISSING_CFG_FILE = DIR_PREFIX + "MissingTestConfig.props";
	
	public static final String HOST_VAL    = ConfigConst.DEFAULT_HOST;
	public static final String NOT_SET_VAL = "Not Set";
	public static final int    PORT_VAL    = 1883;
	
	public static final String DEFAULT_USER = "Foo";
	public static final String DEFAULT_AUTH = "Bar";

	
	// member var's
	
	private File validTestFile = new File(TEST_VALID_CFG_FILE);
	
	
	// test setup methods
	
	/**
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		// ConfigUtil will check if the property is set, and if so,
		// use it within this JRE instance
		System.setProperty(ConfigConst.CONFIG_FILE_KEY, TEST_VALID_CFG_FILE);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		// make sure test files exist
		assertTrue(validTestFile.exists());
		assertNotNull(ConfigUtil.getInstance());
	}
	
	// test methods
	
	@Test
	public void testGetCredentials()
	{
		Properties props =
			ConfigUtil.getInstance().getCredentials(ConfigConst.GATEWAY_DEVICE);
		
		assertNotNull(props);
		assertEquals(props.getProperty(ConfigConst.USER_NAME_TOKEN_KEY), DEFAULT_USER);
		assertEquals(props.getProperty(ConfigConst.USER_AUTH_TOKEN_KEY), DEFAULT_AUTH);
	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#getBooleanProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetBooleanProperty()
	{
		String enableLogging =
			ConfigUtil.getInstance().getProperty(ConfigConst.GATEWAY_DEVICE, ConfigConst.ENABLE_LOGGING_KEY);
		
		assertTrue(Boolean.parseBoolean(enableLogging));
	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#getIntegerProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetIntegerProperty()
	{
		String portStr =
			ConfigUtil.getInstance().getProperty(ConfigConst.MQTT_GATEWAY_SERVICE, ConfigConst.PORT_KEY);
		
		assertTrue((Integer.parseInt(portStr) == PORT_VAL));

	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#loadConfig(java.lang.String)}.
	 */
	@Test
	public void testGetProperty()
	{
		String host =
			ConfigUtil.getInstance().getProperty(ConfigConst.MQTT_GATEWAY_SERVICE, ConfigConst.HOST_KEY);
		
		String credFile =
			ConfigUtil.getInstance().getProperty(ConfigConst.MQTT_GATEWAY_SERVICE, ConfigConst.CRED_FILE_KEY);
		
		assertTrue(host.equals(String.valueOf(HOST_VAL)));
		assertNotNull(credFile);
	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#hasProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testHasProperty()
	{
		assertTrue(ConfigUtil.getInstance().hasProperty(ConfigConst.MQTT_GATEWAY_SERVICE, ConfigConst.ENABLE_CRYPT_KEY));
	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#hasSection(java.lang.String)}.
	 */
	@Test
	public void testHasSection()
	{
		assertTrue(ConfigUtil.getInstance().hasSection(ConfigConst.MQTT_GATEWAY_SERVICE));
	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#isConfigDataLoaded()}.
	 */
	@Test
	public void testIsConfigDataLoaded()
	{
		assertTrue(ConfigUtil.getInstance().isConfigDataLoaded());
	}
	
}
