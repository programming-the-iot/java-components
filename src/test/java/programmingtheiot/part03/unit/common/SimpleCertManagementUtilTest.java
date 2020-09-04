/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */ 

package programmingtheiot.part03.unit.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.logging.Logger;

import javax.net.ssl.SSLSocketFactory;

import org.junit.Before;
import org.junit.Test;

import programmingtheiot.common.SimpleCertManagementUtil;

/**
 * This test case class contains very basic unit tests for
 * SimpleCertManagementUtilTest. It should not be considered complete,
 * but serve as a starting point for the student implementing
 * additional functionality within their Programming the IoT
 * environment.
 *
 */
public class SimpleCertManagementUtilTest
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(SimpleCertManagementUtilTest.class.getName());
	
	/**
	 * NOTE: Copy a valid cert into the given file name, and uncomment
	 * the @Test annotation before {@link #testImportOfCertFromValidFile}
	 * to test.
	 */
	public static final String DIR_PREFIX = "./src/test/java/programmingtheiot/unit/common/";
	
	public static final String TEST_VALID_CERT_FILE    = DIR_PREFIX + "test_cert_validA.pem";
	public static final String TEST_INVALID_CERT_FILEA = DIR_PREFIX + "test_cert_emptyA.pem";
	public static final String TEST_INVALID_CERT_FILEB = DIR_PREFIX + "test_cert_emptyB.pem";
	public static final String TEST_INVALID_CERT_FILEC = DIR_PREFIX + "test_cert_emptyC.pem";
	public static final String TEST_MISSING_CERT_FILE  = DIR_PREFIX + "non_existent_file.pem";
	
	
	// member var's
	
	
	// test setup methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		// make sure test files exist
		File validTestFile    = new File(TEST_VALID_CERT_FILE);
		File invalidTestFileA = new File(TEST_INVALID_CERT_FILEA);
		File invalidTestFileB = new File(TEST_INVALID_CERT_FILEB);
		File invalidTestFileC = new File(TEST_INVALID_CERT_FILEC);
		File missingTestFile  = new File(TEST_MISSING_CERT_FILE);
		
		// TODO: uncomment next LOC after copying a valid PEM file
		//assertTrue(validTestFile.exists());
		
		assertTrue(invalidTestFileA.exists());
		assertTrue(invalidTestFileB.exists());
		assertTrue(invalidTestFileC.exists());
		assertFalse(missingTestFile.exists());
	}
	
	// test methods
	
	/**
	 * Tests {@link SimpleCertManagementUtil} with a certificate file
	 * containing one or more certificates.
	 * <p>
	 * NOTE: To include in JUnit tests, uncomment the @Test annotation.
	 * 
	 */
//	@Test
	public void testImportOfCertFromValidFile()
	{
		SimpleCertManagementUtil certMgr = SimpleCertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_VALID_CERT_FILE);
		
		org.junit.Assert.assertNotNull(factory);
	}
	
	/**
	 * Tests {@link SimpleCertManagementUtil} with a null certificate file.
	 * 
	 */
	@Test
	public void testImportOfCertFromNullFile()
	{
		SimpleCertManagementUtil certMgr = SimpleCertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(null);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link SimpleCertManagementUtil} with an invalid certificate file
	 * containing only the BEGIN / END entries.
	 * 
	 */
	@Test
	public void testImportOfCertFromEmptyFileA()
	{
		SimpleCertManagementUtil certMgr = SimpleCertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_INVALID_CERT_FILEA);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link SimpleCertManagementUtil} with an invalid certificate file
	 * containing invalid text.
	 * 
	 */
	@Test
	public void testImportOfCertFromEmptyFileB()
	{
		SimpleCertManagementUtil certMgr = SimpleCertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_INVALID_CERT_FILEB);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link SimpleCertManagementUtil} with an empty certificate file.
	 * 
	 */
	@Test
	public void testImportOfCertFromEmptyFileC()
	{
		SimpleCertManagementUtil certMgr = SimpleCertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_INVALID_CERT_FILEC);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link SimpleCertManagementUtil} with a non-existent certificate file.
	 * 
	 */
	@Test
	public void testImportOfCertFromNonExistentFile()
	{
		SimpleCertManagementUtil certMgr = SimpleCertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_MISSING_CERT_FILE);
		
		org.junit.Assert.assertNull(factory);
	}
}
