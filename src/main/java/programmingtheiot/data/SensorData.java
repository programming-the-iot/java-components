/**
 * This class is part of the Programming the Internet of Things project.
 * 
 * It is provided as a simple shell to guide the student and assist with
 * implementation for the Programming the Internet of Things exercises,
 * and designed to be modified by the student as needed.
 */ 

package programmingtheiot.data;

import java.io.Serializable;

/**
 * Shell representation of class for student implementation.
 *
 */
public class SensorData extends BaseIotData implements Serializable
{
	// static
	
	public static final int DEFAULT_SENSOR_TYPE = 0;
	

	// private var's
	
    
	// constructors
	
	public SensorData()
	{
		super();
	}
	
	public SensorData(int sensorType)
	{
		super();
	}
	
	
	// public methods
	
	public float getValue()
	{
		return 0.0f;
	}
	
	public void setValue(float val)
	{
	}
	
	
	// protected methods
	
	/* (non-Javadoc)
	 * @see programmingtheiot.data.BaseIotData#handleUpdateData(programmingtheiot.data.BaseIotData)
	 */
	protected void handleUpdateData(BaseIotData data)
	{
	}
	
}
