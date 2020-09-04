/**
 * 
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part02.integration.connection;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;
import programmingtheiot.common.DefaultDataMessageListener;
import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.DataUtil;
import programmingtheiot.data.SystemStateData;
import programmingtheiot.gda.connection.*;

/**
 * This test case class contains very basic integration tests for
 * SmtpClientConnector. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SmtpClientConnectorTest
{
	// static
	
	public static final int DEFAULT_TIMEOUT = 5;
	public static final boolean USE_DEFAULT_RESOURCES = true;
	
	private static final Logger _Logger =
		Logger.getLogger(SmtpClientConnectorTest.class.getName());
	
	// member var's
	
	private SmtpClientConnector smtpClient = null;
	private IDataMessageListener dml = null;
	
	
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
		this.smtpClient = new SmtpClientConnector();
		this.dml = new DefaultDataMessageListener();
		
		this.smtpClient.setDataMessageListener(this.dml);
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
	public void testPostRequest()
	{
		// TODO: issue request and validate response
		
		int actionCmd = 1;
		
		SystemStateData ssd = new SystemStateData();
		ssd.setActionCommand(actionCmd);
		
		String ssdJson = DataUtil.getInstance().systemStateDataToJson(ssd);
		
		assertTrue(this.smtpClient.sendPostRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, ssdJson, DEFAULT_TIMEOUT));
		assertTrue(this.smtpClient.sendGetRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, DEFAULT_TIMEOUT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testPutRequest()
	{
		// TODO: issue request and validate response
		
		int actionCmd = 2;
		
		SystemStateData ssd = new SystemStateData();
		ssd.setActionCommand(actionCmd);
		
		String ssdJson = DataUtil.getInstance().systemStateDataToJson(ssd);
		
		assertTrue(this.smtpClient.sendPutRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, ssdJson, DEFAULT_TIMEOUT));
		assertTrue(this.smtpClient.sendGetRequest(ResourceNameEnum.GDA_MGMT_STATUS_MSG_RESOURCE, DEFAULT_TIMEOUT));
	}
	
}
