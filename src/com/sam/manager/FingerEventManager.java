package com.sam.manager;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mantra.manager.FingerPrintEventManager;
import com.mantra.model.ExportData;
import com.sam.dbservice.ScannerDBService;
import com.sam.utils.AppUtils;

public class FingerEventManager extends FingerPrintEventManager {

	private static final Logger LOG = LoggerFactory.getLogger(FingerEventManager.class);

	@Override
	public void capturedData(ExportData exportData) {
		ScannerDBService scannerDBService = new ScannerDBService();
		try {
			scannerDBService.deleteFingerData();
			scannerDBService.saveFingerData(AppUtils.getExportFingerData(exportData));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			LOG.error("Exception occured while storing data. {}", e);
		}
	}
}
