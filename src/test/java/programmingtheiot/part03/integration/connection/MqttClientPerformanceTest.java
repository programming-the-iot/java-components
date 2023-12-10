/**
 * 
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part03.integration.connection;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import programmingtheiot.common.ConfigUtil;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.DataUtil;
import programmingtheiot.data.SensorData;
import programmingtheiot.gda.connection.MqttClientConnector;

/**
 * This test case class contains very basic integration tests for
 * MqttClientPerformanceTest. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 * 
 * IMPORTANT NOTE: This test expects MqttClientConnector to be
 * configured using the synchronous MqttClient.
 *
 */
public class MqttClientPerformanceTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(MqttClientPerformanceTest.class.getName());
	
	public static final int MAX_TEST_RUNS = 10000;
	
	// member var's
	
	// TODO: make sure MqttClientConnector is configured to
	// use the synchronous MqttClient
	private MqttClientConnector mqttClient = null;
	
	
	// test setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		ConfigUtil.getInstance();
		this.mqttClient = new MqttClientConnector();
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
	 * Test method for {@link programmingtheiot.gda.connection.MqttClientConnector#connectClient()}.
	 */
	@Test
	public void testConnectAndDisconnect()
	{
		long startMillis = System.currentTimeMillis();
		
		assertTrue(this.mqttClient.connectClient());
		assertTrue(this.mqttClient.disconnectClient());
		
		long endMillis = System.currentTimeMillis();
		long elapsedMillis = endMillis - startMillis;
		
		_Logger.info("Connect and Disconnect [1]: " + elapsedMillis + " ms");
	}
	
	/**
	 * Test method for {@link programmingtheiot.gda.connection.MqttClientConnector#publishMessage(programmingtheiot.common.ResourceNameEnum, java.lang.String, int)}.
	 */
	@Test
	public void testPublishQoS0()
	{
		execTestPublish(MAX_TEST_RUNS, 0);
	}
	
	/**
	 * Test method for {@link programmingtheiot.gda.connection.MqttClientConnector#publishMessage(programmingtheiot.common.ResourceNameEnum, java.lang.String, int)}.
	 */
	@Test
	public void testPublishQoS1()
	{
		execTestPublish(MAX_TEST_RUNS, 1);
	}
	
	/**
	 * Test method for {@link programmingtheiot.gda.connection.MqttClientConnector#publishMessage(programmingtheiot.common.ResourceNameEnum, java.lang.String, int)}.
	 */
	@Test
	public void testPublishQoS2()
	{
		execTestPublish(MAX_TEST_RUNS, 2);
	}
	
	// private methods
	
	/**
	 * @param maxTestRuns
	 * @param qos
	 */
	private void execTestPublish(int maxTestRuns, int qos)
	{
		assertTrue(this.mqttClient.connectClient());
		
		SensorData sensorData = new SensorData();
		
		String payload = DataUtil.getInstance().sensorDataToJson(sensorData);
		int payloadLen = payload.length();
		
		long startMillis = System.currentTimeMillis();
		
		for (int sequenceNo = 1; sequenceNo <= maxTestRuns; sequenceNo++) {
			this.mqttClient.publishMessage(ResourceNameEnum.CDA_MGMT_STATUS_CMD_RESOURCE, payload, qos);
		}
		
		long endMillis = System.currentTimeMillis();
		long elapsedMillis = endMillis - startMillis;
		
		assertTrue(this.mqttClient.disconnectClient());
		
		String msg =
			String.format(
				"\\n\\tTesting Publish: QoS = %s | msgs = %s | payload size = %s | start = %s | end = %s | elapsed = %s",
				qos, maxTestRuns, payloadLen,
				(float) startMillis / 1000, (float) endMillis / 1000, (float) elapsedMillis / 1000);
		
		_Logger.info(msg);
	}
	
}
