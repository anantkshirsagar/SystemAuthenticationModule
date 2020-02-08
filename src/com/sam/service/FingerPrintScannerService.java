package com.sam.service;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mantra.service.BiometricService;
import com.sam.constants.AppConstants;
import com.sam.manager.FingerEventManager;
import com.sam.manager.FingerPrintValidateManager;
import com.sam.manager.ScoreValidator;

public class FingerPrintScannerService {

	private static final Logger LOG = LoggerFactory.getLogger(FingerPrintScannerService.class);

	public int scanFinger() {
		LOG.debug("Inside scan finger...");
		FingerEventManager fingerEventManager = new FingerEventManager();
		BiometricService biometricService = new BiometricService(fingerEventManager);
		return biometricService.startCapture(AppConstants.QUALITY, AppConstants.TIMEOUT, AppConstants.SHOW_PREVIEW_ON);
	}

	public int validateFinger(HttpServletResponse response) {
		LOG.debug("Inside scan finger...");
		ScoreValidator scoreValidator = new ScoreValidator();
		FingerPrintValidateManager fingerEventManager = new FingerPrintValidateManager(scoreValidator, response);
		BiometricService biometricService = new BiometricService(fingerEventManager);
		return biometricService.startCapture(AppConstants.QUALITY, AppConstants.TIMEOUT, AppConstants.SHOW_PREVIEW_ON);
	}
}
