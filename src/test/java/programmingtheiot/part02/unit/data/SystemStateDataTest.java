/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part02.unit.data;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;
import programmingtheiot.data.SystemStateData;

/**
 * This test case class contains very basic unit tests for
 * SystemStateData. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SystemStateDataTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SystemStateDataTest.class.getName());
	
	public static final String DEFAULT_NAME = "SystemStateDataFoobar";
	
	public static final int DEFAULT_ACTION_CMD = 1;
	public static final int DEFAULT_STATUS_CODE = 2;
	
	public static final float DEFAULT_VAL = 10.0f;
	
	
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
	
	/**
	 * NOTE: SystemStateData is not required for the exercises in Programming the IoT.
	 * The test cases below are disabled by default, but can easily be re-enabled by
	 * uncommenting the @Test attribute if SystemStateData is optionally implemented.
	 * 
	 */
	
//	@Test
	public void testDefaultValues()
	{
		SystemStateData ssd = new SystemStateData();
		
		assertEquals(ssd.getName(), ConfigConst.SYS_STATE_DATA);
		assertEquals(ssd.getStatusCode(), ConfigConst.DEFAULT_STATUS);
		assertTrue(ssd.getCommand() == ConfigConst.DEFAULT_COMMAND);
	}
	
//	@Test
	public void testParameterUpdates()
	{
		SystemStateData ssd = createTestData();
		
		assertEquals(ssd.getName(), DEFAULT_NAME);
		assertEquals(ssd.getStatusCode(), DEFAULT_STATUS_CODE);
		assertTrue(ssd.getCommand() == DEFAULT_ACTION_CMD);
		
		List<SensorData> sdList = ssd.getSensorDataList();
		
		for (SensorData sd : sdList) {
			assertTrue(sd.getValue() == DEFAULT_VAL);
		}
		
		List<SystemPerformanceData> spdList = ssd.getSystemPerformanceDataList();
		
		for (SystemPerformanceData spd : spdList) {
			assertTrue(spd.getCpuUtilization() == DEFAULT_VAL);
			assertTrue(spd.getDiskUtilization() == DEFAULT_VAL);
			assertTrue(spd.getMemoryUtilization() == DEFAULT_VAL);
		}
	}
	
//	@Test
	public void testFullUpdate()
	{
		SystemStateData ssd = new SystemStateData();
		SystemStateData ssd2 = createTestData();
		
		assertEquals(ssd.getName(), ConfigConst.SYS_STATE_DATA);
		assertEquals(ssd.getStatusCode(), ConfigConst.DEFAULT_STATUS);
		assertTrue(ssd.getCommand() == ConfigConst.DEFAULT_COMMAND);
		
		ssd.updateData(ssd2);
		
		assertEquals(ssd.getName(), DEFAULT_NAME);
		assertEquals(ssd.getStatusCode(), DEFAULT_STATUS_CODE);
		assertTrue(ssd.getCommand() == DEFAULT_ACTION_CMD);
		
		List<SensorData> sdList = ssd.getSensorDataList();
		
		for (SensorData sd : sdList) {
			assertTrue(sd.getValue() == DEFAULT_VAL);
		}
		
		List<SystemPerformanceData> spdList = ssd.getSystemPerformanceDataList();
		
		for (SystemPerformanceData spd : spdList) {
			assertTrue(spd.getCpuUtilization() == DEFAULT_VAL);
			assertTrue(spd.getDiskUtilization() == DEFAULT_VAL);
			assertTrue(spd.getMemoryUtilization() == DEFAULT_VAL);
		}
	}
	
	
	// private
	
	private SystemStateData createTestData()
	{
		SystemStateData ssd = new SystemStateData();
		ssd.setName(DEFAULT_NAME);
		
		ssd.setCommand(DEFAULT_ACTION_CMD);
		ssd.setStatusCode(DEFAULT_STATUS_CODE);
		
		SensorData sd = new SensorData();
		sd.setValue(DEFAULT_VAL);
		ssd.addSensorData(sd);
		
		SystemPerformanceData spd = new SystemPerformanceData();
		spd.setCpuUtilization(DEFAULT_VAL);
		spd.setDiskUtilization(DEFAULT_VAL);
		spd.setMemoryUtilization(DEFAULT_VAL);
		ssd.addSystemPerformanceData(spd);
		
		return ssd;
	}
	
}
