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
import programmingtheiot.data.ActuatorData;

/**
 * This test case class contains very basic unit tests for
 * ActuatorData. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class ActuatorDataTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(ActuatorDataTest.class.getName());
	
	public static final String DEFAULT_NAME = "ActuatorDataFooBar";
	public static final int DEFAULT_CMD = 1;
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
	
	@Test
	public void testDefaultValues()
	{
		ActuatorData ad = new ActuatorData();
		
		assertEquals(ad.getName(), ConfigConst.NOT_SET);
		assertEquals(ad.getStatusCode(), ConfigConst.DEFAULT_STATUS);
		assertTrue(ad.getCommand() == ConfigConst.DEFAULT_COMMAND);
		assertTrue(ad.getValue() == ConfigConst.DEFAULT_VAL);
	}
	
	@Test
	public void testParameterUpdates()
	{
		ActuatorData ad = createTestData();
		
		assertEquals(ad.getName(), DEFAULT_NAME);
		assertEquals(ad.getStatusCode(), ActuatorData.DEFAULT_STATUS);
		assertTrue(ad.getCommand() == DEFAULT_CMD);
		assertTrue(ad.getValue() == DEFAULT_VAL);
	}
	
	@Test
	public void testFullUpdate()
	{
		ActuatorData ad = new ActuatorData();
		ActuatorData ad2 = createTestData();

		assertEquals(ad.getName(), ConfigConst.NOT_SET);
		assertEquals(ad.getStatusCode(), ConfigConst.DEFAULT_STATUS);
		assertTrue(ad.getCommand() == ConfigConst.DEFAULT_COMMAND);
		assertTrue(ad.getValue() == ConfigConst.DEFAULT_VAL);
		
		ad.updateData(ad2);
		
		assertEquals(ad.getName(), DEFAULT_NAME);
		assertEquals(ad.getStatusCode(), ConfigConst.DEFAULT_STATUS);
		assertTrue(ad.getCommand() == DEFAULT_CMD);
		assertTrue(ad.getValue() == DEFAULT_VAL);
	}
	
	
	// private
	
	private ActuatorData createTestData()
	{
		ActuatorData ad = new ActuatorData();
		ad.setName(DEFAULT_NAME);
		ad.setCommand(DEFAULT_CMD);
		ad.setValue(DEFAULT_VAL);
		
		return ad;
	}
	
}
