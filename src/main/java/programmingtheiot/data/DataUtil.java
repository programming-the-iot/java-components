/**
 * This class is part of the Programming the Internet of Things project.
 * 
 * It is provided as a simple shell to guide the student and assist with
 * implementation for the Programming the Internet of Things exercises,
 * and designed to be modified by the student as needed.
 */ 

package programmingtheiot.data;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.google.gson.Gson;

/**
 * Shell representation of class for student implementation.
 *
 */
public class DataUtil
{
	// static
	
	private static final DataUtil _Instance = new DataUtil();

	/**
	 * Returns the Singleton instance of this class.
	 * 
	 * @return ConfigUtil
	 */
	public static final DataUtil getInstance()
	{
		return _Instance;
	}
	
	
	// private var's
	
	
	// constructors
	
	/**
	 * Default (private).
	 * 
	 */
	private DataUtil()
	{
		super();
	}
	
	
	// public methods
	
	public String actuatorDataToJson(ActuatorData actuatorData)
	{
		return null;
	}
	
	public String sensorDataToJson(SensorData sensorData)
	{
		return null;
	}
	
	public String systemPerformanceDataToJson(SystemPerformanceData sysPerfData)
	{
		return null;
	}
	
	public String systemStateDataToJson(SystemStateData sysStateData)
	{
		return null;
	}
	
	public ActuatorData jsonToActuatorData(String jsonData)
	{
		return null;
	}
	
	public SensorData jsonToSensorData(String jsonData)
	{
		return null;
	}
	
	public SystemPerformanceData jsonToSystemPerformanceData(String jsonData)
	{
		return null;
	}
	
	public SystemStateData jsonToSystemStateData(String jsonData)
	{
		return null;
	}
	
}
