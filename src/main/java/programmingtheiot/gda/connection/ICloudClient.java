/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.gda.connection;

import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;

/**
 * Interface contract for pub/sub clients.
 * 
 */
public interface ICloudClient
{
	/***
	 * Connects to the pub/sub broker / server using configuration parameters
	 * specified by the sub-class.
	 * 
	 * @return bool True on success, False otherwise.
	 */
	public boolean connectClient();

	/**
	 * Disconnects from the pub/sub broker / server if the client is already connected.
	 * If not, this call is ignored, but will return a False.
	 * 
	 * @return bool True on success, False otherwise.
	 */
	public boolean disconnectClient();

	/**
	 * Attempts to send the given data instance to the remote cloud service.
	 * This will default to the pre-configured QoS level set in the configuration
	 * for the cloud service, and use the underlying implementation to 
	 * 
	 * @param resource The resource enum to use for this send request.
	 * @param data The data instance to publish to the remote cloud service.
	 * @return bool True on success, False otherwise.
	 */
	public boolean sendEdgeDataToCloud(ResourceNameEnum resource, SensorData data);

	/**
	 * Attempts to send the given data instance to the remote cloud service.
	 * This will default to the pre-configured QoS level set in the configuration
	 * for the cloud service, and use the underlying implementation to 
	 * 
	 * @param resource The resource enum to use for this send request.
	 * @param data The data instance to publish to the remote cloud service.
	 * @return bool True on success, False otherwise.
	 */
	public boolean sendEdgeDataToCloud(ResourceNameEnum resource, SystemPerformanceData data);

	/**
	 * Attempts to subscribe to events destined for edge consumption that are
	 * sent by the remote cloud service.
	 * 
	 * @param resource The resource enum to use for this subscribe request.
	 * @return bool True on success, False otherwise.
	 */
	public boolean subscribeToCloudEvents(ResourceNameEnum resource);

	/**
	 * Attempts to unsubscribe from events destined for edge consumption that are
	 * sent by the remote cloud service.
	 * 
	 * @param resource The resource enum to use for this subscribe request.
	 * @return bool True on success, False otherwise.
	 */
	public boolean unsubscribeFromCloudEvents(ResourceNameEnum resource);

	/**
	 * Sets the data message listener reference, assuming listener is non-null.
	 * 
	 * @param listener The data message listener instance to use for passing relevant
	 * messages, such as those received from a subscription event.
	 * @return bool True on success (if listener is non-null will always be the case), False otherwise.
	 */
	public boolean setDataMessageListener(IDataMessageListener listener); 
}
