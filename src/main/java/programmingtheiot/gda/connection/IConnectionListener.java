/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.gda.connection;


/**
 * Interface contract for handling generic connection state updates.
 * 
 */
public interface IConnectionListener
{
	/**
	 * Callback to be invoked after successful connection.
	 * 
	 */
	public void onConnect();
	
	/**
	 * Callback to be invoked after successful disconnect.0
	 * 
	 */
	public void onDisconnect();
	
}
