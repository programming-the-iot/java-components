/**
 * 
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part03.integration.connection;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.DefaultDataMessageListener;
import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.DataUtil;
import programmingtheiot.data.SensorData;
import programmingtheiot.gda.connection.*;

/**
 * This test case class contains very basic integration tests for
 * CoapClientConnector. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 * 
 * NOTE: The CoAP server must be running before executing these tests.
 */
public class CoapClientPerformanceTest
{
	// static
	
	public static final int DEFAULT_TIMEOUT = 5;
	public static final boolean USE_DEFAULT_RESOURCES = true;
	
	private static final Logger _Logger =
		Logger.getLogger(CoapClientPerformanceTest.class.getName());
	
	public static final int MAX_TEST_RUNS = 10000;
	
	// member var's
	
	private CoapClientConnector coapClient = null;

	private IDataMessageListener dataMsgListener = null;
	
	
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
		this.coapClient = new CoapClientConnector();
		this.dataMsgListener = new DefaultDataMessageListener();
		
		this.coapClient.setDataMessageListener(this.dataMsgListener);
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
	 * 
	 */
	@Test
	public void testPostRequestCon()
	{
		_Logger.info("Testing POST - CON");
		
		execTestPost(MAX_TEST_RUNS, true);
	}
	
	/**
	 * 
	 */
	@Test
	public void testPostRequestNon()
	{
		_Logger.info("Testing POST - NON");
		
		execTestPost(MAX_TEST_RUNS, false);
	}
	
	/**
	 * 
	 */
	@Test
	public void testPutRequestCon()
	{
		_Logger.info("Testing PUT - CON");
		
		execTestPut(MAX_TEST_RUNS, true);
	}
	
	/**
	 * 
	 */
	@Test
	public void testPutRequestNon()
	{
		_Logger.info("Testing PUT - NON");
		
		execTestPut(MAX_TEST_RUNS, false);
	}
	
	// private
	
	private void execTestPost(int maxTestRuns, boolean enableCON)
	{
		SensorData sd = new SensorData();
		String payload = DataUtil.getInstance().sensorDataToJson(sd);
				
		long startMillis = System.currentTimeMillis();
		
		for (int seqNo = 0; seqNo < maxTestRuns; seqNo++) {
			this.coapClient.sendPostRequest(ResourceNameEnum.CDA_SENSOR_MSG_RESOURCE, ConfigConst.TEMP_SENSOR_NAME, enableCON, payload, DEFAULT_TIMEOUT);
		}
		
		long endMillis = System.currentTimeMillis();
		long elapsedMillis = endMillis - startMillis;
				
		_Logger.info("POST message - useCON = " + enableCON + " [" + maxTestRuns + "]: " + elapsedMillis + " ms");
	}
	
	private void execTestPut(int maxTestRuns, boolean enableCON)
	{
		SensorData sd = new SensorData();
		String payload = DataUtil.getInstance().sensorDataToJson(sd);
				
		long startMillis = System.currentTimeMillis();
		
		for (int seqNo = 0; seqNo < maxTestRuns; seqNo++) {
			this.coapClient.sendPutRequest(ResourceNameEnum.CDA_SENSOR_MSG_RESOURCE, ConfigConst.TEMP_SENSOR_NAME, enableCON, payload, DEFAULT_TIMEOUT);
		}
		
		long endMillis = System.currentTimeMillis();
		long elapsedMillis = endMillis - startMillis;
				
		_Logger.info("PUT message - useCON = " + enableCON + " [" + maxTestRuns + "]: " + elapsedMillis + " ms");
	}
	
}
