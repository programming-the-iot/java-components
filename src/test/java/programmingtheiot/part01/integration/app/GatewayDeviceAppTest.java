/**
 * 
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part01.integration.app;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.gda.app.GatewayDeviceApp;

/**
 * This test case class contains very basic integration tests for
 * GatewayDeviceApp. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class GatewayDeviceAppTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(GatewayDeviceAppTest.class.getName());
	

	// member var's
	
	private GatewayDeviceApp gda = null;
	
	
	// test setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		gda = new GatewayDeviceApp((String[]) null);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	// test methods
	
	/**
	 * Convenience test method for starting and stopping the GDA. This will invoke both
	 * {@link programmingtheiot.gda.app.GatewayDeviceApp#startApp()} and
	 * {@link programmingtheiot.gda.app.GatewayDeviceApp#stopApp(int)} in sequence.
	 * <p>
	 * Validation is via log output and the expectation that no exception will be
	 * thrown during execution.
	 */
	@Test
	public void testStartAndStopGatewayApp()
	{
		this.gda.startApp();
		
		try {
			Thread.sleep(65000L);
		} catch (InterruptedException e) {
			// ignore
		}
		
		this.gda.stopApp(0);
	}
	
}
