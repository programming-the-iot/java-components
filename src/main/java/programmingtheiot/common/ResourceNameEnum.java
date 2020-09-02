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
	
	CDA_SENSOR_MSG_RESOURCE(ConfigConst.CDA_SENSOR_DATA_MSG_RESOURCE),
	CDA_ACTUATOR_CMD_RESOURCE(ConfigConst.CDA_ACTUATOR_CMD_MSG_RESOURCE),
	CDA_MGMT_STATUS_MSG_RESOURCE(ConfigConst.CDA_MGMT_STATUS_MSG_RESOURCE),
	CDA_MGMT_STATUS_CMD_RESOURCE(ConfigConst.CDA_MGMT_CMD_MSG_RESOURCE),
	GDA_MGMT_STATUS_MSG_RESOURCE(ConfigConst.GDA_MGMT_STATUS_MSG_RESOURCE),
	GDA_MGMT_STATUS_CMD_RESOURCE(ConfigConst.GDA_MGMT_CMD_MSG_RESOURCE);
	
	
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
	
	private String resourceName = "";
	
	
	// constructor
	
	/**
	 * Constructor.
	 * 
	 * @param resourceName
	 */
	private ResourceNameEnum(String resourceName)
	{
		this.resourceName = resourceName;
	}
	
	
	// public methods
	
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
}
