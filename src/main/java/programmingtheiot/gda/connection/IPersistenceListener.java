/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * You may find it more helpful to your design to adjust the
 * functionality, constants and interfaces (if there are any)
 * provided within in order to meet the needs of your specific
 * Programming the Internet of Things project.
 */ 

package programmingtheiot.gda.connection;

import programmingtheiot.data.ActuatorData;
import programmingtheiot.data.SensorData;


/**
 * Interface describing the callbacks to be implemented by
 * the persistence listener implementation.
 * 
 */
public interface IPersistenceListener
{
	
	/**
	 * Callback for handling notifications from the persistence manager.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The source data instance(s).
	 */
	public void onDataPersisted(String topic, int qos, ActuatorData ... data);
	
	/**
	 * Callback for handling notifications from the persistence manager.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The source data instance(s).
	 */
	public void onDataPersisted(String topic, int qos, SensorData ... data);
	
	/**
	 * Callback for handling notifications from the persistence manager.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The source data instance(s).
	 */
	public void onDataReadyToPublish(String topic, int qos, ActuatorData ... data);
	
	/**
	 * Callback for handling notifications from the persistence manager.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The source data instance(s).
	 */
	public void onDataReadyToPublish(String topic, int qos, SensorData ... data);
	
}
