package com.sam.app;

import java.io.IOException;
import java.sql.SQLException;

import com.sam.constants.AppConstants;
import com.sam.manager.SQLTableManager;

public class CreateTables {

	/**
	 * <strong>Default types of database</strong> <br>
	 * 1) AppConstants.DATABASE_TYPE.MYSQL <br>
	 * 2) AppConstants.DATABASE_TYPE.PSQL
	 * 
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		SQLTableManager tableManager = new SQLTableManager(AppConstants.DATABASE_TYPE.PSQL);
		tableManager.createTables();
	}
}