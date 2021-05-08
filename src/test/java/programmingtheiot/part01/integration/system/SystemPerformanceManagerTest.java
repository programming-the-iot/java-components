/**
 * 
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part01.integration.system;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.gda.system.SystemPerformanceManager;

/**
 * This test case class contains very basic integration tests for
 * SystemPerformanceManagerTest. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SystemPerformanceManagerTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SystemPerformanceManagerTest.class.getName());
	
	
	// member var's
	
	private SystemPerformanceManager spMgr = null;
	
	
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
		this.spMgr = new SystemPerformanceManager();
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
	 * Test method for {@link programmingtheiot.gda.system.SystemPerformanceManager#startManager()}
	 * and {@link programmingtheiot.gda.system.SystemPerformanceManager#stopManager()}
	 */
	@Test
	public void testStartAndStopManager()
	{
		this.spMgr.startManager();
		
		try {
			Thread.sleep(60000L);
		} catch (InterruptedException e) {
			// ignore
		}
		
		this.spMgr.stopManager();
	}
	
}
