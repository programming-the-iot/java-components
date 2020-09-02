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

package programmingtheiot.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * A simple utility class that permits the loading, and in-memory
 * storage, of a given certificate that adheres to X.509 format.
 * 
 */
public class SimpleCertManagementUtil
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SimpleCertManagementUtil.class.getSimpleName());
	
	private static final SimpleCertManagementUtil _Instance = new SimpleCertManagementUtil();
	
	public static final String DEFAULT_SECURE_SOCKET_TYPE = "SSL";
	public static final String DEFAULT_CERTIFICATE_TYPE = "X.509";
	
	/**
	 * Returns the Singleton instance of {@link SimpleCertManagementUtil}.
	 * 
	 * @return CertManagementUtil
	 */
	public static final SimpleCertManagementUtil getInstance()
	{
		return _Instance;
	}
	
	
	// private var's
	
	
	// constructors
	
	/**
	 * Default (private).
	 * 
	 */
	private SimpleCertManagementUtil()
	{
		super();
	}
	
	
	// public methods
	
	/**
	 * Attempts to load the certificate contained in 'fileName'
	 * using the Java {@link KeyStore} and {@link TrustManagerFactory}
	 * functionality.
	 * <p>
	 * This will invoke the {@link #loadCertificate(String, String, String}
	 * method using the default certificate type of {@link #DEFAULT_CERTIFICATE_TYPE}
	 * and default socket type of {@link #DEFAULT_SOCKET_TYPE}.
	 * <p>
	 * On success, the certificate will be loaded by the system, stored
	 * under a unique ID, and mapped to an {@link SSLSocketFactory}, which
	 * is returned to the caller.
	 * <p>
	 * On failure, an exception will be logged, and null will be returned.
	 * 
	 * @param fileName The certificate file name to load.
	 * @return SSLSocketFactory The socket factory initialized with
	 * the loaded certificate.
	 */
	public SSLSocketFactory loadCertificate(String fileName)
	{
		return loadCertificate(fileName, DEFAULT_CERTIFICATE_TYPE, DEFAULT_SECURE_SOCKET_TYPE);
	}
	
	/**
	 * Attempts to load the certificate contained in 'fileName'
	 * using the Java {@link KeyStore} and {@link TrustManagerFactory}
	 * functionality.
	 * <p>
	 * On success, the certificate will be loaded by the system, stored
	 * under a unique ID, and mapped to an {@link SSLSocketFactory}, which
	 * is returned to the caller.
	 * <p>
	 * On failure, an exception will be logged, and null will be returned.
	 * 
	 * @param fileName The certificate file name to load.
	 * @param certType The certificate type to load (e.g. "X.509"). If
	 * null or otherwise invalid (e.g. empty), will use the default
	 * {@link #DEFAULT_CERTIFICATE_TYPE}.
	 * @param socksType The socket type to initialize (e.g. "SSL"). If
	 * null or otherwise invalid (e.g. empty), will use the default
	 * {@link #DEFAULT_SOCKET_TYPE}.
	 * @return SSLSocketFactory The socket factory initialized with
	 * the loaded certificate.
	 */
	public SSLSocketFactory loadCertificate(String fileName, String certType, String socksType)
	{
		if (fileName == null) {
			_Logger.warning("Failed to load certificate. File name is null.");
			
			return null;
		} else {
			if (! new File(fileName).exists()) {
				_Logger.warning(
					"Failed to load certificate. File name doesn't exist: " + fileName);
				
				return null;
			}
		}
		
		if (certType == null || certType.trim().length() == 0) {
			certType = DEFAULT_CERTIFICATE_TYPE;
			
			_Logger.warning(
				"Certificate type is null or empty. Using default: " + certType);
		}
		
		if (socksType == null || socksType.trim().length() == 0) {
			socksType = DEFAULT_SECURE_SOCKET_TYPE;
			
			_Logger.warning(
				"Socket type is null or empty. Using default: " + socksType);
		}
		
		try {
			_Logger.info(
				"Configuring " + socksType +
				" using " + certType +
				" certificate from file: " + fileName);
			
			SSLContext sslContext = SSLContext.getInstance(socksType);
			KeyStore   keyStore   = importCertificate(fileName, certType);
			
			TrustManagerFactory trustManagerFactory =
				TrustManagerFactory.getInstance(
					TrustManagerFactory.getDefaultAlgorithm());
			
			trustManagerFactory.init(keyStore);
			sslContext.init(
				null, trustManagerFactory.getTrustManagers(), new SecureRandom());
			
			_Logger.info(
				certType + " certificate load and " + socksType +
				" socket init successful from file: " + fileName);
				
			return sslContext.getSocketFactory();
		} catch (Exception e) {
			_Logger.log(
				Level.SEVERE,
				"Failed to initialize and load " + certType +
				" certificate from file: " + fileName,
				e);
		}
		
		return null;
	}
	
	
	// private methods
	
	/**
	 * Attempts to import the given certificate file and store as a uniquely
	 * named keystore reference (based on the filename and available bytes.
	 * 
	 * @param fileName The file name of the certificate to process.
	 * @param certType The certificate type to load (e.g. X.509).
	 * @return KeyStore A reference to the {@link KeyStore} containing
	 * the certificate.
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException If an IO exception occurs, or if the file is
	 * available, but has 0 bytes to read.
	 */
	private KeyStore importCertificate(String fileName, String certType)
		throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
	{
	    FileInputStream     fis = null;
	    KeyStore            ks  = null;
	    
	    try {
	    	fis = new FileInputStream(fileName);
	    	ks  = KeyStore.getInstance(KeyStore.getDefaultType());
	    	
	    	BufferedInputStream bis = new BufferedInputStream(fis);
	    	CertificateFactory  cf  = CertificateFactory.getInstance(certType);
	    	
	    	// just want to load the keystore with no parameters, so pass in 'null'
	    	ks.load(null);
	    	
	    	if (bis.available() == 0) {
	    		_Logger.warning(
	    			"No bytes available. Failed to import " + certType +
	    			" from file: " + fileName);
	    		
	    		throw new IOException(
	    			"File exists, but is empty. Can't import " + certType + " certificate.");
	    	} else {
	    		int    certCount   = 0;
	    		File   file        = new File(fileName);
	    		String entryPrefix = file.getName();
	    		
	    		// use while loop as we may have more than one cert in the file
	    		while (bis.available() > 0) {
	    			String      entryName = entryPrefix + "." + bis.available() + "." + ++certCount;
	    			Certificate cert      = cf.generateCertificate(bis);
	    			
	    			ks.setCertificateEntry(entryName, cert);
	    			
	    			_Logger.info(
	    				"Successfully imported " + certType +
	    				" certificate using entry name " + entryName +
	    				" from file: " + fileName);
	    		}
	    	}
	    } finally {
	    	// make sure the FileInputStream is closed in case of exception
	    	if (fis != null) {
	    		try {
	    			fis.close();
	    		} catch (Exception e) {
	    			_Logger.log(
	    				Level.WARNING,
	    				"Failed to close FileInputStream: " + fileName,
	    				e);
	    		} finally {
	    			fis = null;
	    		}
	    	}
	    }
	    
		return ks;		
	}

}
