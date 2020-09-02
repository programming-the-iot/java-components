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

import java.lang.management.ManagementFactory;


/**
 * Shell representation of class for student implementation.
 * 
 */
public class SystemCpuUtilTask extends BaseSystemUtilTask
{
	// constructors
	
	/**
	 * Default.
	 * 
	 */
	public SystemCpuUtilTask()
	{
		super();
	}
	
	
	// protected methods
	
	@Override
	protected float getSystemUtil()
	{
		return 0.0f;
	}
	
}
