/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A convenience class to provide type consistency around commonly used
 * topics and resource names.
 * 
 */
public enum ResourceNameEnum
{
	// static
	
	CDA_UPDATE_NOTIFICATIONS_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.UPDATE_NOTIFICATIONS_MSG, false, true),
	CDA_MEDIA_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.MEDIA_MSG, false, false),
	CDA_SENSOR_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.SENSOR_MSG, false, false),
	CDA_ACTUATOR_CMD_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.ACTUATOR_CMD, false, true),
	CDA_ACTUATOR_RESPONSE_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.ACTUATOR_RESPONSE, false, false),
	CDA_MGMT_STATUS_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.MGMT_STATUS_MSG, false, false),
	CDA_MGMT_STATUS_CMD_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.MGMT_STATUS_CMD, false, false),
	CDA_REGISTRATION_REQUEST_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.RESOURCE_REGISTRATION_REQUEST, false, false),
	CDA_SYSTEM_PERF_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.CONSTRAINED_DEVICE, ConfigConst.SYSTEM_PERF_MSG, false, false),
	
	GDA_UPDATE_NOTIFICATIONS_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.GATEWAY_DEVICE, ConfigConst.UPDATE_NOTIFICATIONS_MSG, false, true),
	GDA_MEDIA_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.GATEWAY_DEVICE, ConfigConst.MEDIA_MSG, false, false),
	GDA_MGMT_STATUS_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.GATEWAY_DEVICE, ConfigConst.MGMT_STATUS_MSG, false, false),
	GDA_MGMT_STATUS_CMD_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.GATEWAY_DEVICE, ConfigConst.MGMT_STATUS_CMD, false, false),
	GDA_REGISTRATION_REQUEST_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.GATEWAY_DEVICE, ConfigConst.RESOURCE_REGISTRATION_REQUEST, false, false),
	GDA_SYSTEM_PERF_MSG_RESOURCE(
		ConfigConst.PRODUCT_NAME, ConfigConst.GATEWAY_DEVICE, ConfigConst.SYSTEM_PERF_MSG, false, false);
	
	private static final HashMap<String, ResourceNameEnum> _ResourceNameLookupMap = new HashMap<>();
	
	static {
		for (ResourceNameEnum rn : ResourceNameEnum.values()) {
			_ResourceNameLookupMap.put(rn.getResourceName(), rn);
		}
	}
	
	/**
	 * Convenience method for looking up an enum type based on
	 * the value String. If the lookup fails, null will be returned.
	 * <p>
	 * No error or warning message will be logged, and no exception
	 * will be thrown. If this is called and null is returned, it's
	 * safe to assume that the value simply does not map to any of
	 * the enum type values represented by this class.
	 * 
	 * @param valStr The value of the enum to lookup.
	 * @return ResourceNameEnum The enum instance, or null if not found.
	 */
	public static ResourceNameEnum getEnumFromValue(String valStr)
	{
		if (valStr != null && valStr.length() > 0) {
			if (_ResourceNameLookupMap.containsKey(valStr)) {
				return _ResourceNameLookupMap.get(valStr);
			}
		}
		
		return null;
	}
	
	
	// private var's
	
	private String deviceName = "";
	private String productName = "";
	private String resourceName = "";
	private String resourceType = "";
	private boolean isLocalToGDA = false;
	private boolean isObservable = false;
	
	
	// constructor
	
	/**
	 * Constructor.
	 * 
	 * @param productName
	 * @param deviceName
	 * @param resourceType
	 * @param isLocalToGda
	 * @param isObservable
	 */
	private ResourceNameEnum(String productName, String deviceName, String resourceType, boolean isLocalToGda, boolean isObservable)
	{
		this.resourceName = productName + "/" + deviceName + "/" + resourceType;
		this.productName = productName;
		this.deviceName = deviceName;
		this.resourceType = resourceType;
		this.isLocalToGDA = isLocalToGda;
		this.isObservable = isObservable;
	}
	
	
	// public methods
	
	/**
	 * 
	 * @return String
	 */
	public String getDeviceName()
	{
		return this.deviceName;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getProductName()
	{
		return this.productName;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getResourceName()
	{
		return this.resourceName;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getResourceType()
	{
		return this.resourceType;
	}
	
	/**
	 * 
	 * @return List<String> The ordered list of Strings representing this
	 * resource name split by '/'.
	 */
	public List<String> getResourceNameChain()
	{
		String[] names = this.resourceName.split("/");
		
		List<String> nameList = new ArrayList<>(names.length);
		
		for (String name : names) {
			nameList.add(name);
		}
		
		return nameList;
	}
	
	/**
	 * 
	 * @return boolean True if this resource is local to the GDA (meaning any
	 * use of the resource is internal to the GDA); false if it's not (meaning
	 * it's a resource used by the CDA).
	 */
	public boolean isLocalToGda()
	{
		return this.isLocalToGDA;
	}
	
	/**
	 * 
	 * @return boolean True if this resource should be treated as observable;
	 * false otherwise.
	 */
	public boolean isObservable()
	{
		return this.isObservable;
	}
	
}
