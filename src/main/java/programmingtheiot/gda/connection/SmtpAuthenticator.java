/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * You may find it more helpful to your design to adjust the
 * functionality, constants and interfaces (if there are any)
 * provided within in order to meet the needs of your specific
 * Programming the Internet of Things project.
 */ 

package programmingtheiot.gda.connection;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

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
			ConfigUtil.getInstance().getCredentials(ConfigConst.SMTP_GATEWAY_SERVICE);
		
		return new PasswordAuthentication(
			credProps.getProperty(ConfigConst.USER_NAME_TOKEN_KEY),
			credProps.getProperty(ConfigConst.USER_AUTH_TOKEN_KEY));
	}
	
}
