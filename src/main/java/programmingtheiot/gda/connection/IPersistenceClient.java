/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.gda.connection;

import java.util.Date;

import programmingtheiot.data.ActuatorData;
import programmingtheiot.data.SensorData;
import programmingtheiot.data.SystemPerformanceData;

/**
 * Interface that defines the contract to a data store.
 * 
 */
public interface IPersistenceClient
{
	/**
	 * Connects to the persistence server.
	 * 
	 * @return boolean True on success; false otherwise.
	 */
	public boolean connectClient();
	
	/**
	 * Disconnects from the persistence server.
	 * 
	 * @return boolean True on success; false otherwise.
	 */
	public boolean disconnectClient();
	
	/**
	 * Attempts to retrieve the named data instance from the persistence server.
	 * Will return null if there's no data matching the given type with the
	 * given parameters.
	 * 
	 * @param topic The target topic name.
	 * @param startDate The start date (null if narrowing is not needed).
	 * @param endDate The end date (null if narrowing is not needed).
	 * @return ActuatorData[] The data instance(s) associated with the lookup parameters.
	 */
	public ActuatorData[] getActuatorData(String topic, Date startDate, Date endDate);
	
	/**
	 * Attempts to retrieve the named data instance from the persistence server.
	 * Will return null if there's no data matching the given type with the
	 * given parameters.
	 * 
	 * @param topic The target topic name.
	 * @param startDate The start date (null if narrowing is not needed).
	 * @param endDate The end date (null if narrowing is not needed).
	 * @return SensorData[] The data instance(s) associated with the lookup parameters.
	 */
	public SensorData[] getSensorData(String topic, Date startDate, Date endDate);
	
	/**
	 * Registers the specified {@link programmingtheiot.gda.connection.labbenchstudios.data.IPersistenceListener}
	 * for all {@link #storeData()} calls for the named data type.
	 * 
	 * @param cType The data type to use for storage notifications.
	 * @param listener The listener to notify when data is added.
	 * @param topics The topic name(s) (comma-delimited) to use for notification purposes.
	 * if null, all store requests for any topic will be used to notify the listener.
	 */
	public void registerDataStorageListener(Class cType, IPersistenceListener listener, String ... topics);
	
	/**
	 * Attempts to write the source data instance to the persistence server.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The comma-delimited source data instance(s) to store.
	 * @return boolean True on success; false otherwise.
	 */
	public boolean storeData(String topic, int qos, ActuatorData ... data);
	
	/**
	 * Attempts to write the source data instance to the persistence server.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The comma-delimited source data instance(s) to store.
	 * @return boolean True on success; false otherwise.
	 */
	public boolean storeData(String topic, int qos, SensorData ... data);
	
	/**
	 * Attempts to write the source data instance to the persistence server.
	 * 
	 * @param topic The target topic name.
	 * @param qos The intended target QoS.
	 * @param data The comma-delimited source data instance(s) to store.
	 * @return boolean True on success; false otherwise.
	 */
	public boolean storeData(String topic, int qos, SystemPerformanceData ... data);
	
}
