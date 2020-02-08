package com.sam.manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mantra.manager.FingerPrintEventManager;
import com.mantra.model.ExportData;
import com.sam.dbservice.ScannerDBService;
import com.sam.model.ExportedFingerData;

import MFS100.MFS100;

public class FingerPrintValidateManager extends FingerPrintEventManager {

	private static final Logger LOG = LoggerFactory.getLogger(FingerPrintValidateManager.class);
	private HttpServletResponse response;
	private ScoreValidator scoreValidator;

	public FingerPrintValidateManager() {
	}

	public FingerPrintValidateManager(ScoreValidator scoreValidator, HttpServletResponse response) {
		this.response = response;
		this.scoreValidator = scoreValidator;
	}

	@Override
	public void capturedData(ExportData exportData) {
		ScannerDBService scannerDBService = new ScannerDBService();

		try {
			ExportedFingerData fingerData = scannerDBService.getFingerData();
			MFS100 mfs100 = new MFS100(this);
			int score = mfs100.MatchANSI(fingerData.getAnsiTemplateData().getData(),
					exportData.getAnsiTemplateData().getData());
			scoreValidator.validateScore(score, response);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			LOG.error("Exception {}", e);
		}
	}
}
