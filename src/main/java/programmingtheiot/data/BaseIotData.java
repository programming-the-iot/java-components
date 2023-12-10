/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.data;

import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;

/**
 * Base class for common properties and helper methods for all
 * anticipated parameters and actions shared amongst actuator
 * and sensor data structures within the context of this project.
 *
 */
public abstract class BaseIotData implements Serializable
{
	// static
	
	public static final int DEFAULT_STATUS = 0;
	
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 7388066213262859698L;
	
	// private var's
	
    private String  name       = ConfigConst.NOT_SET;
	private String  timeStamp  = "";
    private int     statusCode = ConfigConst.DEFAULT_STATUS;
    private int     typeID     = ConfigConst.DEFAULT_TYPE_ID;
    
    private String  locationID = ConfigConst.NOT_SET;
    private float   latitude   = ConfigConst.DEFAULT_LAT;
    private float   longitude  = ConfigConst.DEFAULT_LON;
    private float   elevation  = ConfigConst.DEFAULT_ELEVATION;
    
	// NOTE: This is not used by the CDA
    private long    timeStampMillis = 0L;

    
	// constructors
	
	/**
	 * Default.
	 * 
	 * Initializes the location ID from the config file and updates the timestamp.
	 * 
	 */
	protected BaseIotData()
	{
		super();
		
		String locID =
			ConfigUtil.getInstance().getProperty(
				ConfigConst.GATEWAY_DEVICE, ConfigConst.DEVICE_LOCATION_ID_KEY);
		
		this.setLocationID(locID);
		
		updateTimeStamp();
	}
	
	
	// public methods
	
	/**
	 * Returns the elevation value.
	 * 
	 * @return The elevation as a float. Default is {@see ConfigConst.DEFAULT_ELEVATION}
	 */
	public float getElevation()
	{
		return this.elevation;
	}
	
	/**
	 * Returns the latitude value.
	 * 
	 * @return The latitude as a float. Default is {@see ConfigConst.DEFAULT_LATITUDE}
	 */
	public float getLatitude()
	{
		return this.latitude;
	}
	
	/**
	 * Returns the longitude value.
	 * 
	 * @return The longitude as a float. Default is {@see ConfigConst.DEFAULT_LONGITUDE}
	 */
	public float getLongitude()
	{
		return this.longitude;
	}
	
	/**
	 * Returns the location ID.
	 * 
	 * @return The location ID as a String. Default is {@see ConfigConst.NOT_SET}
	 */
	public String getLocationID()
	{
		return this.locationID;
	}
	
	/**
	 * Returns the name.
	 * 
	 * @return The name as a String. Default is {@see ConfigConst.NOT_SET}
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Returns the status code value.
	 * 
	 * @return The status code as an int. Default is {@see ConfigConst.DEFAULT_STATUS}
	 */
	public int getStatusCode()
	{
		return this.statusCode;
	}
	
	/**
	 * Returns the timestamp as a formatted String, based on the millis since the Epoch,
	 * which is set via the {@see #updateTimeStamp()} method.
	 * <p>
	 * The timestamp is represented as a String in ISO 8601 format, as follows:
	 * <p>
	 * e.g. 2020-12-27T10:13:30Z
	 * 
	 * @return A stringified timestamp.
	 */
	public String getTimeStamp()
	{
		return this.timeStamp;
	}
	
	/**
	 * Returns the timestamp in milliseconds since the Epoch.
	 * 
	 * @return long
	 */
	public long getTimeStampMillis()
	{
		return this.timeStampMillis;
	}
	
	/**
	 * Returns the type ID, which can be used as a convenient way to switch
	 * through different IoT data types when processing sub-class instances
	 * of this base class.
	 * 
	 * @return int
	 */
	public int getTypeID()
	{
		return this.typeID;
	}
	
	/**
	 * Checks if the status code is < 0; if so, returns true.
	 * 
	 * @return boolean True if {@see #statusCode} < 0; false otherwise.
	 */
	public boolean hasError()
	{
		return (this.statusCode < 0 ? true : false);
	}
	
	/**
	 * Sets the elevation float value. No validation is performed - can be any float
	 * value permitted by the JVM.
	 * 
	 * @param val The elevation float value to set.
	 */
	public void setElevation(float val)
	{
		this.elevation = val;
	}
	
	/**
	 * Sets the latitude float value. No validation is performed - can be any float
	 * value permitted by the JVM.
	 * 
	 * @param val The latitude float value to set.
	 */
	public void setLatitude(float val)
	{
		this.latitude = val;
	}
	
	/**
	 * Sets the longitude float value. No validation is performed - can be any float
	 * value permitted by the JVM.
	 * 
	 * @param val The longitude float value to set.
	 */
	public void setLongitude(float val)
	{
		this.longitude = val;
	}
	
