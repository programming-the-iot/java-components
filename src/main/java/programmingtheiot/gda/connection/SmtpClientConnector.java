/**
 * This class is part of the Programming the Internet of Things project.
 * 
 * It is provided as a simple shell to guide the student and assist with
 * implementation for the Programming the Internet of Things exercises,
 * and designed to be modified by the student as needed.
 */ 

package programmingtheiot.gda.connection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;

import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;


/**
 * Shell representation of class for student implementation.
 *
 */
public class SmtpClientConnector implements IRequestResponseClient
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SmtpClientConnector.class.getName());
	
	
	// private var's
	
	
	// constructors
	
	/**
	 * Default.
	 * 
	 */
	public SmtpClientConnector()
	{
		super();
	}
	
	
	// public methods
	
	/**
	 * IGNORE THIS METHOD.
	 */
	@Override
	public boolean sendDiscoveryRequest(int timeout)
	{
		// NOTE: No need to implement this!
		
		_Logger.warning("Method not required to be implemented.");
		
		return false;
	}

	/**
	 * IGNORE THIS METHOD.
	 */
	@Override
	public boolean sendDeleteRequest(ResourceNameEnum resource, int timeout)
	{
		// NOTE: No need to implement this!
		
		_Logger.warning("Method not required to be implemented.");
		
		return false;
	}

	/**
	 * IGNORE THIS METHOD.
	 */
	@Override
	public boolean sendGetRequest(ResourceNameEnum resource, int timeout)
	{
		// NOTE: No need to implement this!
		
		_Logger.warning("Method not required to be implemented.");
		
		return false;
	}

	@Override
	public boolean sendPostRequest(ResourceNameEnum resource, String payload, int timeout)
	{
		return configureAndSendMessage(resource, payload.getBytes());
	}

	@Override
	public boolean sendPutRequest(ResourceNameEnum resource, String payload, int timeout)
	{
		return configureAndSendMessage(resource, payload.getBytes());
	}

	@Override
	public boolean setDataMessageListener(IDataMessageListener listener)
	{
		return false;
	}

	/**
	 * IGNORE THIS METHOD.
	 */
	@Override
	public boolean startObserver(ResourceNameEnum resource, int ttl)
	{
		// NOTE: No need to implement this!
		
		_Logger.warning("Method not required to be implemented.");
		
		return false;
	}

	/**
	 * IGNORE THIS METHOD.
	 */
	@Override
	public boolean stopObserver(int timeout)
	{
		// NOTE: No need to implement this!
		
		_Logger.warning("Method not required to be implemented.");
		
		return false;
	}

	
	// private methods
	
	private boolean configureAndSendMessage(ResourceNameEnum resource, byte[] payload)
	{
		return false;
	}
	
	private boolean configureAndSendMessage(ResourceNameEnum resource, String payloadFileName)
	{
		return false;
	}
	
	private boolean sendSmtpMessage(Message smtpMsg)
	{
		return false;
	}
	
	private Message createSmtpMessage(String subject)
	{
		return null;
	}
	
	private void initSmtpSession()
	{
	}
	
}
