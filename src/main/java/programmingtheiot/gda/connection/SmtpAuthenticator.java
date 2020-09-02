/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.gda.connection;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;

/**
 * Simple implementation of the Java mail Authenticator.
 *
 */
public class SmtpAuthenticator extends Authenticator
{
	// constructors
	
	/**
	 * Default.
	 * 
	 */
	public SmtpAuthenticator()
	{
		super();
	}
	
	
	// protected methods
	
	/**
	 * Returns a new instance of {@link PasswordAuthentication},
	 * created from reading the config data managed by {@link ConfigUtil}.
	 * 
	 * @return PasswordAuthentication
	 */
	protected PasswordAuthentication getPasswordAuthentication()
	{
		Properties credProps =
			ConfigUtil.getInstance().loadCredentials(ConfigConst.SMTP_GATEWAY_SERVICE);
		
		return new PasswordAuthentication(
			credProps.getProperty(ConfigConst.USER_NAME_TOKEN_KEY),
			credProps.getProperty(ConfigConst.USER_AUTH_TOKEN_KEY));
	}
	
}
