/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part01.unit.common;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import programmingtheiot.common.*;

/**
 * This test case class contains very basic unit tests for
 * ResourceNameEnum. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class ResourceNameTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(ResourceNameTest.class.getName());
	
	
	// member var's
	
	
	// test setup methods
	
	/**
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}
	
	// test methods
	
	@Test
	public void testListAllResourceNames()
	{
		StringBuilder buf = new StringBuilder();
		
		for (ResourceNameEnum resource : ResourceNameEnum.values()) {
			buf.append(resource.getResourceName()).append(System.lineSeparator());
		}
		
		_Logger.info("Resource name listing:\n" + buf.toString());
	}
	
	/**
	 * Test method for {@link com.labbenchstudios.edu.connecteddevices.common.ConfigUtil#getBooleanProperty(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCheckResourceName()
	{
		ResourceNameEnum resourceA = ResourceNameEnum.values()[0];
		String           name      = resourceA.getResourceName();
		ResourceNameEnum resourceB = ResourceNameEnum.getEnumFromValue(name);
		
		assertTrue(resourceA == resourceB);
	}
	
}
