/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part01.unit.system;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.data.SensorData;
import programmingtheiot.gda.system.SystemMemUtilTask;

/**
 * This test case class contains very basic unit tests for
 * SystemMemUtilTaskTest. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SystemMemUtilTaskTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SystemMemUtilTaskTest.class.getName());
	
	// member var's
	
	private SystemMemUtilTask memUtilTask = null;
	
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
		this.memUtilTask = new SystemMemUtilTask();
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
	 * Test method for {@link programmingtheiot.gda.system.SystemCpuUtilTask#generateTelemetry()}.
	 */
	@Test
	public void testGenerateTelemetry()
	{
		SensorData sd = this.memUtilTask.generateTelemetry();
		
		assertNotNull(sd);
		
		float val = sd.getValue();
		
		if (val >= 0.0f) {
			assertTrue(sd.getValue() >= 0.0f);
		} else {
			_Logger.info("Memory util not supported on this OS.");
		}
	}
	
	/**
	 * Test method for {@link programmingtheiot.gda.system.SystemCpuUtilTask#getTelemetryValue()}.
	 */
	@Test
	public void testGetTelemetryValue()
	{
		float memUtil  = 0.0f;
		int   totTests = 5;
		
		memUtil = this.memUtilTask.getTelemetryValue();
		
		for (int i = 1; i <= totTests; i++) {
			if (memUtil >= 0.0f) {
				_Logger.info("Test " + i + ": Memory Util: " + memUtil);
				assertTrue(memUtil >= 0.0f);
			} else if (memUtil < 0.0f) {
				_Logger.info("Test " + i + ": Memory Util not supported on this OS: " + memUtil);
			} else {
				fail("Failed to retrieve Memory utilization.");
			}
		}
	}
	
}
