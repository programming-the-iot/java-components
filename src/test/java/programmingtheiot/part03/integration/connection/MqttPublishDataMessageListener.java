/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.part03.integration.connection;

import java.util.logging.Level;
import java.util.logging.Logger;

import programmingtheiot.common.IActuatorDataListener;
import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.ActuatorData;
import programmingtheiot.data.DataUtil;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;
import programmingtheiot.gda.connection.IPubSubClient;
import programmingtheiot.gda.connection.MqttClientConnector;

/**
 * A simple default implementation of {@link IDataMessageListener}
 * callback methods that log messages.
 * 
 */
public class MqttPublishDataMessageListener implements IDataMessageListener
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(MqttPublishDataMessageListener.class.getName());
	
	public static final int DEFAULT_QOS = 0;
	
	// private var's
	
	private IPubSubClient mqttClient = null;
	private boolean pubOnMsg = true;
	
	private ResourceNameEnum pubResource = null;
	
	// constructors
	
	/**
	 * Constructor.
	 * 
	 * @param pubResource The ResourceNameEnum instance to use as the topic.
	 * @param pubOnMsg If true, the callbacks implemented in this class will attempt
	 * to publish the incoming data message to pubResource.
	 */
	public MqttPublishDataMessageListener(ResourceNameEnum pubResource, boolean pubOnMsg)
	{
		super();
		
		this.pubResource = pubResource;
		this.pubOnMsg = pubOnMsg;
		
		mqttClient = new MqttClientConnector();
	}
	
	
	// public methods
	
	/**
	 * Processes and logs an actuator response message.
	 * 
	 * @param resourceName Ignored in this method implementation.
	 * @param data The data container to convert to JSON and publish.
	 * @return boolean Will always return true.
	 */
	@Override
	public boolean handleActuatorCommandResponse(ResourceNameEnum resourceName, ActuatorData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		return true;
	}

	/**
	 * Processes and publishes an actuator command message.
	 * 
	 * @param resourceName Ignored in this method implementation.
	 * @param data The data container to convert to JSON and publish.
	 * @return boolean Will always return true.
	 */
	@Override
	public boolean handleActuatorCommandRequest(ResourceNameEnum resourceName, ActuatorData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		if (this.pubOnMsg) {
			String msg = DataUtil.getInstance().actuatorDataToJson(data);
			
			this.mqttClient.publishMessage(this.pubResource, msg, DEFAULT_QOS);
		}
		
		return true;
	}

	/**
	 * Processes and publishes a String-based message.
	 * 
	 * @param resourceName Ignored in this method implementation.
	 * @param data The data container to convert to JSON and publish.
	 * @return boolean Will always return true.
	 */
	@Override
	public boolean handleIncomingMessage(ResourceNameEnum resourceName, String msg)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), msg});
		
		if (this.pubOnMsg) {
			this.mqttClient.publishMessage(this.pubResource, msg, DEFAULT_QOS);
		}
		
		return true;
	}

	/**
	 * Processes and publishes a sensor data message.
	 * 
	 * @param resourceName Ignored in this method implementation.
	 * @param data The data container to convert to JSON and publish.
	 * @return boolean Will always return true.
	 */
	@Override
	public boolean handleSensorMessage(ResourceNameEnum resourceName, SensorData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		if (this.pubOnMsg) {
			String msg = DataUtil.getInstance().sensorDataToJson(data);
			
			this.mqttClient.publishMessage(this.pubResource, msg, DEFAULT_QOS);
		}
		
		return true;
	}

	/**
	 * Processes and publishes a system performance message.
	 * 
	 * @param resourceName Ignored in this method implementation.
	 * @param data The data container to convert to JSON and publish.
	 * @return boolean Will always return true.
	 */
	@Override
	public boolean handleSystemPerformanceMessage(ResourceNameEnum resourceName, SystemPerformanceData data)
	{
		_Logger.log(Level.INFO, "Topic: {0}, Message: {1}", new Object[] {resourceName.getResourceName(), data});
		
		if (this.pubOnMsg) {
			String msg = DataUtil.getInstance().systemPerformanceDataToJson(data);
			
			this.mqttClient.publishMessage(this.pubResource, msg, DEFAULT_QOS);
		}
		
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
		// ignore - nothing to do.
	}
	
}
