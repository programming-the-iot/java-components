/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.common;

import programmingtheiot.data.ActuatorData;

/**
 * A simple callback interface for handling data messages
 * from a connection.
 *
 */
public interface IActuatorDataListener
{
	/**
	 * Callback signature for data message passing using the given parameters.
	 * 
	 * @param data The ActuatorData data to process.
	 * @return True on success; false otherwise.
	 */
	public boolean onActuatorDataUpdate(ActuatorData data);

}
