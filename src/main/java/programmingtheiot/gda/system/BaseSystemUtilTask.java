/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * It is provided as a simple shell to guide the student and
 * assist with implementation for the Programming the Internet
 * of Things exercises related to the functionality that it
 * will eventually contain.
 */ 

package programmingtheiot.gda.system;

import java.util.logging.Logger;

import programmingtheiot.data.SensorData;

/**
 *
 */
public abstract class BaseSystemUtilTask
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(BaseSystemUtilTask.class.getName());
	
	
	// private
	
	
	// constructors
	
	public BaseSystemUtilTask()
	{
		super();
	}
	
	
	// public methods
	
	public SensorData generateTelemetry()
	{
		return null;
	}
	
	public float getTelemetryValue()
	{
		return 0.0f;
	}
	
	
	// protected methods
	
	/**
	 * Template method definition. Sub-class will implement this to retrieve
	 * the system utilization measure.
	 * 
	 * @return float
	 */
	protected abstract float getSystemUtil();
	
}
