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
 * Interface definition for request/response clients.
 *
 */
public interface IRequestResponseClient
{
	/**
	 * Clears the URI portion of the existing endpoint path, and resets it using
	 * the configured protocol, server, and port as the only part of the endpoint.
	 * 
	 * @param resource
	 */
	public void clearEndpointPath();
	
	/**
	 * Connects to the server and sends a discovery request to the server.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param timeout The number of seconds to wait for a response before returning (default is 5).
	 * @return boolean True on success; False otherwise.
	 */
	public boolean sendDiscoveryRequest(int timeout);

	/**
	 * Connects to the server and sends DELETE request to resource at path.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param resource The resource enum containing the resource path string.
	 * @param name The specific name to append to the resource (null is OK and will be ignored).
	 * @param enableCON If true, CON (confirmed) messaging will be used; otherwise use NON (non-confirmed).
	 * @param timeout The number of seconds to wait for a response before returning (default is 5).
	 * @return boolean True on success; False otherwise.
	 */
	public boolean sendDeleteRequest(ResourceNameEnum resource, String name, boolean enableCON, int timeout);

	/**
	 * Connects to the server and sends GET request for resource at path.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param resource The resource enum containing the resource path string.
	 * @param name The specific name to append to the resource (null is OK and will be ignored).
	 * @param enableCON If true, CON (confirmed) messaging will be used; otherwise use NON (non-confirmed).
	 * @param timeout The number of seconds to wait for a response before returning (default is 5).
	 * @return boolean True on success; False otherwise.
	 */
	public boolean sendGetRequest(ResourceNameEnum resource, String name, boolean enableCON, int timeout);

	/**
	 * Connects to the server and sends POST request of payload to resource at path.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param resource The resource enum containing the resource path string.
	 * @param name The specific name to append to the resource (null is OK and will be ignored).
	 * @param enableCON If true, CON (confirmed) messaging will be used; otherwise use NON (non-confirmed).
	 * @param payload The JSON payload to send.
	 * @param timeout The number of seconds to wait for a response before returning (default is 5).
	 * @return boolean True on success; False otherwise.
	 */
	public boolean sendPostRequest(ResourceNameEnum resource, String name, boolean enableCON, String payload, int timeout);

	/**
	 * Connects to the server and sends GET request for resource at path.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param resource The resource enum containing the resource path string.
	 * @param name The specific name to append to the resource (null is OK and will be ignored).
	 * @param enableCON If true, CON (confirmed) messaging will be used; otherwise use NON (non-confirmed).
	 * @param payload The JSON payload to send.
	 * @param timeout The number of seconds to wait for a response before returning (default is 5).
	 * @return boolean True on success; False otherwise.
	 */
	public boolean sendPutRequest(ResourceNameEnum resource, String name, boolean enableCON, String payload, int timeout);

	/**
	 * Sets the data message listener reference, assuming listener is non-null.
	 * 
	 * @param listener The data message listener instance to use for passing relevant
	 * messages, such as those received from a subscription event.
	 * @return boolean True on success (if listener is non-null will always be the case); False otherwise.
	 */
	public boolean setDataMessageListener(IDataMessageListener listener);
	
	/**
	 * Sets the endpoint path using the given resource. This will use the previously
	 * configured protocol, server, and port as part of the endpoint.
	 * 
	 * @param resource
	 */
	public void setEndpointPath(ResourceNameEnum resource);
	
	/**
	 * Connects to the server and sends a discovery request to the server.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param resource The resource enum containing the resource path string.
	 * @param name The specific name to append to the resource (null is OK and will be ignored).
	 * @param ttl The time to live of the observation. By default, will run for 300 seconds,
	 * then stop. If set to 0 or less, will run indefinitely until stopObserver() is called.
	 * @return boolean True on success; False otherwise.
	 */
	public boolean startObserver(ResourceNameEnum resource, String name, int ttl);

	/**
	 * Connects to the server and sends a discovery request to the server.
	 * IDataMessageListener callback must be set to receive response.
	 * 
	 * @param resourceType The resource enum containing the resource to stop observing.
	 * @param name The specific name to append to the resource (null is OK and will be ignored).
	 * @param timeout The number of seconds to wait for a response before returning (default is 5).
	 * @return boolean True on success; False otherwise.
	 */
	public boolean stopObserver(ResourceNameEnum resourceType, String name, int timeout);
	
}
