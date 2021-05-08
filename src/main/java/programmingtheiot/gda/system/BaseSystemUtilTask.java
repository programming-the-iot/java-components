/**
 * This class is part of the Programming the Internet of Things project.
 * 
 * It is provided as a simple shell to guide the student and assist with
 * implementation for the Programming the Internet of Things exercises,
 * and designed to be modified by the student as needed.
 */ 

package programmingtheiot.gda.system;

import java.util.logging.Logger;

import programmingtheiot.common.ConfigConst;

/**
 *
 */
public abstract class BaseSystemUtilTask
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(BaseSystemUtilTask.class.getName());
	
	
	// private
	
	private String name   = ConfigConst.NOT_SET;
	private int    typeID = ConfigConst.DEFAULT_TYPE_ID;
	
	// constructors
	
	public BaseSystemUtilTask(String name, int typeID)
	{
		super();
	}
	
	
	// public methods
	
	public String getName()
	{
		return null;
	}
	
	/**
	 * Returns the type ID of the system utilization task.
	 * 
	 * @return int
	 */
	public int getTypeID()
	{
		return 0;
	}
	
	/**
	 * Template method definition. Sub-class will implement this to retrieve
	 * the system utilization measure.
	 * 
	 * @return float
	 */
	public abstract float getTelemetryValue();
	
}
