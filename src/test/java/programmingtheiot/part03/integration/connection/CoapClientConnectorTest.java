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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.common.DefaultDataMessageListener;
import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.DataUtil;
import programmingtheiot.data.SystemStateData;
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
public class CoapClientConnectorTest
{
	// static
	
	public static final int DEFAULT_TIMEOUT = 5;
	public static final boolean USE_DEFAULT_RESOURCES = true;
	
	private static final Logger _Logger =
		Logger.getLogger(CoapClientConnectorTest.class.getName());
	
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
	public void testConnectAndDiscover()
	{
		assertTrue(this.coapClient.sendDiscoveryRequest(DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetRequestCon()
	{
		// TODO: issue request and validate response
		
		assertTrue(this.coapClient.sendGetRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, null, true, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetRequestNon()
	{
		// TODO: issue request and validate response
		
		assertTrue(this.coapClient.sendGetRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, null, false, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPostRequestCon()
	{
		// TODO: issue request and validate response
		
		int actionCmd = 1;
		
		SystemStateData ssd = new SystemStateData();
		ssd.setCommand(actionCmd);
		
		String ssdJson = DataUtil.getInstance().systemStateDataToJson(ssd);
		
		assertTrue(this.coapClient.sendPostRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, null, true, ssdJson, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPostRequestNon()
	{
		// TODO: issue request and validate response
		
		int actionCmd = 1;
		
		SystemStateData ssd = new SystemStateData();
		ssd.setCommand(actionCmd);
		
		String ssdJson = DataUtil.getInstance().systemStateDataToJson(ssd);
		
		assertTrue(this.coapClient.sendPostRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, null, false, ssdJson, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPutRequestCon()
	{
		// TODO: issue request and validate response
		
		int actionCmd = 2;
		
		SystemStateData ssd = new SystemStateData();
		ssd.setCommand(actionCmd);
		
		String ssdJson = DataUtil.getInstance().systemStateDataToJson(ssd);
		
		assertTrue(this.coapClient.sendPutRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, null, true, ssdJson, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPutRequestNon()
	{
		// TODO: issue request and validate response
		
		int actionCmd = 2;
		
		SystemStateData ssd = new SystemStateData();
		ssd.setCommand(actionCmd);
		
		String ssdJson = DataUtil.getInstance().systemStateDataToJson(ssd);
		
		assertTrue(this.coapClient.sendPutRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, null, false, ssdJson, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testDeleteRequestCon()
	{
		// TODO: issue request and validate response
		
		assertTrue(this.coapClient.sendDeleteRequest(ResourceNameEnum.GDA_MGMT_STATUS_CMD_RESOURCE, null, true, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testDeleteRequestNon()
	{
		// TODO: issue request and validate response
		
		assertTrue(this.coapClient.sendDeleteRequest(ResourceNameEnum.GDA_MGMT_STATUS_CMD_RESOURCE, null, false, DEFAULT_TIMEOUT));
	}
	
}
