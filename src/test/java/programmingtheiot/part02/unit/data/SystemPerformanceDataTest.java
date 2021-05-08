/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part02.unit.data;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.data.SystemPerformanceData;

/**
 * This test case class contains very basic unit tests for
 * SystemPerformanceData. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SystemPerformanceDataTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SystemPerformanceDataTest.class.getName());
	
	public static final String DEFAULT_NAME = "SystemPerformanceDataFooBar";
	public static final float DEFAULT_CPU_UTIL_DATA = 10.0f;
	public static final float DEFAULT_DISK_UTIL_DATA = 10.0f;
	public static final float DEFAULT_MEM_UTIL_DATA = 10.0f;
	
	
	// member var's
	
	
	// test setup methods
	
	@Before
	public void setUp() throws Exception
	{
	}
	
	@After
	public void tearDown() throws Exception
	{
	}
	
	
	// test methods
	
	@Test
	public void testDefaultValues()
	{
		SystemPerformanceData spd = new SystemPerformanceData();
		
		_Logger.info("Created data obj: " + spd.toString());
		
		assertEquals(spd.getName(), ConfigConst.SYS_PERF_DATA);
		assertEquals(spd.getStatusCode(), SystemPerformanceData.DEFAULT_STATUS);
		
		assertTrue(spd.getCpuUtilization() == ConfigConst.DEFAULT_VAL);
		assertTrue(spd.getDiskUtilization() == ConfigConst.DEFAULT_VAL);
		assertTrue(spd.getMemoryUtilization() == ConfigConst.DEFAULT_VAL);
	}
	
	@Test
	public void testParameterUpdates()
	{
		SystemPerformanceData spd = createTestData();
		
		_Logger.info("Created data obj: " + spd.toString());
		
		assertEquals(spd.getName(), DEFAULT_NAME);
		assertEquals(spd.getStatusCode(), SystemPerformanceData.DEFAULT_STATUS);
		
		assertTrue(spd.getCpuUtilization() == DEFAULT_CPU_UTIL_DATA);
		assertTrue(spd.getDiskUtilization() == DEFAULT_DISK_UTIL_DATA);
		assertTrue(spd.getMemoryUtilization() == DEFAULT_MEM_UTIL_DATA);
	}
	
	@Test
	public void testFullUpdate()
	{
		SystemPerformanceData spd = new SystemPerformanceData();
		_Logger.info("Created first data obj: " + spd.toString());
		
		SystemPerformanceData spd2 = createTestData();
		_Logger.info("Created second data obj: " + spd2.toString());
		
		assertEquals(spd.getName(), ConfigConst.SYS_PERF_DATA);
		assertEquals(spd.getStatusCode(), SystemPerformanceData.DEFAULT_STATUS);
		
		assertTrue(spd.getCpuUtilization() == ConfigConst.DEFAULT_VAL);
		assertTrue(spd.getDiskUtilization() == ConfigConst.DEFAULT_VAL);
		assertTrue(spd.getMemoryUtilization() == ConfigConst.DEFAULT_VAL);
		
		spd.updateData(spd2);
		_Logger.info("Updated second data obj: " + spd2.toString());
		
		assertEquals(spd.getName(), DEFAULT_NAME);
		assertEquals(spd.getStatusCode(), SystemPerformanceData.DEFAULT_STATUS);
		
		assertTrue(spd.getCpuUtilization() == DEFAULT_CPU_UTIL_DATA);
		assertTrue(spd.getDiskUtilization() == DEFAULT_DISK_UTIL_DATA);
		assertTrue(spd.getMemoryUtilization() == DEFAULT_MEM_UTIL_DATA);
	}
	
	
	// private
	
	private SystemPerformanceData createTestData()
	{
		SystemPerformanceData spd = new SystemPerformanceData();
		spd.setName(DEFAULT_NAME);
		
		spd.setCpuUtilization(DEFAULT_CPU_UTIL_DATA);
		spd.setDiskUtilization(DEFAULT_DISK_UTIL_DATA);
		spd.setMemoryUtilization(DEFAULT_MEM_UTIL_DATA);
		
		return spd;
	}
	
}
