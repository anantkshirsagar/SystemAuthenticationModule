package com.sam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sam.constants.AppConstants;
import com.sam.constants.CallType;
import com.sam.service.FingerPrintScannerService;

public class FingerPrintScannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(FingerPrintScannerServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = null;
		try {
			String callTypeStr = request.getHeader("callType");
			LOG.debug("Header params callType {}", callTypeStr);
			CallType callType = CallType.valueOf(callTypeStr);
			out = response.getWriter();
			FingerPrintScannerService scannerService = new FingerPrintScannerService();
			switch (callType) {
			case SCAN_FINGER_SERVICE:
				scannerService.scanFinger();
				out.print(AppConstants.SUCCESS_MESSAGE);
				break;
			case VALIDATE_FINGER_SERVICE:
				scannerService.validateFinger(response);
				break;
			}
		} catch (Exception e) {
			out.print(AppConstants.FAILURE_MESSAGE);
			LOG.error("Servlet Exception {}", e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
