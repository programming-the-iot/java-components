/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.part02.integration.data;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;

import programmingtheiot.data.DataUtil;
import programmingtheiot.data.ActuatorData;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;

/**
 * This test case class contains very basic integration tests for
 * DataUtil and data container classes for use between the CDA and
 * GDA to verify JSON compatibility. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class DataIntegrationTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(DataIntegrationTest.class.getName());
	
	public static final String DEFAULT_NAME = "DataIntegrationTestName";
	public static final String DEFAULT_LOCATION = "DataIntegrationTestLocation";
	public static final int DEFAULT_STATUS = 1;
	public static final int DEFAULT_CMD = 1;
	public static final float DEFAULT_VAL = 12.5f;
	
	private static String _CdaDataPath = "";
	private static String _GdaDataPath = "";
	

	// member var's
	
	
	// test setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		_CdaDataPath = ConfigUtil.getInstance().getProperty(ConfigConst.GATEWAY_DEVICE, ConfigConst.TEST_CDA_DATA_PATH_KEY);
		_GdaDataPath = ConfigUtil.getInstance().getProperty(ConfigConst.GATEWAY_DEVICE, ConfigConst.TEST_GDA_DATA_PATH_KEY);
		
		try {
			File gdaPath = new File(_GdaDataPath);
			if (! gdaPath.exists()) {
				gdaPath.mkdirs();
			}
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to create GDA path hierarchy: " + _GdaDataPath, e);
		}
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
	 * Test ActuatorData -> GDA filesystem.
	 */
	@Test
	public void testWriteActuatorDataToGdaDataPath()
	{
		// write JSON to GDA filesystem
		String fileName = _GdaDataPath + "/ActuatorData.dat";
		
		_Logger.info("\n\n----- [ActuatorData to JSON to file] -----");
		
		try {
			Path   filePath = FileSystems.getDefault().getPath(fileName);
			String dataStr  = DataUtil.getInstance().actuatorDataToJson(new ActuatorData());
			
			_Logger.info("Sample ActuatorData JSON (validated): " + dataStr);
			_Logger.info("Writing ActuatorData JSON to GDA data path: " + filePath);
			
			Files.writeString(filePath, dataStr, StandardCharsets.UTF_8);
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to write file: " + fileName, e);
			
			fail("Failed to read file: " + fileName);
		}
	}
	
	/**
	 * Test SensorData -> GDA filesystem.
	 */
	@Test
	public void testWriteSensorDataToGdaDataPath()
	{
		// write JSON to GDA filesystem
		String fileName = _GdaDataPath + "/SensorData.dat";
		
		_Logger.info("\n\n----- [SensorData to JSON to file] -----");
		
		try {
			Path   filePath = FileSystems.getDefault().getPath(fileName);
			String dataStr  = DataUtil.getInstance().sensorDataToJson(new SensorData());
			
			_Logger.info("Sample SensorData JSON (validated): " + dataStr);
			_Logger.info("Writing SensorData JSON to GDA data path: " + filePath);
			
			Files.writeString(filePath, dataStr, StandardCharsets.UTF_8);
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to write file: " + fileName, e);
			
			fail("Failed to read file: " + fileName);
		}
	}
	
	/**
	 * Test SystemPerformanceData -> GDA filesystem.
	 */
	@Test
	public void testWriteSystemPerformanceDataToGdaDataPath()
	{
		// write JSON to GDA filesystem
		String fileName = _GdaDataPath + "/SystemPerformanceData.dat";
		
		_Logger.info("\n\n----- [SystemPerformanceData to JSON to file] -----");
		
		try {
			Path   filePath = FileSystems.getDefault().getPath(fileName);
			String dataStr  = DataUtil.getInstance().systemPerformanceDataToJson(new SystemPerformanceData());
			
			_Logger.info("Sample SystemPerformanceData JSON (validated): " + dataStr);
			_Logger.info("Writing SystemPerformanceData JSON to GDA data path: " + filePath);
			
			Files.writeString(filePath, dataStr, StandardCharsets.UTF_8);
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to write file: " + fileName, e);
			
			fail("Failed to read file: " + fileName);
		}
	}
	
	/**
	 * Tests ActuatorData <- CDA filesystem.
	 */
	@Test
	public void testReadActuatorDataFromCdaDataPath()
	{
		// Read JSON from CDA filesystem
		String fileName = _CdaDataPath + "/ActuatorData.dat";
		
		_Logger.info("\n\n----- [ActuatorData JSON from file to object] -----");
		
		try {
			Path   filePath = FileSystems.getDefault().getPath(fileName);
			String dataStr  = Files.readString(filePath, StandardCharsets.UTF_8);
			
			ActuatorData dataObj = DataUtil.getInstance().jsonToActuatorData(dataStr);

			_Logger.info("ActuatorData JSON from CDA: " + dataStr);
			_Logger.info("ActuatorData object: " + dataObj);
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to read file: " + fileName, e);
			
			fail("Failed to read file: " + fileName);
		}
	}
	
	/**
	 * Tests SensorData <- CDA filesystem.
	 */
	@Test
	public void testReadSensorDataFromCdaDataPath()
	{
		// Read JSON from CDA filesystem
		String fileName = _CdaDataPath + "/SensorData.dat";
		
		_Logger.info("\n\n----- [SensorData JSON from file to object] -----");
		
		try {
			Path   filePath = FileSystems.getDefault().getPath(fileName);
			String dataStr  = Files.readString(filePath, StandardCharsets.UTF_8);
			
			SensorData dataObj = DataUtil.getInstance().jsonToSensorData(dataStr);

			_Logger.info("SensorData JSON from CDA: " + dataStr);
			_Logger.info("SensorData object: " + dataObj);
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to read file: " + fileName, e);
			
			fail("Failed to read file: " + fileName);
		}
	}
	
	/**
	 * Tests SystemPerformanceData <- CDA filesystem.
	 */
	@Test
	public void testReadSystemPerformanceDataFromCdaDataPath()
	{
		// Read JSON from CDA filesystem
		String fileName = _CdaDataPath + "/SystemPerformanceData.dat";
		
		_Logger.info("\n\n----- [SystemPerformanceData JSON from file to object] -----");
		
		try {
			Path   filePath = FileSystems.getDefault().getPath(fileName);
			String dataStr  = Files.readString(filePath, StandardCharsets.UTF_8);
			
			SystemPerformanceData dataObj = DataUtil.getInstance().jsonToSystemPerformanceData(dataStr);

			_Logger.info("SystemPerformanceData JSON from CDA: " + dataStr);
			_Logger.info("SystemPerformanceData object: " + dataObj);
		} catch (Exception e) {
			_Logger.log(Level.WARNING, "Failed to read file: " + fileName, e);
			
			fail("Failed to read file: " + fileName);
		}
	}
	
}
