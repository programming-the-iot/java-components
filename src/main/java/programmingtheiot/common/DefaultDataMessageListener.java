/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import programmingtheiot.data.ActuatorData;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;

/**
 * A simple default implementation of {@link IDataMessageListener}
 * callback methods that log messages.
 * 
 */
public class DefaultDataMessageListener implements IDataMessageListener
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(DefaultDataMessageListener.class.getName());
	
	// private var's
	
	
	// constructors
	
	/**
	 * Default constructor.
	 * 
	 */
	public DefaultDataMessageListener()
	{
		super();
	}
	
	
	// public methods
	
	/**
	 * Logs an INFO message when invoked with the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The ActuatorData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 */
	@Override
	public boolean handleActuatorCommandResponse(ResourceNameEnum resourceName, ActuatorData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		return true;
	}

	/**
	 * Logs an INFO message when invoked with the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The ActuatorData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 */
	@Override
	public boolean handleActuatorCommandRequest(ResourceNameEnum resourceName, ActuatorData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		return true;
	}

	/**
	 * Logs an INFO message when invoked with the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param msg The String message - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 */
	@Override
	public boolean handleIncomingMessage(ResourceNameEnum resourceName, String msg)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), msg});
		
		return true;
	}

	/**
	 * Logs an INFO message when invoked with the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The SensorData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 */
	@Override
	public boolean handleSensorMessage(ResourceNameEnum resourceName, SensorData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		return true;
	}

	/**
	 * Logs an INFO message when invoked with the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The SystemPerformanceData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 */
	@Override
	public boolean handleSystemPerformanceMessage(ResourceNameEnum resourceName, SystemPerformanceData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		return true;
	}
	
	/**
	 * Sets the actuator data listener.
	 * 
	 * @param name
	 * @param listener
	 */
	public void setActuatorDataListener(String name, IActuatorDataListener listener)
	{
		// ignore
	}
	
}
