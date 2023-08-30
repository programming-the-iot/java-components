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

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.SendFailedException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;

import programmingtheiot.common.IDataMessageListener;
import programmingtheiot.common.ResourceNameEnum;


public class SmtpClientConnector
{
	// static
	
	
	
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
	
	public boolean sendMessage(ResourceNameEnum resource, String payload, int timeout)
	{
		return false;
	}

	public boolean setDataMessageListener(IDataMessageListener listener)
	{
		return false;
	}

	
	// private methods
	
	
}
