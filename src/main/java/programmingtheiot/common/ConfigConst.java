/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * Copyright (c) 2020 by Andrew D. King
 */

package programmingtheiot.common;

/**
 * This class contains various constants and default values
 * that represent config file sections, keys, and other
 * properties that are useful for consistent system operation.
 * 
 */
public class ConfigConst
{
	/*****
	 * General Names and Defaults
	 */
	
	public static final String NOT_SET = "Not Set";
	
	public static final String DEFAULT_HOST             = "localhost";
	public static final String DEFAULT_COAP_PROTOCOL    = "coap";
	public static final String DEFAULT_COAP_SECURE_PROTOCOL = "coaps";
	public static final int    DEFAULT_COAP_PORT        = 5683;
	public static final int    DEFAULT_COAP_SECURE_PORT = 5684;
	public static final String DEFAULT_MQTT_PROTOCOL    = "tcp";
	public static final String DEFAULT_MQTT_SECURE_PROTOCOL = "ssl";
	public static final int    DEFAULT_MQTT_PORT        = 1883;
	public static final int    DEFAULT_MQTT_SECURE_PORT = 8883;
	public static final int    DEFAULT_KEEP_ALIVE       = 60;
	public static final int    DEFAULT_POLL_CYCLES      = 60;

	public static final String PRODUCT_NAME = "ProgrammingIoT";
	public static final String CLOUD        = "Cloud";
	public static final String GATEWAY      = "Gateway";
	public static final String CONSTRAINED  = "Constrained";
	public static final String DEVICE       = "Device";
	public static final String SERVICE      = "Service";

	public static final String CONSTRAINED_DEVICE = CONSTRAINED + DEVICE;
	public static final String GATEWAY_DEVICE     = GATEWAY + DEVICE;
	public static final String GATEWAY_SERVICE    = GATEWAY + SERVICE;
	public static final String CLOUD_SERVICE      = CLOUD + SERVICE;

	/*****
	 * Resource and Topic Names
	 */

	public static final String SENSOR_MSG      = "SensorMsg";
	public static final String ACTUATOR_CMD    = "ActuatorCmd";
	public static final String ACTUATOR_RESPONSE = "ActuatorResponse";
	public static final String MGMT_STATUS_MSG = "MgmtStatusMsg";
	public static final String MGMT_STATUS_CMD = "MgmtStatusCmd";
	public static final String SYSTEM_PERF_MSG = "SystemPerfMsg";

	public static final String CDA_ACTUATOR_CMD_MSG_RESOURCE = PRODUCT_NAME + "/" + CONSTRAINED_DEVICE + "/" + ACTUATOR_CMD;
	public static final String CDA_ACTUATOR_RESPONSE_MSG_RESOURCE = PRODUCT_NAME + "/" + CONSTRAINED_DEVICE + "/" + ACTUATOR_RESPONSE;
	public static final String CDA_MGMT_STATUS_MSG_RESOURCE  = PRODUCT_NAME + "/" + CONSTRAINED_DEVICE + "/" + MGMT_STATUS_MSG;
	public static final String CDA_MGMT_CMD_MSG_RESOURCE     = PRODUCT_NAME + "/" + CONSTRAINED_DEVICE + "/" + MGMT_STATUS_CMD;
	public static final String CDA_SENSOR_DATA_MSG_RESOURCE  = PRODUCT_NAME + "/" + CONSTRAINED_DEVICE + "/" + SENSOR_MSG;
	public static final String CDA_SYSTEM_PERF_MSG_RESOURCE  = PRODUCT_NAME + "/" + CONSTRAINED_DEVICE + "/" + SYSTEM_PERF_MSG;
	
	public static final String GDA_MGMT_STATUS_MSG_RESOURCE  = PRODUCT_NAME + "/" + GATEWAY_DEVICE + "/" + MGMT_STATUS_MSG;
	public static final String GDA_MGMT_CMD_MSG_RESOURCE     = PRODUCT_NAME + "/" + GATEWAY_DEVICE + "/" + MGMT_STATUS_CMD;
	public static final String GDA_SYSTEM_PERF_MSG_RESOURCE  = PRODUCT_NAME + "/" + GATEWAY_DEVICE + "/" + SYSTEM_PERF_MSG;

