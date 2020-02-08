package com.sam.constants;

import java.io.File;

public class AppConstants {

	private AppConstants() {

	}

	public static final String DATABASE_CONFIG_PATH = "sam-app-configurations.properties";
	public static final String CREATE_MYSQL_TABLES = "resources" + File.separator + "database" + File.separator
			+ "sam-mysql.sql";

	public static final String CREATE_PSQL_TABLES = "resources" + File.separator + "database" + File.separator
			+ "sam-psql.sql";

	public enum DATABASE_TYPE {
		MYSQL, PSQL
	}

	public static final String APP_FOLDER_NAME = "system_authentication_module";
	public static final String FAILURE_MESSAGE = "FAIL";
	public static final String SUCCESS_MESSAGE = "SUCCESS";
	public static final String technoliteSmsProperties = "technolite-sms.properties";
	public static final String emailConfigurationProperties = "email.properties";
	
	public static final int QUALITY = 55;
	public static final int TIMEOUT = 5000;
	public static final boolean SHOW_PREVIEW_ON = true;
	public static final boolean SHOW_PREVIEW_OFF = false;
	public static final int SCORE = 14000;
}
