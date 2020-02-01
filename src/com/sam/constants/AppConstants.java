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
	public static final String technoliteSmsProperties = "technolite-sms.properties";
	public static final String emailConfigurationProperties = "email.properties";
}