	/*****
	 * Configuration Sections, Keys and Defaults
	 */
	
	public static final String DEFAULT_CONFIG_FILE_NAME = "./config/PiotConfig.props";
	public static final String DEFAULT_CRED_FILE_NAME   = "./cred/PiotCred.props";
	
	public static final int DEFAULT_QOS = 0;
	
	public static final String TEST_GDA_DATA_PATH_KEY = "testGdaDataPath";
	public static final String TEST_CDA_DATA_PATH_KEY = "testCdaDataPath";

	public static final String LOCAL   = "Local";
	public static final String MQTT    = "Mqtt";
	public static final String COAP    = "Coap";
	public static final String OPCUA   = "Opcua";
	public static final String SMTP    = "Smtp";
	public static final String DATA    = "Data";

	public static final String ENABLE_MQTT_CLIENT_KEY        = "enableMqttClient";
	public static final String ENABLE_COAP_SERVER_KEY        = "enableCoapServer";
	public static final String ENABLE_CLOUD_CLIENT_KEY       = "enableCloudClient";
	public static final String ENABLE_SMTP_CLIENT_KEY        = "enableSmtpClient";
	public static final String ENABLE_PERSISTENCE_CLIENT_KEY = "enablePersistenceClient";
	
	public static final String CLOUD_GATEWAY_SERVICE = CLOUD   + "." + GATEWAY_SERVICE;
	public static final String COAP_GATEWAY_SERVICE  = COAP    + "." + GATEWAY_SERVICE;
	public static final String MQTT_GATEWAY_SERVICE  = MQTT    + "." + GATEWAY_SERVICE;
	public static final String OPCUA_GATEWAY_SERVICE = OPCUA   + "." + GATEWAY_SERVICE;
	public static final String SMTP_GATEWAY_SERVICE  = SMTP    + "." + GATEWAY_SERVICE;
	public static final String DATA_GATEWAY_SERVICE  = DATA    + "." + GATEWAY_SERVICE;

	public static final String FROM_ADDRESS_KEY     = "fromAddr";
	public static final String TO_ADDRESS_KEY       = "toAddr";
	public static final String TO_MEDIA_ADDRESS_KEY = "toMediaAddr";
	public static final String TO_TXT_ADDRESS_KEY   = "toTxtAddr";

	public static final String HOST_KEY             = "host";
	public static final String PORT_KEY             = "port";
	public static final String SECURE_PORT_KEY      = "securePort";

	public static final String USER_NAME_TOKEN_KEY  = "userToken";
	public static final String USER_AUTH_TOKEN_KEY  = "authToken";
	public static final String API_TOKEN_KEY        = "apiToken";

	public static final String CONFIG_FILE_KEY      = "configFile";
	public static final String CERT_FILE_KEY        = "certFile";
	public static final String CRED_FILE_KEY        = "credFile";
	public static final String ENABLE_AUTH_KEY      = "enableAuth";
	public static final String ENABLE_CRYPT_KEY     = "enableCrypt";
	public static final String ENABLE_EMULATOR_KEY  = "enableEmulator";
	public static final String ENABLE_LOGGING_KEY   = "enableLogging";
	public static final String USE_WEB_ACCESS_KEY   = "useWebAccess";
	public static final String POLL_CYCLES_KEY      = "pollCycleSecs";
	public static final String KEEP_ALIVE_KEY       = "keepAlive";
	public static final String DEFAULT_QOS_KEY      = "defaultQos";
	
	public static final String IMAGE_PREPROCESS_PATH_KEY = "imgPreprocessPath";
	
	public static final String SMTP_PROP_HOST_KEY       = "mail.smtp.host";
	public static final String SMTP_PROP_PORT_KEY       = "mail.smtp.port";
	public static final String SMTP_PROP_AUTH_KEY       = "mail.smtp.auth";
	public static final String SMTP_PROP_ENABLE_TLS_KEY = "mail.smtp.starttls.enable";
	
	
	// constructors
	
	/**
	 * 
	 */
	private ConfigConst()
	{
	}
	
}
