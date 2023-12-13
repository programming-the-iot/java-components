/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.common;

import programmingtheiot.data.ActuatorData;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;

/**
 * A simple callback interface for handling data messages
 * from a connection.
 *
 */
public interface IDataMessageListener
{
	/**
	 * Callback signature for data message passing using the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The ActuatorData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 * @return True on success; false otherwise.
	 */
	public boolean handleActuatorCommandResponse(ResourceNameEnum resourceName, ActuatorData data);

	/**
	 * Callback signature for data message passing using the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The ActuatorData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 * @return True on success; false otherwise.
	 */
	public boolean handleActuatorCommandRequest(ResourceNameEnum resourceName, ActuatorData data);

	/**
	 * Callback signature for data message passing using the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param msg The String message - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 * @return True on success; false otherwise.
	 */
	public boolean handleIncomingMessage(ResourceNameEnum resourceName, String msg);
	
	/**
	 * Callback signature for data message passing using the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The SensorData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 * @return True on success; false otherwise.
	 */
	public boolean handleSensorMessage(ResourceNameEnum resourceName, SensorData data);
	
	/**
	 * Callback signature for data message passing using the given parameters.
	 * 
	 * @param resourceName The enum representing the String resource name.
	 * @param data The SystemPerformanceData data - this will usually be the decoded payload
	 * from a connection using either MQTT or CoAP.
	 * @return True on success; false otherwise.
	 */
	public boolean handleSystemPerformanceMessage(ResourceNameEnum resourceName, SystemPerformanceData data);
	
	/**
	 * Sets the actuator data listener.
	 * 
	 * @param name
	 * @param listener
	 */
	public void setActuatorDataListener(String name, IActuatorDataListener listener);
	
}
