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

/**
 * Interface contract for pub/sub clients.
 * 
 */
public interface IPubSubClient
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
	 * Attempts to publish a message to the given topic with the given qos
	 * to the pub/sub broker / server. If not already connected, the sub-class
	 * implementation should either throw an exception, or handle the exception
	 * and log a message, and return False.
	 * 
	 * @param topicEnum The topic Enum containing the topic value to publish the message to.
	 * @param msg The message to publish. This is expected to be well-formed JSON.
	 * @param qos The QoS level. This is expected to be 0 - 2.
	 * @return bool True on success, False otherwise.
	 */
	public boolean publishMessage(ResourceNameEnum topicName, String msg, int qos);

	/**
	 * Attempts to subscribe to a topic with the given qos hosted by the
	 * pub/sub broker / server. If not already connected, the sub-class
	 * implementation should either throw an exception, or handle the exception
	 * and log a message, and return False.
	 * 
	 * @param topicEnum The topic Enum containing the topic value to subscribe to.
	 * @param qos The QoS level. This is expected to be 0 - 2.
	 * @return bool True on success, False otherwise.
	 */
	public boolean subscribeToTopic(ResourceNameEnum topicName, int qos);

	/**
	 * Attempts to unsubscribe from a topic hosted by the pub/sub broker / server.
	 * If not already connected, the sub-class implementation should either
	 * throw an exception, or handle the exception and log a message, and return False.
	 * 
	 * @param topicEnum The topic Enum containing the topic value to unsubscribe from.
	 * @return bool True on success, False otherwise.
	 */
	public boolean unsubscribeFromTopic(ResourceNameEnum topicName);

	/**
	 * Sets the data message listener reference, assuming listener is non-null.
	 * 
	 * @param listener The data message listener instance to use for passing relevant
	 * messages, such as those received from a subscription event.
	 * @return bool True on success (if listener is non-null will always be the case), False otherwise.
	 */
	public boolean setDataMessageListener(IDataMessageListener listener);

	/**
	 * Sets the connection listener reference, assuming listener is non-null.
	 * 
	 * @param listener The connection listener instance to use for passing relevant
	 * connect / disconnect events.
	 * @return bool True on success (if listener is non-null will always be the case), False otherwise.
	 */
	public boolean setConnectionListener(IConnectionListener listener);
	
}