	/**
	 * Sets the location ID as a string. This can be used as a user-friendly label to
	 * identify a location or specialized name inferring a location.
	 * <p>
	 * Validation rules will check if the ID is non-null and non-empty (post-trim).
	 * If the validation fails, nothing is done.
	 * 
	 * @param id The string-based ID to set.
	 */
	public void setLocationID(String id)
	{
		if (id != null && id.trim().length() > 0) {
			this.locationID = id;
		}
	}
	
	/**
	 * Sets the name as a string. This can be used as a user-friendly label to
	 * identify the IoT data name or device name. It's usually used as the former.
	 * <p>
	 * Validation rules will check if the name is non-null and non-empty (post-trim).
	 * If the validation fails, nothing is done.
	 * 
	 * @param name The string-based name to set.
	 */
	public void setName(String name)
	{
		if (name != null && name.trim().length() > 0) {
			this.name = name;
		}
	}
	
	/**
	 * Sets the status code int value. No validation is performed - can be any int
	 * value permitted by the JVM.
	 * <p>
	 * While any allowable int can be passed in as the parameter, internal rules
	 * will expect a < 0 value to infer an error. This can be changed easily enough
	 * by changing the logic in {@see #hasError()}.
	 * 
	 * @param code The status code int value to set.
	 */
	public void setStatusCode(int code)
	{
		this.statusCode = code;
	}
	
	/**
	 * Sets the type ID int value. No validation is performed - can be any int
	 * value permitted by the JVM.
	 * 
	 * @param id The type ID int value to set.
	 */
	public void setTypeID(int id)
	{
		this.typeID = id;
	}
	
	/**
	 * Returns a string representation of this instance.
	 * 
	 * @return String The string representing this instance, returned in CSV 'key=value' format.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ConfigConst.NAME_PROP).append('=').append(this.name).append(',');
		sb.append(ConfigConst.TYPE_ID_PROP).append('=').append(this.typeID).append(',');
		sb.append(ConfigConst.TIMESTAMP_PROP).append('=').append(this.timeStamp).append(',');
		sb.append(ConfigConst.STATUS_CODE_PROP).append('=').append(this.statusCode).append(',');
		sb.append(ConfigConst.HAS_ERROR_PROP).append('=').append(this.hasError()).append(',');
		sb.append(ConfigConst.LOCATION_ID_PROP).append('=').append(this.locationID).append(',');
		sb.append(ConfigConst.LATITUDE_PROP).append('=').append(this.latitude).append(',');
		sb.append(ConfigConst.LONGITUDE_PROP).append('=').append(this.longitude).append(',');
		sb.append(ConfigConst.ELEVATION_PROP).append('=').append(this.elevation);
		
		return sb.toString();
	}
	
	/**
	 * This is used to apply the properties of the 'data' parameter to the internal structure.
	 * Only basic validation is performed - that is, if the 'data' parameter is null, nothing
	 * is done. Otherwise, all properties - except the timestamp - will be copied over 'as-is'
	 * to the internal class-scoped variables using their respective setter methods.
	 * <p>
	 * Timestamp is generated via a call to {@see #updateTimeStamp()}.
	 * <p>
	 * This will also trigger a call to the template method {@see #handleUpdateData(BaseIotData)},
	 * which is implemented by each sub-class to perform the same work - but specific to each
	 * sub-classes internal class-scoped variables.
	 * 
	 * @param data The BaseIotData instance to copy into the internal class-scoped variables.
	 */
	public void updateData(BaseIotData data)
	{
		if (data != null) {
			updateTimeStamp();
			
			setName(data.getName());
			setTypeID(data.getTypeID());
			setStatusCode(data.getStatusCode());
			setLocationID(data.getLocationID());
			setLatitude(data.getLatitude());
			setLongitude(data.getLongitude());
			setElevation(data.getElevation());
			
			handleUpdateData(data);
		}
	}
	
	
	// protected methods
	
	/**
	 * Template method to handle data update for the sub-class.
	 * 
	 * @param BaseIotData While the parameter must implement this method,
	 * the sub-class is expected to cast the base class to its given type.
	 */
	protected abstract void handleUpdateData(BaseIotData data);
	
	/**
	 * Stores the latest timestamp in milliseconds (since the Epoch) within
	 * {@see #timeStampMillis}, then sets the internal time stamp string
	 * {@see #timeStamp} to represent a new Date based on {@see #timeStampMillis}
	 * in ISO 8601 format using {@see DateTimeFormatter.ISO_INSTANT}, as follows:
	 * <p>
	 * e.g. 2020-12-27T10:13:30Z
	 * 
	 */
	protected final void updateTimeStamp()
	{
		Instant instant = Instant.now();
		
		this.timeStampMillis = instant.toEpochMilli();
		this.timeStamp       = DateTimeFormatter.ISO_INSTANT.format(instant);
	}
	
}
