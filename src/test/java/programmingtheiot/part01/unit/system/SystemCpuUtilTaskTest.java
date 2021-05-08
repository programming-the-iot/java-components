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

import programmingtheiot.gda.system.SystemCpuUtilTask;

/**
 * This test case class contains very basic unit tests for
 * SystemCpuUtilTaskTest. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SystemCpuUtilTaskTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SystemCpuUtilTaskTest.class.getName());
	
	// member var's
	
	private SystemCpuUtilTask cpuUtilTask = null;
	
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
		this.cpuUtilTask = new SystemCpuUtilTask();
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
	 * Test method for {@link programmingtheiot.gda.system.SystemCpuUtilTask#getTelemetryValue()}.
	 */
	@Test
	public void testGetTelemetryValue()
	{
		float cpuUtil  = 0.0f;
		int   totTests = 5;
		
		cpuUtil = this.cpuUtilTask.getTelemetryValue();
		
		for (int i = 1; i <= totTests; i++) {
			if (cpuUtil >= 0.0f) {
				_Logger.info("Test " + i + ": CPU Util: " + cpuUtil);
				assertTrue(cpuUtil >= 0.0f);
			} else if (cpuUtil < 0.0f) {
				_Logger.info("Test " + i + ": CPU Util not supported on this OS: " + cpuUtil);
			} else {
				fail("Failed to retrieve CPU utilization.");
			}
		}
	}
	
}
