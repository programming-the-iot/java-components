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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.IDataMessageListener;

/**
 * Shell representation of class for student implementation.
 * 
 */
public class SystemPerformanceManager
{
	// private var's
	
	
	// constructors
	
	/**
	 * Default.
	 * 
	 */
	public SystemPerformanceManager()
	{
		this(ConfigConst.DEFAULT_POLL_CYCLES);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param pollSecs The number of seconds between each scheduled task poll.
	 */
	public SystemPerformanceManager(int pollSecs)
	{
	}
	
	
	// public methods
	
	public void handleTelemetry()
	{
	}
	
	public void setDataMessageListener(IDataMessageListener listener)
	{
	}
	
	public void startManager()
	{
	}
	
	public void stopManager()
	{
	}
	
}
