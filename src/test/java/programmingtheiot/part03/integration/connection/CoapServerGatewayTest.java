/**
 * 
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part03.integration.connection;

import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.WebLink;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.DefaultDataMessageListener;
import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.gda.connection.*;

/**
 * This test case class contains very basic integration tests for
 * CoapServerGateway. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class CoapServerGatewayTest
{
	// static
	
	public static final int DEFAULT_TIMEOUT = 300 * 1000;
	public static final boolean USE_DEFAULT_RESOURCES = true;
	
	private static final Logger _Logger =
		Logger.getLogger(CoapServerGatewayTest.class.getName());
	
	
	// member var's
	
	private CoapServerGateway csg = null;
	private IDataMessageListener dml = null;
	
	
	// test setup methods
	
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
	 * 
	 */
	@Test
	public void testRunSimpleCoapServerGatewayIntegration()
	{
		try {
			String url =
				ConfigConst.DEFAULT_COAP_PROTOCOL + "://" + ConfigConst.DEFAULT_HOST + ":" + ConfigConst.DEFAULT_COAP_PORT;
			
			this.csg = new CoapServerGateway(new DefaultDataMessageListener());
			this.csg.startServer();
			
			Thread.sleep(5000);
			
			CoapClient clientConn = new CoapClient(url);
			
			Set<WebLink> wlSet = clientConn.discover();
				
			if (wlSet != null) {
				for (WebLink wl : wlSet) {
					_Logger.info(" --> WebLink: " + wl.getURI() + ". Attributes: " + wl.getAttributes());
				}
			}
			
			// execute some simple get requests
			
			/*
			 * NOTE: Change these to suit your own environment.
			 */
			
			clientConn.setURI(
				url + "/" + ConfigConst.PRODUCT_NAME);
			clientConn.get();
			
			clientConn.setURI(
				url + "/" + ConfigConst.PRODUCT_NAME + "/" + ConfigConst.CONSTRAINED_DEVICE);
			clientConn.get();
			
			clientConn.setURI(
				url + "/" + ResourceNameEnum.CDA_SYSTEM_PERF_MSG_RESOURCE.getResourceName());
			clientConn.get();
			
			// wait for 2 min's (so other app tests can run)
			Thread.sleep(120000L);
			
			this.csg.stopServer();
		} catch (Exception e) {
			// ignore
		}
	}
	
}
