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

import org.junit.Test;

import programmingtheiot.data.*;

/**
 * This test case class contains very basic unit tests for
 * DataUtil. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class DataUtilTest
{
	// static
	
	public static final String DEFAULT_NAME = "DataUtilTestName";
	public static final String DEFAULT_LOCATION = "DataUtilTestLocation";
	public static final int DEFAULT_STATUS = 1;
	public static final int DEFAULT_CMD = 1;
	public static final float DEFAULT_VAL = 12.5f;
	
	private static final Logger _Logger =
		Logger.getLogger(DataUtilTest.class.getName());
	
	// member var's
	
	
	// test setup methods
	
	
	// test methods
	
	@Test
	public void testActuatorDataToJsonAndBack()
	{
		DataUtil dataUtil = DataUtil.getInstance();
		
		ActuatorData data = new ActuatorData();
		data.setName(DEFAULT_NAME);
		data.setStatusCode(DEFAULT_STATUS);
		data.setCommand(DEFAULT_CMD);
		data.setValue(DEFAULT_VAL);
		
		String jsonData = dataUtil.actuatorDataToJson(data);
		
		assertNotNull(jsonData);
				
		ActuatorData data2 = dataUtil.jsonToActuatorData(jsonData);
		
		assertEquals(data.getName(), data2.getName());
		assertTrue(data.getStatusCode() == data2.getStatusCode());
		assertTrue(data.getCommand() == data2.getCommand());
		assertTrue(data.getValue() == data2.getValue());
	}
	
	@Test
	public void testSensorDataToJsonAndBack()
	{
		DataUtil dataUtil = DataUtil.getInstance();
		
		SensorData data = new SensorData();
		data.setName(DEFAULT_NAME);
		data.setStatusCode(DEFAULT_STATUS);
		data.setValue(DEFAULT_VAL);
		
		String jsonData = dataUtil.sensorDataToJson(data);
		
		assertNotNull(jsonData);
		
		SensorData data2 = dataUtil.jsonToSensorData(jsonData);
		
		assertEquals(data.getName(), data2.getName());
		assertTrue(data.getStatusCode() == data2.getStatusCode());
		assertTrue(data.getValue() == data2.getValue());
	}
	
	@Test
	public void testSystemPerformanceDatatoJsonAndBack()
	{
		DataUtil dataUtil = DataUtil.getInstance();
		
		SystemPerformanceData data = new SystemPerformanceData();
		data.setName(DEFAULT_NAME);
		data.setStatusCode(DEFAULT_STATUS);
		data.setCpuUtilization(DEFAULT_VAL);
		data.setDiskUtilization(DEFAULT_VAL);
		data.setMemoryUtilization(DEFAULT_VAL);
		
		String jsonData = dataUtil.systemPerformanceDataToJson(data);
		
		assertNotNull(jsonData);
		
		SystemPerformanceData data2 = dataUtil.jsonToSystemPerformanceData(jsonData);
		
		assertEquals(data.getName(), data2.getName());
		assertTrue(data.getStatusCode() == data2.getStatusCode());
		assertTrue(data.getCpuUtilization() == data2.getCpuUtilization());
		assertTrue(data.getDiskUtilization() == data2.getDiskUtilization());
		assertTrue(data.getMemoryUtilization() == data2.getMemoryUtilization());
	}
	
	/**
	 * NOTE: SystemStateData is not required for the exercises in Programming the IoT.
	 * The test case below is disabled by default, but can easily be re-enabled by
	 * uncommenting the @Test attribute if SystemStateData is optionally implemented.
	 * 
	 */
	
//	@Test
	public void testSystemStateDatatoJsonAndBack()
	{
		DataUtil dataUtil = DataUtil.getInstance();
		
		SystemStateData data = new SystemStateData();
		data.setName(DEFAULT_NAME);
		data.setStatusCode(DEFAULT_STATUS);
		data.setCommand(DEFAULT_CMD);
		
		String jsonData = dataUtil.systemStateDataToJson(data);
		
		assertNotNull(jsonData);
		
		SystemStateData data2 = dataUtil.jsonToSystemStateData(jsonData);
		
		assertEquals(data.getName(), data2.getName());
		assertTrue(data.getStatusCode() == data2.getStatusCode());
		assertTrue(data.getCommand() == data2.getCommand());
	}
	
}
