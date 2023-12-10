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
	public static final int    DEFAULT_TTL              = 60;
	
	public static final float  DEFAULT_VAL = 0.0f;
	
	// for purposes of this library, float precision is more then sufficient
	public static final float  DEFAULT_LAT = DEFAULT_VAL;
	public static final float  DEFAULT_LON = DEFAULT_VAL;
	public static final float  DEFAULT_ELEVATION = DEFAULT_VAL;

	public static final int DEFAULT_ACTION_ID = 0;
	public static final int INITIAL_SEQUENCE_NUMBER = 0;
	
	public static final String PRODUCT_NAME = "PIOT";
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
	 * Property Names
	 */

	public static final String NAME_PROP        = "name";
	public static final String DEVICE_ID_PROP   = "deviceID";
	public static final String TYPE_CATEGORY_ID_PROP = "typeCategoryID";
	public static final String TYPE_ID_PROP     = "typeID";
	public static final String TIMESTAMP_PROP   = "timeStamp";
	public static final String HAS_ERROR_PROP   = "hasError";
	public static final String STATUS_CODE_PROP = "statusCode";
	public static final String LOCATION_ID_PROP = "locationID";
	public static final String LATITUDE_PROP    = "latitude";
	public static final String LONGITUDE_PROP   = "longitude";
	public static final String ELEVATION_PROP   = "elevation";
	
	public static final String COMMAND_PROP     = "command";
	public static final String STATE_DATA_PROP  = "stateData";
	public static final String VALUE_PROP       = "value";
	public static final String IS_RESPONSE_PROP = "isResponse";

	public static final String CPU_UTIL_PROP    = "cpuUtil";
	public static final String DISK_UTIL_PROP   = "diskUtil";
	public static final String MEM_UTIL_PROP    = "memUtil";
	
	public static final String SENSOR_DATA_LIST_PROP      = "sensorDataList";
	public static final String SYSTEM_PERF_DATA_LIST_PROP = "systemPerfDataList";
	
	public static final String ACTION_ID_PROP             = "actionID";
	public static final String DATA_URI_PROP              = "dataURI";
	public static final String MESSAGE_PROP               = "message";
	public static final String ENCODING_NAME_PROP         = "encodingName";
	public static final String RAW_DATA_PROP              = "rawData";
	public static final String SEQUENCE_NUMBER_PROP       = "seqNo";
	public static final String USE_SEQUENCE_NUMBER_PROP   = "useSeqNo";
	public static final String SEQUENCE_NUMBER_TOTAL_PROP = "seqNoTotal";
	
	public static final String SEND_RESOURCE_NAME_PROP    = "sendResourceName";
	public static final String RECEIVE_RESOURCE_NAME_PROP = "receiveResourceName";
	public static final String IS_PING_PROP               = "isPing";

	/*****
	 * Resource and Topic Names
	 */

	public static final String SYS_PERF_DATA  = "SysPerfData";
	public static final String SYS_STATE_DATA = "SysStateData";
	
	public static final int    DEFAULT_COMMAND = 0;
	public static final int    DEFAULT_STATUS  = 0;
	public static final int    OFF_COMMAND     = DEFAULT_COMMAND;
	public static final int    ON_COMMAND      = 1;
	public static final int    REBOOT_SYSTEM_COMMAND    = 100;
	public static final int    GET_SYSTEM_STATE_COMMAND = 200;
	
	// these types could be read from a common configuration file
	// used by both the CDA and GDA to avoid hard-coding type ID's
	// within both source trees' ConfigConst modules
	public static final int    DEFAULT_TYPE_ID           =    0;
	public static final int    DEFAULT_TYPE_CATEGORY_ID  =    0;
	public static final int    DEFAULT_ACTUATOR_TYPE     = DEFAULT_TYPE_ID;
	public static final int    DEFAULT_SENSOR_TYPE       = DEFAULT_TYPE_ID;
	
	public static final int    ENV_DEVICE_TYPE           = 1000;
	public static final int    HVAC_ACTUATOR_TYPE        = 1001;
	public static final int    HUMIDIFIER_ACTUATOR_TYPE  = 1002;
	
	public static final int    HUMIDITY_SENSOR_TYPE      = 1010;
	public static final int    PRESSURE_SENSOR_TYPE      = 1012;
	public static final int    TEMP_SENSOR_TYPE          = 1013;
	
	public static final int    DISPLAY_DEVICE_TYPE       = 2000;
	public static final int    LED_ACTUATOR_TYPE         = 2001;
	public static final int    LED_DISPLAY_ACTUATOR_TYPE = 2001;
	
	public static final int    MEDIA_DEVICE_TYPE         = 3000;
	public static final int    CAMERA_SENSOR_TYPE        = 3001;
	
	public static final int    SYSTEM_MGMT_TYPE          = 8000;
	public static final int    RESOURCE_MGMT_TYPE        = 8001;
	
	public static final String RESOURCE_MGMT_NAME = "ResourceMgmt";
	
	public static final int    SYSTEM_PERF_TYPE          = 9000;
	public static final int    CPU_UTIL_TYPE             = 9001;
	public static final int    DISK_UTIL_TYPE            = 9002;
	public static final int    MEM_UTIL_TYPE             = 9003;
	
	public static final String LED_ACTUATOR_NAME        = "LedActuator";
	public static final String HUMIDIFIER_ACTUATOR_NAME = "HumidifierActuator";
	public static final String HVAC_ACTUATOR_NAME       = "HvacActuator";

	// this is included here for testing purposes only
	public static final String TEMP_SENSOR_NAME = "TempSensor";
	
	public static final String CPU_UTIL_NAME  = "CpuUtil";
	public static final String DISK_UTIL_NAME = "DiskUtil";
	public static final String MEM_UTIL_NAME  = "MemUtil";

	public static final String MEDIA_MSG       = "MediaMsg";
	public static final String SENSOR_MSG      = "SensorMsg";
	public static final String ACTUATOR_CMD    = "ActuatorCmd";
	public static final String ACTUATOR_RESPONSE = "ActuatorResponse";
	public static final String MGMT_STATUS_MSG = "MgmtStatusMsg";
	public static final String MGMT_STATUS_CMD = "MgmtStatusCmd";
	public static final String SYSTEM_PERF_MSG = "SystemPerfMsg";
	
	public static final String UPDATE_NOTIFICATIONS_MSG      = "UpdateMsg";
	public static final String RESOURCE_REGISTRATION_REQUEST = "ResourceRegRequest";

	/*****
	 * Configuration Sections, Keys and Defaults
	 */
	
	public static final String DEFAULT_CONFIG_FILE_NAME      = "./config/PiotConfig.props";
	public static final String DEFAULT_CRED_FILE_NAME        = "./cred/PiotCred.props";
	public static final String DEFAULT_KEY_STORE_FILE_NAME   = "./cred/KeyStore.jks";
	public static final String DEFAULT_TRUST_STORE_FILE_NAME = "./cred/TrustStore.jks";
	public static final String DEFAULT_CERT_FILE_NAME        = "./cert/PiotCert.pem";
	
	public static final int DEFAULT_QOS = 0;
	
	public static final String TEST_GDA_DATA_PATH_KEY = "testGdaDataPath";
	public static final String TEST_CDA_DATA_PATH_KEY = "testCdaDataPath";

	public static final String LOCAL   = "Local";
	public static final String MQTT    = "Mqtt";
	public static final String COAP    = "Coap";
	public static final String OPCUA   = "Opcua";
	public static final String SMTP    = "Smtp";
	public static final String DATA    = "Data";
	
	public static final String DEVICE_LOCATION_ID_KEY        = "deviceLocationID";
	
	public static final String ENABLE_MQTT_CLIENT_KEY        = "enableMqttClient";
	public static final String ENABLE_COAP_CLIENT_KEY        = "enableCoapClient";
	public static final String ENABLE_COAP_SERVER_KEY        = "enableCoapServer";
	public static final String ENABLE_CLOUD_CLIENT_KEY       = "enableCloudClient";
	public static final String ENABLE_SMTP_CLIENT_KEY        = "enableSmtpClient";
	public static final String ENABLE_PERSISTENCE_CLIENT_KEY = "enablePersistenceClient";
	public static final String ENABLE_SYSTEM_PERF_KEY        = "enableSystemPerformance";
	
	public static final String ENABLE_RUN_FOREVER_KEY        = "enableRunForever";
	
	public static final String AWS_CLOUD_SVC_NAME     = "AWS";
	public static final String AZURE_CLOUD_SVC_NAME   = "Azure";
	public static final String GCP_CLOUD_SVC_NAME     = "GCP";
	public static final String UBIDOTS_CLOUD_SVC_NAME = "Ubidots";
	
	public static final String AWS_CLOUD_GATEWAY_SERVICE     = CLOUD   + "." + GATEWAY_SERVICE + "." + AWS_CLOUD_SVC_NAME;
	public static final String AZURE_CLOUD_GATEWAY_SERVICE   = CLOUD   + "." + GATEWAY_SERVICE + "." + AZURE_CLOUD_SVC_NAME;
	public static final String GCP_CLOUD_GATEWAY_SERVICE     = CLOUD   + "." + GATEWAY_SERVICE + "." + GCP_CLOUD_SVC_NAME;
	public static final String UBIDOTS_CLOUD_GATEWAY_SERVICE = CLOUD   + "." + GATEWAY_SERVICE + "." + UBIDOTS_CLOUD_SVC_NAME;
	
	public static final String FILE_DATA_SVC_NAME     = "File";
	public static final String INFLUX_DATA_SVC_NAME   = "Influx";
	public static final String REDIS_DATA_SVC_NAME    = "Redis";
	
	public static final String FILE_DATA_GATEWAY_SERVICE   = DATA   + "." + GATEWAY_SERVICE + "." + FILE_DATA_SVC_NAME;
	public static final String INFLUX_DATA_GATEWAY_SERVICE = DATA   + "." + GATEWAY_SERVICE + "." + INFLUX_DATA_SVC_NAME;
	public static final String REDIS_DATA_GATEWAY_SERVICE  = DATA   + "." + GATEWAY_SERVICE + "." + REDIS_DATA_SVC_NAME;
	
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
	
	public static final String BASE_URL_KEY         = "baseUrl";
	public static final String BASE_TOPIC_KEY       = "baseTopic";
	public static final String CLIENT_ENDPOINT_KEY  = "clientEndpoint";

	public static final String PROTOCOL_KEY         = "protocol";
	public static final String HOST_KEY             = "host";
	public static final String PORT_KEY             = "port";
	public static final String SECURE_PORT_KEY      = "securePort";
	public static final String USE_ASYNC_CLIENT_KEY = "useAsyncClient";
	
	public static final String ROOT_CERT_ALIAS = "root";
	
	public static final String KEY_STORE_CLIENT_IDENTITY_KEY = "keyStoreClientIdentity";
	public static final String KEY_STORE_SERVER_IDENTITY_KEY = "keyStoreServerIdentity";
	
	public static final String KEY_STORE_FILE_KEY     = "keyStoreFile";
	public static final String KEY_STORE_AUTH_KEY     = "keyStoreAuth";
	public static final String TRUST_STORE_FILE_KEY   = "trustStoreFile";
	public static final String TRUST_STORE_ALIAS_KEY  = "trustStoreAlias";
	public static final String TRUST_STORE_AUTH_KEY   = "trustStoreAuth";
	public static final String USER_NAME_TOKEN_KEY    = "userToken";
	public static final String USER_AUTH_TOKEN_KEY    = "authToken";
	public static final String API_TOKEN_KEY          = "apiToken";
	
	public static final String CLOUD_SERVICE_NAME_KEY = "cloudServiceName";

	public static final String CONFIG_FILE_KEY      = "configFile";
	public static final String CERT_FILE_KEY        = "certFile";
	public static final String PRIVATE_KEY_FILE_KEY = "privateKeyFile";
	public static final String CRED_FILE_KEY        = "credFile";
	public static final String ENABLE_AUTH_KEY      = "enableAuth";
	public static final String ENABLE_CRYPT_KEY     = "enableCrypt";
	public static final String ENABLE_EMULATOR_KEY  = "enableEmulator";
	public static final String ENABLE_LOGGING_KEY   = "enableLogging";
	public static final String USE_WEB_ACCESS_KEY   = "useWebAccess";
	public static final String POLL_CYCLES_KEY      = "pollCycleSecs";
	public static final String KEEP_ALIVE_KEY       = "keepAlive";
	public static final String DEFAULT_QOS_KEY      = "defaultQos";
	public static final String ENABLE_CON_MSGS_KEY  = "enableConfirmedMsgs";
	
	public static final String IMAGE_PREPROCESS_PATH_KEY = "imgPreprocessPath";
	
	public static final String SMTP_PROP_HOST_KEY       = "mail.smtp.host";
	public static final String SMTP_PROP_PORT_KEY       = "mail.smtp.port";
	public static final String SMTP_PROP_AUTH_KEY       = "mail.smtp.auth";
	public static final String SMTP_PROP_ENABLE_TLS_KEY = "mail.smtp.starttls.enable";

	public static final String TEMP_DATA_PATH_KEY  = "tmpDataPath";
	public static final String TEST_EMPTY_APP_KEY  = "testEmptyApp";

	public static final String ORGANIZATION_KEY    = "organization";
	public static final String DATABASE_KEY        = "database";
	public static final String ENV_DATA_BUCKET_KEY = "envDataBucket";
	public static final String SYS_DATA_BUCKET_KEY = "sysDataBucket";
	
	// constructors
	
	/**
	 * 
	 */
	private ConfigConst()
	{
	}
	
}
