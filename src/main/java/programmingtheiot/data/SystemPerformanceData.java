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
public class SystemPerformanceData extends BaseIotData implements Serializable
{
	// static
	
	
	// private var's
	
    
	// constructors
	
	public SystemPerformanceData()
	{
		super();
	}
	
	
	// public methods
	
	public float getCpuUtilization()
	{
		return 0.0f;
	}
	
	public float getDiskUtilization()
	{
		return 0.0f;
	}
	
	public float getMemoryUtilization()
	{
		return 0.0f;
	}
	
	public void setCpuUtilization(float val)
	{
	}
	
	public void setDiskUtilization(float val)
	{
	}
	
	public void setMemoryUtilization(float val)
	{
	}
	
	
	// protected methods
	
	/* (non-Javadoc)
	 * @see programmingtheiot.data.BaseIotData#handleToString()
	 */
	protected String handleToString()
	{
		return null;
	}
	
	/* (non-Javadoc)
	 * @see programmingtheiot.data.BaseIotData#handleUpdateData(programmingtheiot.data.BaseIotData)
	 */
	protected void handleUpdateData(BaseIotData data)
	{
	}
	
}
